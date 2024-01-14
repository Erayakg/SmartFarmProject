package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.dto.req.*;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    CompanyResultRes saveCompany(CompanySaveReq companySaveReq);

    Optional<List<CompanyResultRes>> getAllCompany();

    Optional<CompanyResultRes> getCompanyById(Long id);

    CompanyResultRes CompanySaveFarm(Long id, FarmSaveReq farmSaveReq);

    CompanyResultRes CompanySaveVehicle(Long id, VehicleSaveReq vehicleSaveReq);

    CompanyResultRes CompanySaveUser(Long id, UserSaveReq userSaveReq);

    CompanyResultRes CompanySaveWareHouse(Long id, WarehouseSaveReq warehouseSaveReq);


}
