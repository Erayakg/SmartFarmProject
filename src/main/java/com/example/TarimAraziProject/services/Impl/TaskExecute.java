package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.services.BTaskService;


public class TaskExecute {
    public static TaskResultRes execute(BTaskService taskService,Long farmId, Long CompanyId, Long VehicleId){
        return taskService.execute(farmId,CompanyId,VehicleId);
    }
}
