package com.example.TarimAraziProject.dto.req;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class WarehouseSaveReq {

    private String name;
    private Float capacity;
    private Double occupancy;
}
