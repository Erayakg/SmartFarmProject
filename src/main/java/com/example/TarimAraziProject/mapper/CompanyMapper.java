package com.example.TarimAraziProject.mapper;

import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE= Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "farms", target = "customFarmRes")
    @Mapping(source = "vehicles", target = "customVehicleRes")
    @Mapping(source = "warehouses", target = "warehouses")
    @Mapping(source = "user", target = "customUserRes")
    CompanyResultRes companyToCompanyResultRes(Company company);


    default CompanyResultRes mapOptionalCompany(Optional<Company> company) {
        return company.map(this::companyToCompanyResultRes).orElse(null);
    }

    List<CompanyResultRes> companiesToCompanyResultResList(List<Company> companies);



}
