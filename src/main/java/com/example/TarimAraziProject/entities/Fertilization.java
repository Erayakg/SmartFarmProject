package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Fertilization extends BaseEntitiy{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Fertilization")
    @Column (name = "FERTILIZATION_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Fertilization",sequenceName = "FERTILIZATION_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "FERTILIZATION_NAME",length = 100,nullable = false)
    private String name;
    @Column(name = "AMOUNT",length = 30,nullable = false)
    private Integer fertilizationAmount;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
