package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Plowing extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Plowing")
    @Column(name = "PLOWING_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Plowing",sequenceName = "PLOWING_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "PLOWING_NAME",length = 100,nullable = false)
    private String name;
    @Column(name = "AMOUNT",length = 30,nullable = false)
    private Integer fertilizationAmount;
    @Column(name = "TASK_ID",nullable = false)
    private Long taskId;
}
