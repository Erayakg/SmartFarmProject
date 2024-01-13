package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Company")
    @Column(name = "COMPANY_ID", length = 30, nullable = false)
    @SequenceGenerator(name = "COMPANY", sequenceName = "COMPANY_ID_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "COMPANY_NAME", length = 30, nullable = false)
    private String name;
    @Column(name = "COMPANY_EMAIL", length = 30, nullable = false)
    private String email;
    @Column(name = "COMPANY_PASSWORD", length = 30, nullable = false)
    private String password;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Farm> farms;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Warehouse> warehouses;

}
