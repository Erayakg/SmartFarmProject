package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Farm extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Farm")
    @Column (name = "FARM_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Farm",sequenceName = "FARM_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "FARM_SIZE",length = 30,nullable = false)
    private Float size;
    @Column(name = "FARM_TYPE",length = 100,nullable = false)
    private String type;
    @Column(name = "FARM_READY",length = 30,nullable = false)
    private Boolean ready;
    @Column(name = "TASK_ID")
    private Long taskId;
    @Column(name = "SENSOR_ID")
    private Long sensorId;
    @Column(name = "USER_ID")
    private Long userId;




}
