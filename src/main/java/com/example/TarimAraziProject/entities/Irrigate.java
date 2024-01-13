package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Irrigate extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Irrigate")
    @Column(name = "IRRIGATE_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Irrigate",sequenceName = "IRRIGATE_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "IRRIGATE_EXPENSE")
    private Float expense;

    @OneToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

}
