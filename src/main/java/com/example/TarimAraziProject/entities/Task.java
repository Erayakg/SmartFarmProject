package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Task extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Task")
    @Column (name = "TASK_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Task",sequenceName = "TASK_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "TASK_NAME",length = 100,nullable = false)
    private String name;
    @Column(name = "TASK_STATEMENT",length = 100,nullable = false)
    private Integer statement;
    @Column(name = "TASK_DATE",length = 100,nullable = false)
    private Date date;

}
