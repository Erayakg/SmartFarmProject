package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResultRes {

    private String name;
    private Boolean statement;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    Farm farm;
    Fertilization fertilization;
    Harvesting harvesting;
    Irrigate irrigate;
    Planting planting;

}
