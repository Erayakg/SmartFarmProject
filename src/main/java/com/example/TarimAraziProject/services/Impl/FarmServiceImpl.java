package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.dto.FarmDto;
import com.example.TarimAraziProject.dto.custom.CustomCropRes;
import com.example.TarimAraziProject.dto.custom.CustomMachineRes;
import com.example.TarimAraziProject.dto.custom.CustomSensorRes;
import com.example.TarimAraziProject.dto.custom.CustomTaskRes;
import com.example.TarimAraziProject.dto.res.FarmResultRes;
import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.mapper.FarmMapper;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;
    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository=farmRepository;
    }

    @Override
    public FarmResultRes getAllFarm() {

        List<Farm> farms=new ArrayList<>();
        farms=farmRepository.findAll();
        List<FarmDto> farmDto= FarmMapper.INSTANCE.convert(farms);
        if (farms==null || farms.isEmpty()){
            throw  new RuntimeException();
        }
        FarmResultRes farmResultRes=new FarmResultRes();

        for (FarmDto farmDto1:farmDto){
            farmResultRes.setSize(farmDto1.getSize());
            farmResultRes.setReady(farmDto1.getReady());
            farmResultRes.setType(farmDto1.getType());
            farmResultRes.setUserName(farmDto1.getUser().getUsername());
            farmResultRes.setUserId(farmDto1.getUser().getId());

            List<CustomCropRes> customCropResList = farmDto1.getCrops().stream()
                    .map(crop -> {
                        CustomCropRes customCropRes = new CustomCropRes();
                        customCropRes.setCropAmount(crop.getCropAmount());
                        customCropRes.setName(crop.getName());
                        customCropRes.setPlanting_time(crop.getPlanting_time());
                        return customCropRes;
                    })
                    .collect(Collectors.toList());
            farmResultRes.setCustomCropRes(customCropResList);

            List<CustomTaskRes> customTaskResList = farmDto1.getTasks().stream()
                    .map(task -> {
                        CustomTaskRes customTaskRes = new CustomTaskRes();
                        customTaskRes.setName(task.getName());
                        customTaskRes.setStatement(task.getStatement());
                        customTaskRes.setEndDate(task.getEndDate());
                        customTaskRes.setStartDate(task.getStartDate());
                        return customTaskRes;
                    })
                    .collect(Collectors.toList());
            farmResultRes.setCustomTaskRes(customTaskResList);

            List<CustomMachineRes> customMachineResList = farmDto1.getMachines().stream()
                    .map(machine -> {
                        CustomMachineRes customMachineRes = new CustomMachineRes();
                    customMachineRes.setBrand(machine.getBrand());
                    customMachineRes.setWorking(machine.getWorking());
                    customMachineRes.setType(machine.getType());
                        return customMachineRes;
                    })
                    .collect(Collectors.toList());
            farmResultRes.setCustomMachineRes(customMachineResList);

            List<CustomSensorRes> customSensorResList = farmDto1.getSensors().stream()
                    .map(sensor -> {
                        CustomSensorRes customSensorRes = new CustomSensorRes();
                            customSensorRes.setSensitivity(sensor.getSensitivity());
                            customSensorRes.setType(sensor.getType());
                            customSensorRes.setValue(sensor.getValue());
                        return customSensorRes;
                    })
                    .collect(Collectors.toList());
            farmResultRes.setCustomSensorRes(customSensorResList);
        }
        return farmResultRes;
    }
}
