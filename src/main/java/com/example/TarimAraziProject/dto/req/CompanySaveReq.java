package com.example.TarimAraziProject.dto.req;

import com.example.TarimAraziProject.entities.Farm;
import com.example.TarimAraziProject.entities.User;
import com.example.TarimAraziProject.entities.Vehicle;
import com.example.TarimAraziProject.entities.Warehouse;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CompanySaveReq {

    private String name;
    private String email;
    private String password;

}

