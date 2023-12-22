package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Report extends BaseEntitiy{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Report")
    @Column (name = "REPORT_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Report",sequenceName = "REPORT_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "REPORT_NAME",length = 50,nullable = false)
    private String name;
    @Column(name = "REPORT_DETAIL",length = 100,nullable = false)
    private Boolean detail;
    @Column(name = "REPORT_DATE",length = 100,nullable = false)
    private Date date;

    @Column(name = "TASK_ID",length = 30,nullable = false)
    private Long taskId;
    @Column(name = "CROP_ID",length = 30,nullable = false)
    private Long cropId;


}
