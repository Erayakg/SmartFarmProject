package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.constants.GeneralErrorMessage;
import com.example.TarimAraziProject.constants.VehicleErrorMessage;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.entities.*;
import com.example.TarimAraziProject.entities.builder.TaskBuilder;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToHarvestError;
import com.example.TarimAraziProject.repositories.CompanyRepository;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.repositories.TaskRepository;
import com.example.TarimAraziProject.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HarvestFarmService implements BTaskService {
    private final FarmRepository farmRepository;
    private final CompanyRepository companyRepository;
    private final VehicleRepository vehicleRepository;
    private final TaskRepository taskRepository;

    public HarvestFarmService(FarmRepository farmRepository, CompanyRepository companyRepository, VehicleRepository vehicleRepository, TaskRepository taskRepository) {
        this.farmRepository = farmRepository;
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResultRes execute(Long farmId, Long CompanyId, Long VehicleId) {
        Optional<Farm> farm = farmRepository.findById(farmId);
        Optional<Company> company = companyRepository.findById(CompanyId);

        if (farm.isEmpty()) {
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        if (company.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }

        Harvesting harvesting = new Harvesting();
        Optional<Vehicle> vehicle = vehicleRepository.findById(VehicleId);
        if (vehicle.isEmpty()) {
            throw new NotFoundExceptions(VehicleErrorMessage.NOT_FOUND);
        }


        Vehicle vehicleToUpdate = vehicle.get();
        vehicleToUpdate.setIsActive(false);

        vehicleRepository.save(vehicleToUpdate);

        if (!farm.get().getReady())
            throw new NotReadyFarmToHarvestError(FarmErrorMessage.NOT_READY_ERROR);

        if (farm.get().getCrops() == null) {
            throw new NotReadyFarmToHarvestError(GeneralErrorMessage.NOT_READY_HARVEST);
        }
        harvesting.setCropTypeEnum(farm.get().getCrops().getCropTypeEnum());

        Float expense = farm.get().getSize() * vehicle.get().getExpensePerKm();
        harvesting.setExpense(expense);
        Task taskWithHarvesting = TaskBuilder.aTask()
                .withName("Harvesting Task")
                .withStatement(false)
                .withFarm(farm.get())
                .withHarvesting(harvesting)
                .buildWithHarvesting();

        Task savedTask = taskRepository.save(taskWithHarvesting);
        TaskResultRes taskResultRes = new TaskResultRes();

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
}
