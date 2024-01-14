package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.dto.res.TaskResultRes;
import com.example.TarimAraziProject.entities.Task;

public interface TaskService {

    TaskResultRes harvestFarm(Long farmId,Long CompanyId,Long VehicleId);
    TaskResultRes IrrgateFarm(Long farmId,Long CompanyId,Long VehicleId);
    TaskResultRes PlantingFarm(Long farmId,Long CompanyId,Long VehicleId);


}
