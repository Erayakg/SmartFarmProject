package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.dto.res.TaskResultRes;
import org.springframework.stereotype.Service;

@Service
public interface BTaskService {
    TaskResultRes execute(Long farmId, Long CompanyId, Long VehicleId);

}
