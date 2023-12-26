package com.example.TarimAraziProject.dto.custom;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomWarehouseRes{
    private String warehouseName;
    private Integer capacity;
    private Double occupancy;
}
