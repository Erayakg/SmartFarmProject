package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.dto.req.CompanySaveReq;
import com.example.TarimAraziProject.dto.res.CompanyResultRes;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.services.Impl.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {
    private CompanyServiceImpl companyService;
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/save")
    public ResponseEntity<RestResponse<CompanyResultRes>> saveCompany(@RequestBody CompanySaveReq companySaveReq){

        CompanyResultRes companyResultRes=companyService.saveCompany(companySaveReq);

        return new ResponseEntity<>(RestResponse.of(companyResultRes), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<RestResponse<Optional<List<CompanyResultRes>>>> getAllCompany(){

        Optional<List<CompanyResultRes>> companyResultRes=companyService.getAllCompany();

        return new ResponseEntity<>(RestResponse.of(companyResultRes), HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Optional<CompanyResultRes>>> getCompanyById(@PathVariable Long id){

        Optional<CompanyResultRes> companyResultRes=companyService.getCompanyById(id);

        return new ResponseEntity<>(RestResponse.of(companyResultRes), HttpStatus.FOUND);
    }


}
