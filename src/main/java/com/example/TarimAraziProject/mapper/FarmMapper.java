package com.example.TarimAraziProject.mapper;

import com.example.TarimAraziProject.dto.FarmDto;
import com.example.TarimAraziProject.dto.req.FarmSaveReq;
import com.example.TarimAraziProject.entities.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FarmMapper {
    FarmMapper INSTANCE= Mappers.getMapper(FarmMapper.class);
    List<FarmDto> convert(List<Farm> farm);


    Farm convertFarmToReq(FarmSaveReq farmSaveReq);
}
