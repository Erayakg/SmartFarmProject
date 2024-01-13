package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.constants.typeEnum.VehicleTypeEnum;
import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "VEHICLE")
    @Column(name = "VEHICLE_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "VEHICLE",sequenceName = "VEHICLE_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "VEHICLE_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vehicleType;

    @Column(name = "VEHICLE_NAME",length = 30,nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;


}
