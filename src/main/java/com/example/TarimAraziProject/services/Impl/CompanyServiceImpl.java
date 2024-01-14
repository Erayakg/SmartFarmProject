package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.dto.req.*;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.entities.Company;
import com.example.TarimAraziProject.exceptions.customExceptions.BadRequestException;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.mapper.CompanyMapper;
import com.example.TarimAraziProject.repositories.CompanyRepository;
import com.example.TarimAraziProject.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyResultRes saveCompany(CompanySaveReq companySaveReq) {
        if (companySaveReq==null){
            throw new BadRequestException(CompanyErrorMessage.BAD_REQUEST);
        }

        Company company = new Company();
        company.setName(companySaveReq.getName());
        company.setEmail(companySaveReq.getEmail());
        company.setPassword(companySaveReq.getPassword());
        Company company1=companyRepository.save(company);
        CompanyResultRes companyResultRes= CompanyMapper.INSTANCE.companyToCompanyResultRes(company1);
        return companyResultRes;
    }

    @Override
    public Optional<List<CompanyResultRes>> getAllCompany() {

        List<Company> companyResultRes=new ArrayList<>();
        companyResultRes=companyRepository.findAll();

        List<CompanyResultRes> company= CompanyMapper.INSTANCE.companiesToCompanyResultResList(companyResultRes);

        return Optional.ofNullable(company);
    }

    @Override
    public Optional<CompanyResultRes> getCompanyById(Long id) {

        Optional<Company> companyResultRes=companyRepository.findById(id);
        if (companyResultRes.isEmpty())
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);

        CompanyResultRes company= CompanyMapper.INSTANCE.mapOptionalCompany(companyResultRes);

        return Optional.ofNullable(company);
    }

    @Override
    public CompanyResultRes CompanySaveFarm(Long id, FarmSaveReq farmSaveReq) {

        return null;
    }

    @Override
    public CompanyResultRes CompanySaveVehicle(Long id, VehicleSaveReq vehicleSaveReq) {
        return null;
    }

    @Override
    public CompanyResultRes CompanySaveUser(Long id, UserSaveReq userSaveReq) {
        return null;
    }

    @Override
    public CompanyResultRes CompanySaveWareHouse(Long id, WarehouseSaveReq warehouseSaveReq) {
        return null;
    }
}
