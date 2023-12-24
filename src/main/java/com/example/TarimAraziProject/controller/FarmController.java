package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.dto.res.FarmResultRes;
import com.example.TarimAraziProject.repositories.FarmRepository;
import com.example.TarimAraziProject.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public FarmResultRes getAllFarm() {

        return farmService.getAllFarm();

    }

}
