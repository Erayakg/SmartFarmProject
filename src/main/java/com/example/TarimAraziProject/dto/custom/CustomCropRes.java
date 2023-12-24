package com.example.TarimAraziProject.dto.custom;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class CustomCropRes {
    private String name;
    private Integer cropAmount;
    private Date Planting_time;
}
