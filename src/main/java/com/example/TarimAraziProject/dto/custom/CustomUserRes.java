package com.example.TarimAraziProject.dto.custom;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class CustomUserRes {

    private String username;

    private String password;

    private String email;

}
