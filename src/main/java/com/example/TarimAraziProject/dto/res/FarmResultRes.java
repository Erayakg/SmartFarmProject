package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.dto.custom.CustomCropRes;
import com.example.TarimAraziProject.dto.custom.CustomMachineRes;
import com.example.TarimAraziProject.dto.custom.CustomSensorRes;
import com.example.TarimAraziProject.dto.custom.CustomTaskRes;
import lombok.Data;

import java.util.List;

@Data
public class FarmResultRes {

    private Float size;
    private String type;
    private Boolean ready;

    private String userName;
    private Long userId;

    List<CustomCropRes> customCropRes;
    List<CustomTaskRes> customTaskRes;
    List<CustomMachineRes> customMachineRes;
    List<CustomSensorRes> customSensorRes;




}
