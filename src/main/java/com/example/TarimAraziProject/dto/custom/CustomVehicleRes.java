package com.example.TarimAraziProject.dto.custom;

import com.example.TarimAraziProject.constants.typeEnum.VehicleTypeEnum;
import lombok.Data;

@Data
public class CustomVehicleRes {

    private String vehicleName;

    private VehicleTypeEnum vehicleTypeEnum;
}
