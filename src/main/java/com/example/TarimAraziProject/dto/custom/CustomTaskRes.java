package com.example.TarimAraziProject.dto.custom;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CustomTaskRes {

    private String name;
    private Boolean statement;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
