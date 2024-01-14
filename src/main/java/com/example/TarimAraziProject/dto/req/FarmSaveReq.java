package com.example.TarimAraziProject.dto.req;

import com.example.TarimAraziProject.entities.*;
import lombok.Data;

import java.util.List;
@Data
public class FarmSaveReq {

    private Float size;
    private Boolean ready;
    private String name;
}
