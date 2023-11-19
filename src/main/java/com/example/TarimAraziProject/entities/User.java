package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Farm")
    @Column(name = "USER_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "USER",sequenceName = "USER_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "USER_NAME",length = 30,nullable = false)
    private String name;
    @Column(name = "USER_SURNAME",length = 30,nullable = false)
    private String surName;
    @Column(name = "USER_MAIL",length = 50,nullable = false)
    private String eMail;
    @Column(name = "USER_PASSWORD",length = 30,nullable = false)
    private String passWord;
    @Column(name = "USER_BIRTHDAY",length = 20)
    private LocalDateTime BirthDay;

}
