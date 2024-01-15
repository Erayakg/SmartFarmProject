package com.example.TarimAraziProject.mapper;

import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.dto.custom.CustomUserRes;
import com.example.TarimAraziProject.dto.custom.CustomVehicleRes;
import com.example.TarimAraziProject.dto.custom.CustomWarehouseRes;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE= Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "farms", target = "customFarmRes")
    @Mapping(source = "vehicles", target = "customVehicleRes")
    @Mapping(source = "warehouses", target = "warehouses")
    @Mapping(source = "user", target = "customUserRes")
    CompanyResultRes companyToCompanyResultRes(Company company);

    default CompanyResultRes mapOptionalCompany(Optional<Company> company) {
        return company.map(this::companyToCompanyResultRes).orElse(null);
    }
    default List<CustomFarmRes> farmsToCustomFarmResList(List<Farm> farms) {
        if (farms!=null){
        return farms.stream()
                .map(farm -> {
                    CustomFarmRes customFarmRes = new CustomFarmRes();
                    customFarmRes.setSize(farm.getSize());
                    customFarmRes.setReady(farm.getReady());
                    return customFarmRes;
                })
                .collect(Collectors.toList());
    }
    return null;
    }

    default List<CustomVehicleRes> vehiclesToCustomVehicleResList(List<Vehicle> vehicles) {
        if (vehicles!=null){
        return vehicles.stream()
                .map(vehicle -> {
                    CustomVehicleRes customVehicleRes = new CustomVehicleRes();
                    customVehicleRes.setVehicleName(vehicle.getName());
                    customVehicleRes.setVehicleTypeEnum(vehicle.getVehicleType());
                    return customVehicleRes;
                })
                .collect(Collectors.toList());}
        return null;
    }

    default List<CustomWarehouseRes> warehousesToCustomWarehouseResList(List<Warehouse> warehouses) {
        if (warehouses!=null){
        return warehouses.stream()
                .map(warehouse -> {
                    CustomWarehouseRes customWarehouseRes = new CustomWarehouseRes();
                    customWarehouseRes.setWarehouseName(warehouse.getName());
                    customWarehouseRes.setCapacity(warehouse.getCapacity());
                    customWarehouseRes.setOccupancy(warehouse.getOccupancy());
                    return customWarehouseRes;
                })
                .collect(Collectors.toList());}
        return null;
    }

    default List<CustomUserRes> usersToCustomUserResList(List<User> users) {
        if (users!=null){
            return users.stream()
                    .map(user -> {
                        CustomUserRes customUserRes = new CustomUserRes();
                        customUserRes.setUsername(user.getUsername());
                        customUserRes.setPassword(user.getPassword());
                        customUserRes.setEmail(user.getEmail());
                        return customUserRes;
                    })
                    .collect(Collectors.toList());
        }
        return null;
    }
    List<CompanyResultRes> companiesToCompanyResultResList(List<Company> companies);



}
