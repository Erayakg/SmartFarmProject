package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.constants.GeneralErrorMessage;
import com.example.TarimAraziProject.dto.req.TaskSaveReq;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.exceptions.customExceptions.BadRequestException;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/tasks")
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/execute")
    public ResponseEntity<RestResponse<TaskResultRes>>taskExecuteFarm(@RequestBody TaskSaveReq taskSaveReq){
        TaskResultRes taskResultRes=new TaskResultRes();
        switch(taskSaveReq.getTaskType()) {
            case 1:
                 taskResultRes=taskService.harvestFarm(taskSaveReq.getFarmId(),taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());
                break;
            case 2:
                taskResultRes=taskService.PlantingFarm(taskSaveReq.getFarmId(),taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());
                break;
            case 3:
                taskResultRes=taskService.IrrgateFarm(taskSaveReq.getFarmId(),taskSaveReq.getCompanyId(),taskSaveReq.getVehicleId());
                break;
            default:
            throw new BadRequestException(GeneralErrorMessage.UNDEFINED_TASK_TYPE);
        }
        return new ResponseEntity<>(RestResponse.of(taskResultRes), HttpStatus.CREATED);
    }
}
