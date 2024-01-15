package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.constants.VehicleErrorMessage;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.entities.*;
import com.example.TarimAraziProject.entities.builder.TaskBuilder;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.exceptions.customExceptions.NotReadyFarmToIrrigateError;
import com.example.TarimAraziProject.repositories.CompanyRepository;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.repositories.TaskRepository;
import com.example.TarimAraziProject.repositories.VehicleRepository;
import com.example.TarimAraziProject.services.BTaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IrrigateFarmService implements BTaskService {

    private final FarmRepository farmRepository;
    private final CompanyRepository companyRepository;
    private final VehicleRepository vehicleRepository;
    private final TaskRepository taskRepository;

    public IrrigateFarmService(FarmRepository farmRepository, CompanyRepository companyRepository, VehicleRepository vehicleRepository, TaskRepository taskRepository) {
        this.farmRepository = farmRepository;
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResultRes execute(Long farmId, Long companyId, Long vehicleId) {
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
}
