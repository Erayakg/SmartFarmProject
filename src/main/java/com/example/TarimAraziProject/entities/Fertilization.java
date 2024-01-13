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

    @Column(name = "AMOUNT",length = 30,nullable = false)
    private Float fertilizationAmount;

    @Column(name = "FERTILIZATION_EXPENSE")
    private Float expense;

    @OneToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

}
