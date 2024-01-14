package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.constants.typeEnum.CropTypeEnum;
import com.example.TarimAraziProject.constants.typeEnum.VehicleTypeEnum;
import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Harvesting extends BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Harvesting")
    @Column(name = "HARVESTING_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Harvesting",sequenceName = "HARVESTING_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column (name = "HARVESTING_NAME",length = 100,nullable = false)
    private String name;

    @Column(name = "HARVESTING_EXPENSE")
    private Float expense;

    @Column(name = "CROP_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private CropTypeEnum cropTypeEnum;

    @OneToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

}
