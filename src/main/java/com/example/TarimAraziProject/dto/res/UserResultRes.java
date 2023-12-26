package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.dto.custom.CustomVehicleRes;
import com.example.TarimAraziProject.dto.custom.CustomWarehouseRes;
import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.entities.Warehouse;
import lombok.Data;

import java.util.List;

@Data
public class UserResultRes {

    private String username;

    List<CustomFarmRes> customFarmRes;
    List<CustomVehicleRes> customVehicleRes;
    List<CustomWarehouseRes> customWarehouseRes;

}
