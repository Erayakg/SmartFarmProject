package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.dto.res.UserResultRes;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<RestResponse<List<UserResultRes>>> getAllUser(){

    List<UserResultRes> userResultRes= userService.getAllUser();

    return new ResponseEntity<>(RestResponse.of(userResultRes), HttpStatus.FOUND);

    }
}
