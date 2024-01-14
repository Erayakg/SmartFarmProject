package com.example.TarimAraziProject.entities;

import com.example.TarimAraziProject.constants.typeEnum.CropTypeEnum;
import com.example.TarimAraziProject.constants.typeEnum.VehicleTypeEnum;
import com.example.TarimAraziProject.general.BaseEntitiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Crop extends BaseEntitiy  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Crop")
    @Column (name = "CROP_ID",length = 30,nullable = false)
    @SequenceGenerator(name = "Crop",sequenceName = "CROP_ID_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "AMOUNT",length = 30,nullable = false)
    private Float cropAmount;

    @Column(name = "CROP_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private CropTypeEnum cropTypeEnum;

    @OneToOne
    @JoinColumn(name = "FARM_ID")
    private Farm farm;

}
