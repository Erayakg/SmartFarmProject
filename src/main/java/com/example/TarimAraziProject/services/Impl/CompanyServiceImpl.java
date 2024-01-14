package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.CompanyErrorMessage;
import com.example.TarimAraziProject.constants.FarmErrorMessage;
import com.example.TarimAraziProject.constants.GeneralErrorMessage;
import com.example.TarimAraziProject.dto.req.*;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.entities.*;
import com.example.TarimAraziProject.exceptions.BusinessException;
import com.example.TarimAraziProject.exceptions.customExceptions.BadRequestException;
import com.example.TarimAraziProject.exceptions.customExceptions.NotFoundExceptions;
import com.example.TarimAraziProject.mapper.CompanyMapper;
import com.example.TarimAraziProject.repositories.*;
import com.example.TarimAraziProject.services.CompanyService;
import com.example.TarimAraziProject.services.FarmService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final FarmService farmService;
    private final FarmRepository farmRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, FarmService farmService, FarmRepository farmRepository, VehicleRepository vehicleRepository, UserRepository userRepository, WarehouseRepository warehouseRepository) {
        this.companyRepository = companyRepository;
        this.farmService = farmService;
        this.farmRepository = farmRepository;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public CompanyResultRes saveCompany(CompanySaveReq companySaveReq) {
        if (companySaveReq == null) {
            throw new BadRequestException(CompanyErrorMessage.BAD_REQUEST);
        }

        Company company = new Company();
        company.setName(companySaveReq.getName());
        company.setEmail(companySaveReq.getEmail());
        company.setPassword(companySaveReq.getPassword());
        Company company1 = companyRepository.save(company);
        CompanyResultRes companyResultRes = CompanyMapper.INSTANCE.companyToCompanyResultRes(company1);
        return companyResultRes;
    }

    @Override
    public Optional<List<CompanyResultRes>> getAllCompany() {

        List<Company> companyResultRes = new ArrayList<>();
        companyResultRes = companyRepository.findAll();

        List<CompanyResultRes> company = CompanyMapper.INSTANCE.companiesToCompanyResultResList(companyResultRes);

        return Optional.ofNullable(company);
    }

    @Override
    public Optional<CompanyResultRes> getCompanyById(Long id) {

        Optional<Company> companyResultRes = companyRepository.findById(id);
        if (companyResultRes.isEmpty())
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);

        CompanyResultRes company = CompanyMapper.INSTANCE.mapOptionalCompany(companyResultRes);

        return Optional.ofNullable(company);
    }

    @Override
    public CompanyResultRes CompanySaveFarm(Long id, FarmSaveReq farmSaveReq) {

        Optional<Company> optionalCompany = companyRepository.findById(id);
        Farm farm = new Farm();
        farm.setReady(farmSaveReq.getReady());
        farm.setSize(farmSaveReq.getSize());
        farm.setName(farmSaveReq.getName());
        Farm savedFarm = farmRepository.save(farm);

        Optional<Farm> optionalFarm = farmRepository.findById(savedFarm.getId());

        if (optionalFarm.isEmpty()) {
            throw new NotFoundExceptions(FarmErrorMessage.NOT_FOUND);
        }
        if (optionalCompany.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }

        try {

            Company company = optionalCompany.get();
            company.getFarms().add(optionalFarm.get());

            Company savedCompany = companyRepository.save(company);
            CompanyResultRes companyResultRes = CompanyMapper.INSTANCE.companyToCompanyResultRes(savedCompany);
            return companyResultRes;
        } catch (Exception e) {
            throw new BusinessException(GeneralErrorMessage.SAVE_FARM_TO_COMPANY_ERROR);
        }
    }

    @Override
    public CompanyResultRes CompanySaveVehicle(Long id, VehicleSaveReq vehicleSaveReq) {

        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleSaveReq.getVehicleType());
        vehicle.setName(vehicleSaveReq.getName());
        vehicle.setCompany(optionalCompany.get());
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        try {
            Company company = optionalCompany.get();
            company.getVehicles().add(savedVehicle);

            Company savedCompany = companyRepository.save(company);
            CompanyResultRes companyResultRes = CompanyMapper.INSTANCE.companyToCompanyResultRes(savedCompany);
            return companyResultRes;

        } catch (Exception e) {
            throw new BusinessException(GeneralErrorMessage.SAVE_VEHICLE_TO_COMPANY);
        }

    }

    @Override
    public CompanyResultRes CompanySaveUser(Long id, UserSaveReq userSaveReq) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }
        User user = new User();
        user.setUsername(userSaveReq.getUsername());
        user.setEmail(userSaveReq.getEmail());
        user.setPassword(userSaveReq.getPassword());

        User savedUser = userRepository.save(user);

        try {
            Company company = optionalCompany.get();
            company.getUser().add(savedUser);

            Company savedCompany = companyRepository.save(company);
            CompanyResultRes companyResultRes = CompanyMapper.INSTANCE.companyToCompanyResultRes(savedCompany);

            return companyResultRes;

        } catch (Exception e) {
            throw new BusinessException(GeneralErrorMessage.SAVE_USER_TO_FARM);
        }
    }

    @Override
    public CompanyResultRes CompanySaveWareHouse(Long id, WarehouseSaveReq warehouseSaveReq) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isEmpty()) {
            throw new NotFoundExceptions(CompanyErrorMessage.NOT_FOUND);
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseSaveReq.getName());
        warehouse.setCapacity(warehouseSaveReq.getCapacity());
        warehouse.setOccupancy(warehouseSaveReq.getOccupancy());

        Warehouse savedWarehouse = warehouseRepository.save(warehouse);

        try {
            Company company = optionalCompany.get();
            company.getWarehouses().add(savedWarehouse);

            Company savedCompany = companyRepository.save(company);
            CompanyResultRes companyResultRes = CompanyMapper.INSTANCE.companyToCompanyResultRes(savedCompany);

            return companyResultRes;

        } catch (Exception e) {
            throw new BusinessException(GeneralErrorMessage.SAVE_USER_TO_FARM);
        }
    }
}
