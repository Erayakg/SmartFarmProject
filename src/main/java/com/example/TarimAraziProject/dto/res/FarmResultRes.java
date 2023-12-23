package com.example.TarimAraziProject.dto.res;

import com.example.TarimAraziProject.entities.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class FarmResultRes {

    private Float size;
    private String type;
    private Boolean ready;
    private User user;
    private List<Crop> crops;
    private List<Task> tasks;
    private List<Machine> machines;
    private List<Sensor> sensors;

}
