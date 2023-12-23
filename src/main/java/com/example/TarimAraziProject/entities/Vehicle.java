package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.constants.enums.VehicleType;
import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Farm")
    @Column(name = "VEHICLE_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "VEHICLE",sequenceName = "VEHICLE_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "VEHICLE_TYPE",length = 30,nullable = false)
    private VehicleType VehicleType;
    @Column(name = "VEHICLE_NAME",length = 30,nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


}
