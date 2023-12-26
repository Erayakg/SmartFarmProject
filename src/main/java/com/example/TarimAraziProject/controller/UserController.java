package com.example.TarimAraziProject.controller;

import com.example.TarimAraziProject.dto.req.UserSaveReq;
import com.example.TarimAraziProject.dto.res.UserResultRes;
import com.example.TarimAraziProject.general.RestResponse;
import com.example.TarimAraziProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user")

public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping ("/All")
    public ResponseEntity<RestResponse<List<UserResultRes>>> getAllUser(){

    List<UserResultRes> userResultRes= userService.getAllUser();

    return new ResponseEntity<>(RestResponse.of(userResultRes), HttpStatus.FOUND);
    }
    @PostMapping("/save")
    private ResponseEntity<RestResponse<UserResultRes>> saveUser(UserSaveReq userSaveReq){
        UserResultRes userResultRes =userService.saveUser(userSaveReq);
        return new ResponseEntity<>(RestResponse.of(userResultRes),HttpStatus.CREATED);
    }


}
