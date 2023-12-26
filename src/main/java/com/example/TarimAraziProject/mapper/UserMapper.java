package com.example.TarimAraziProject.mapper;

import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.dto.custom.CustomVehicleRes;
import com.example.TarimAraziProject.dto.custom.CustomWarehouseRes;
import com.example.TarimAraziProject.dto.res.UserResultRes;
import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.entities.User;
import com.example.TarimAraziProject.entities.Vehicle;
import com.example.TarimAraziProject.entities.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "farms", target = "customFarmRes")
    @Mapping(source = "vehicles", target = "customVehicleRes")
    @Mapping(source = "warehouses", target = "customWarehouseRes")
    UserResultRes userToUserResultRes(User user);

    @Mapping(source = "size", target = "size")
    @Mapping(source = "ready", target = "ready")
    @Mapping(source = "isActive", target = "isActive")
    CustomFarmRes farmToCustomFarmRes(Farm farm);

    @Mapping(source = "name", target = "vehicleName")
    CustomVehicleRes vehicleToCustomVehicleRes(Vehicle vehicle);

    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "occupancy", target = "occupancy")
    @Mapping(source = "name", target = "warehouseName")
    CustomWarehouseRes warehouseToCustomWarehouseRes(Warehouse warehouse);
}
