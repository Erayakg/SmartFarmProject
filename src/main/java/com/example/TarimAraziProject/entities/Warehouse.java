package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Warehouse extends BaseEntitiy implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Warehouse")
    @Column (name = "WAREHOUSE_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Warehouse",sequenceName = "WAREHOUSE_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "WAREHOUSE_NAME",length = 50,nullable = false)
    private String name;
    @Column(name = "CAPACITY",length = 100,nullable = false)
    private Integer capacity;
    @Column(name = "OCCUPANCY",length = 100,nullable = false)
    private Double occupancy;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
