package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Farm extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Farm")
    @Column (name = "FARM_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Farm",sequenceName = "FARM_ID_SEQ",allocationSize = 1)
    private Long id;
    @Column (name = "FARM_NAME",length = 30,nullable = false)
    private String name;
    @Column(name = "FARM_SIZE",length = 30,nullable = false)
    private Integer size;
    @Column(name = "USER_ID",length = 30,nullable = false)
    private Long User_id;


}
