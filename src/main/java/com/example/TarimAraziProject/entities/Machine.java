package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Machine extends BaseEntitiy{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Machine")
    @Column (name = "MACHINE_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Machine",sequenceName = "MACHINE_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "BRAND",length = 50,nullable = false)
    private String brand;
    @Column(name = "WORKING_STATUS",length = 30,nullable = false)
    private Boolean working;
    @Column(name = "MACHINE_TYPE",length = 50,nullable = false)
    private String type;
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @OneToMany(mappedBy = "machine")
    private List<Task> tasks;

}
