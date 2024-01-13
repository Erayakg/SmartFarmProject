package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER")
    @Column(name = "USER_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "USER",sequenceName = "USER_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "USER_NAME",length = 30,nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD",length = 30,nullable = false)
    private String password;

    @Column(name = "USER_MAIL",length = 50,nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;


}
