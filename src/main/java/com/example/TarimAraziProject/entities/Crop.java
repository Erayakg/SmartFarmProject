package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Crop extends BaseEntitiy implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Crop")
    @Column (name = "CROP_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Crop",sequenceName = "CROP_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "CROP_NAME",length = 100,nullable = false)
    private String name;
    @Column(name = "AMOUNT",length = 30,nullable = false)
    private Integer cropAmount;
    @Column(name = "PLANTING_TIME",length = 30,nullable = false)
    private Date Planting_time;
    @ManyToOne
    @JoinColumn(name = "FARM_ID")
    private Farm farm;

}
