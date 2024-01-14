package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.dto.custom.CustomCropRes;
import com.example.TarimAraziProject.dto.custom.CustomSensorRes;
import com.example.TarimAraziProject.dto.custom.CustomTaskRes;
import lombok.Data;

import java.util.List;

@Data
public class FarmResultRes {

    private Float size;

    private Boolean ready;

    private String name;

    List<CustomCropRes> customCropRes;
    List<CustomSensorRes> customSensorRes;

}
