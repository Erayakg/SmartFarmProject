package com.example.TarimAraziProject.dto.req;

import com.example.TarimAraziProject.constants.typeEnum.VehicleTypeEnum;
import lombok.Data;

@Data
public class VehicleSaveReq {

    private int  vehicleType;
    private String name;



}
