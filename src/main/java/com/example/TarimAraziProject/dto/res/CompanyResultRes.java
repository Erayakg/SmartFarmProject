package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.dto.custom.CustomUserRes;
import com.example.TarimAraziProject.dto.custom.CustomVehicleRes;
import com.example.TarimAraziProject.dto.custom.CustomWarehouseRes;
import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.entities.User;
import com.example.TarimAraziProject.entities.Vehicle;
import com.example.TarimAraziProject.entities.Warehouse;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CompanyResultRes {

    private String name;

    private String email;

    private List<CustomFarmRes> customFarmRes;
    private List<CustomVehicleRes> customVehicleRes;
    private List<CustomWarehouseRes> warehouses;
    private List<CustomUserRes> customUserRes;

}
