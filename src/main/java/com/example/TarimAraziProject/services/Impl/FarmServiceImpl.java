package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.dto.req.FarmSaveReq;
import com.example.TarimAraziProject.dto.res.FarmResultRes;
import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.exceptions.BusinessException;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;

    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public FarmResultRes getAllFarm() {


        return null;
    }

    @Override
    public FarmResultRes getFarmById(Long farmId) {

        try {
            Optional<Farm> farm = farmRepository.findById(farmId);
        } catch (Exception e) {
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        return null;

    }

    @Override
    public FarmResultRes deleteFarmById(Long farmId) {
        return null;
    }

    @Override
    public FarmResultRes updateFarmById(Long farmId) {
        return null;
    }

    @Override
    public FarmResultRes saveFarm(FarmSaveReq farmSaveReq) {

        Farm farm=new Farm();
        farm.setName(farmSaveReq.getName());
        farm.setSize(farmSaveReq.getSize());
        Farm savedFarm=farmRepository.save(farm);

        FarmResultRes farmResultRes=new FarmResultRes();
        farmResultRes.setReady(savedFarm.getReady());
        farmResultRes.setName(savedFarm.getName());
        farmResultRes.setSize(savedFarm.getSize());

        return farmResultRes;

    }
}
