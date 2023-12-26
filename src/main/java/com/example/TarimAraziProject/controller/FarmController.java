package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.dto.req.FarmSaveReq;
import com.example.TarimAraziProject.dto.res.FarmResultRes;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v1/farm")
public class FarmController {
    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }
    @GetMapping("/all")
    public ResponseEntity<RestResponse<FarmResultRes>> getAllFarm() {

        FarmResultRes allFarm = farmService.getAllFarm();

        return new ResponseEntity<>(RestResponse.of(allFarm),HttpStatus.FOUND);
    }
    @PostMapping
    public ResponseEntity<RestResponse<FarmResultRes>> save(@RequestBody FarmSaveReq farmSaveReq) {

        FarmResultRes farmResultRes = farmService.saveFarm(farmSaveReq);

        return new ResponseEntity<>(RestResponse.of(farmResultRes), HttpStatus.CREATED);
    }

}
