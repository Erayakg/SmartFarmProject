package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.constants.GeneralErrorMessage;
import com.example.TarimAraziProject.constants.VehicleErrorMessage;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.entities.*;
import com.example.TarimAraziProject.entities.builder.TaskBuilder;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToHarvestError;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToIrrigateError;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToPlantError;
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
    public TaskResultRes harvestFarm(Long farmId, Long CompanyId, Long VehicleId) {
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

    @Override
    public TaskResultRes IrrgateFarm(Long farmId, Long companyId, Long vehicleId) {
        Optional<Farm> farmOptional = farmRepository.findById(farmId);
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);

        if (farmOptional.isEmpty()) {
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        if (companyOptional.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }
        if (vehicleOptional.isEmpty()) {
            throw new NotFoundExceptions(VehicleErrorMessage.NOT_FOUND);
        }

        Farm farm = farmOptional.get();
        Vehicle vehicle = vehicleOptional.get();

        if (!farm.getReady()) {
            throw new NotReadyFarmToIrrigateError(FarmErrorMessage.NOT_READY_ERROR);
        }

        Irrigate irrigate = new Irrigate();
        irrigate.setExpense(farm.getSize() * vehicle.getExpensePerKm());

        Task taskWithIrrigate = TaskBuilder.aTask()
                .withName("Irrigation Task")
                .withStatement(false)
                .withFarm(farm)
                .withIrrigate(irrigate)
                .buildWithIrrigate();

        Task savedTask = taskRepository.save(taskWithIrrigate);
        TaskResultRes taskResultRes = createTaskResultResFromTask(savedTask);

        return taskResultRes;
    }

    private TaskResultRes createTaskResultResFromTask(Task task) {
        TaskResultRes taskResultRes = new TaskResultRes();
        taskResultRes.setHarvesting(task.getHarvesting());
        taskResultRes.setName(task.getName());
        taskResultRes.setFertilization(task.getFertilization());
        taskResultRes.setIrrigate(task.getIrrigate());
        taskResultRes.setEndDate(task.getEndDate());
        taskResultRes.setStartDate(task.getStartDate());
        taskResultRes.setStatement(task.getStatement());
        taskResultRes.setFarm(task.getFarm());
        return taskResultRes;
    }

    @Override
    public TaskResultRes PlantingFarm(Long farmId, Long companyId, Long vehicleId) {
        Optional<Farm> farmOptional = farmRepository.findById(farmId);
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);

        if (farmOptional.isEmpty()) {
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        if (companyOptional.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }
        if (vehicleOptional.isEmpty()) {
            throw new NotFoundExceptions(VehicleErrorMessage.NOT_FOUND);
        }

        Farm farm = farmOptional.get();
        Vehicle vehicle = vehicleOptional.get();

        if (!farm.getReady()) {
            throw new NotReadyFarmToPlantError(FarmErrorMessage.NOT_READY_ERROR);
        }

        Planting planting = new Planting();
        planting.setExpense(farm.getSize() * vehicle.getExpensePerKm());

        Task taskWithPlanting = TaskBuilder.aTask()
                .withName("Planting Task")
                .withStatement(false)
                .withFarm(farm)
                .withPlanting(planting)
                .buildWithPlanting();

        Task savedTask = taskRepository.save(taskWithPlanting);
        TaskResultRes taskResultRes = createTaskResultResFromTask(savedTask);

        return taskResultRes;
    }
}
