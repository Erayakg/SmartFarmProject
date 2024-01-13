package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Planting extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Planting")
    @Column(name = "PLANTING_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Planting",sequenceName = "PLANTING_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "PLANTING_EXPENSE")
    private Float expense;

    @OneToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

}
