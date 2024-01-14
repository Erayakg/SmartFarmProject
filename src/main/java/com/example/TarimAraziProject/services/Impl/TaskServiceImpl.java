package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.entities.*;
import com.example.TarimAraziProject.entities.builder.TaskBuilder;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToHarvestError;
import com.example.TarimAraziProject.repositories.CompanyRepository;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.repositories.TaskRepository;
import com.example.TarimAraziProject.repositories.VehicleRepository;
import com.example.TarimAraziProject.services.TaskService;
import org.apache.commons.lang3.concurrent.AtomicSafeInitializer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final CompanyRepository companyRepository;
    private final FarmRepository farmRepository;
    private final VehicleRepository vehicleRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(CompanyRepository companyRepository, FarmRepository farmRepository, VehicleRepository vehicleRepository, TaskRepository taskRepository) {
        this.companyRepository = companyRepository;
        this.farmRepository = farmRepository;
        this.vehicleRepository = vehicleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResultRes harvestFarm(Long farmId, Long CompanyId,Long VehicleId) {
        Optional<Farm> farm = farmRepository.findById(farmId);
        Optional<Company> company=companyRepository.findById(CompanyId);

        if (farm.isEmpty()){
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        if (company.isEmpty()){
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }

        Harvesting harvesting=new Harvesting();
        Optional<Vehicle> vehicle=vehicleRepository.findById(VehicleId);
        Vehicle vehicleToUpdate = vehicle.get();
        vehicleToUpdate.setIsActive(false);
        vehicleRepository.save(vehicleToUpdate);

        if (farm.get().getReady())
            throw new NotReadyFarmToHarvestError(FarmErrorMessage.NOT_READY_ERROR);

        harvesting.setCropTypeEnum(farm.get().getCrops().getCropTypeEnum());

        Float expense = farm.get().getSize()*vehicle.get().getExpensePerKm();
        harvesting.setExpense(expense);
        Task taskWithHarvesting = TaskBuilder.aTask()
                .withName("Harvesting Task")
                .withStatement(false)
                .withFarm(farm.get())
                .withHarvesting(harvesting)
                .buildWithHarvesting();

       Task savedTask= taskRepository.save(taskWithHarvesting);
       TaskResultRes taskResultRes=new TaskResultRes();

       taskResultRes.setHarvesting(savedTask.getHarvesting());
       taskResultRes.setName(savedTask.getName());
       taskResultRes.setFertilization(savedTask.getFertilization());
       taskResultRes.setIrrigate(savedTask.getIrrigate());
       taskResultRes.setEndDate(savedTask.getEndDate());
       taskResultRes.setStartDate(savedTask.getStartDate());
       taskResultRes.setStatement(savedTask.getStatement());
       taskResultRes.setFarm(savedTask.getFarm());

       return taskResultRes;
    }

    @Override
    public TaskResultRes IrrgateFarm(Long farmId, Long CompanyId,Long VehicleId) {
        return null;
    }

    @Override
    public TaskResultRes PlantingFarm(Long farmId, Long CompanyId,Long VehicleId) {
        return null;
    }
}
