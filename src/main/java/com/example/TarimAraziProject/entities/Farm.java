package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Farm extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Farm")
    @Column(name = "FARM_ID", length = 30, nullable = false)
    @SequenceGenerator(name = "Farm", sequenceName = "FARM_ID_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "FARM_SIZE", length = 30, nullable = false)
    private Float size;
    @Column(name = "FARM_READY", length = 30, nullable = false)
    private Boolean ready;
    @Column(name = "IS_ACTIVE", length = 30, nullable = false)
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "farm")
    private List<Crop> crops;

    @OneToMany(mappedBy = "farm")
    private List<Task> tasks;

    @OneToMany(mappedBy = "farm")
    private List<Machine> machines;

    @OneToMany(mappedBy = "farm")
    private List<Sensor> sensors;


}
