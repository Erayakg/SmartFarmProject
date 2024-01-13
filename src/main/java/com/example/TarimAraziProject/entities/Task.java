package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Task extends BaseEntitiy  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Task")
    @Column (name = "TASK_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Task",sequenceName = "TASK_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "TASK_NAME",length = 100,nullable = false)
    private String name;
    @Column(name = "TASK_STATEMENT",length = 100,nullable = false)
    private Boolean statement;
    @Column(name = "START_DATE",length = 100,nullable = false)
    private LocalDateTime startDate;
    @Column(name = "END_DATE",length = 100,nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "FARM_ID")
    private Farm farm;

    @OneToOne(mappedBy = "task")
    private Fertilization fertilization;

    @OneToOne(mappedBy = "task")
    private Harvesting harvesting;

    @OneToOne(mappedBy = "task")
    private Irrigate irrigate;

    @OneToOne(mappedBy = "task")
    private Planting planting;




}
