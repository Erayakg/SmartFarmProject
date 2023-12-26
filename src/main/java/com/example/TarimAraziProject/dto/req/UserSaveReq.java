package com.example.TarimAraziProject.dto.req;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserSaveReq {

    private String username;

    private String password;

    private String email;

}
