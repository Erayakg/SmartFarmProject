package com.example.TarimAraziProject.dto;

import com.example.TarimAraziProject.entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class FarmDto {

    private Long id;
    private Float size;
    private String type;
    private Boolean ready;
    private User user;
    private List<Crop> crops;
    private List<Task> tasks;
    private List<Sensor> sensors;

}
