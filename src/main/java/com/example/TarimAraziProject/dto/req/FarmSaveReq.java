package com.example.TarimAraziProject.dto.req;

import com.example.TarimAraziProject.entities.*;
import lombok.Data;

import java.util.List;
@Data
public class FarmSaveReq {

    private Long id;
    private Float size;
    private String type;
    private Boolean ready;
    private User user;
    private List<Crop> crops;
    private List<Task> tasks;
    private List<Machine> machines;
    private List<Sensor> sensors;


}
