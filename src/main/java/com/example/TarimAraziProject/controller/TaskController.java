package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.constants.GeneralErrorMessage;
import com.example.TarimAraziProject.dto.req.TaskSaveReq;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.exceptions.customExceptions.BadRequestException;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.services.HarvestFarmService;
import com.example.TarimAraziProject.services.Impl.IrrigateFarmService;
import com.example.TarimAraziProject.services.Impl.PlantingFarmService;
import com.example.TarimAraziProject.services.Impl.TaskExecute;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/tasks")
@RestController
public class TaskController {

    private final HarvestFarmService harvestFarmService;
    private final IrrigateFarmService irrigateFarmService;
    private final PlantingFarmService plantingFarmService;

    public TaskController(HarvestFarmService harvestFarmService, IrrigateFarmService irrigateFarmService, PlantingFarmService plantingFarmService) {
        this.harvestFarmService = harvestFarmService;
        this.irrigateFarmService = irrigateFarmService;
        this.plantingFarmService = plantingFarmService;
    }

    @PostMapping("/execute")
    public ResponseEntity<RestResponse<TaskResultRes>>taskExecuteFarm(@RequestBody TaskSaveReq taskSaveReq){
        TaskResultRes taskResultRes=new TaskResultRes();
        switch(taskSaveReq.getTaskType()) {
            case 1:
                TaskExecute.execute(harvestFarmService, taskSaveReq.getFarmId(), taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());
                break;
            case 2:
                TaskExecute.execute(irrigateFarmService, taskSaveReq.getFarmId(), taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());

                break;
            case 3:
                TaskExecute.execute(plantingFarmService, taskSaveReq.getFarmId(), taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());
                break;
            default:
            throw new BadRequestException(GeneralErrorMessage.UNDEFINED_TASK_TYPE);
        }
        return new ResponseEntity<>(RestResponse.of(taskResultRes), HttpStatus.CREATED);
    }
}
