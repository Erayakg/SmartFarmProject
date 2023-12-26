package com.example.TarimAraziProject.services;

import com.example.TarimAraziProject.dto.res.UserResultRes;

import java.util.List;

public interface UserService {
      List<UserResultRes> getAllUser();
      UserResultRes getUserById(Long userId);
      UserResultRes saveUser();

}
