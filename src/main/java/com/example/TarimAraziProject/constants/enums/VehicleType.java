package com.example.TarimAraziProject.constants.enums;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;

@Getter
public enum VehicleType {

    VEHICLE_FARM("FARM VEHICLE",0),
    VEHICLE_USER("USER_VEHICLE",0);

    private String VehicleType;
    private Integer isActive;

    VehicleType(String vehicleType, Integer isActive) {
        VehicleType = vehicleType;
        this.isActive = isActive;
    }
}
