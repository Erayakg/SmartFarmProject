package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.dto.req.FarmSaveReq;
import com.example.TarimAraziProject.dto.res.FarmResultRes;

public interface FarmService {
    FarmResultRes getAllFarm();
    FarmResultRes getFarmById(Long farmId);
    FarmResultRes deleteFarmById(Long farmId);
    FarmResultRes updateFarmById(Long farmId);
    FarmResultRes saveFarm(FarmSaveReq farmSaveReq);


}
