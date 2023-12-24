package com.example.TarimAraziProject.dto;

import com.example.TarimAraziProject.entities.Farm;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class CropDTO {

    private Long id;
    private String name;
    private Integer cropAmount;
    private Date Planting_time;
    private Farm farm;
}
