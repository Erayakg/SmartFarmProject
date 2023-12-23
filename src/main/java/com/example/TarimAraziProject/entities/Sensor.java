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
public class Sensor extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Sensor")
    @Column (name = "SENSOR_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Sensor",sequenceName = "SENSOR_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "SENSOR_TYPE",length = 50,nullable = false)
    private String type;
    @Column(name = "SENSOR_VALUE",length = 100,nullable = false)
    private Integer value;
    @Column(name = "SENSITIVITY",length = 100,nullable = false)
    private Double sensitivity;
    @ManyToOne
    @JoinColumn(name = "FARM_ID")
    private Farm farm;
}
