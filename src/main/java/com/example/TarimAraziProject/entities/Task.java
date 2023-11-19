package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Task")
    @Column(name = "TASK_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Task",sequenceName = "TASK_ID_SEQ",allocationSize = 1)
    private Long id;


}
