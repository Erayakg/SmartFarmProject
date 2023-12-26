package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.constants.UserErrorMessage;
import com.example.TarimAraziProject.dto.custom.CustomCropRes;
import com.example.TarimAraziProject.dto.custom.CustomFarmRes;
import com.example.TarimAraziProject.dto.custom.CustomVehicleRes;
import com.example.TarimAraziProject.dto.custom.CustomWarehouseRes;
import com.example.TarimAraziProject.dto.res.UserResultRes;
import com.example.TarimAraziProject.entities.User;
import com.example.TarimAraziProject.exceptions.customExceptions.UserNotFoundExceptions;
import com.example.TarimAraziProject.repositories.UserRepository;
import com.example.TarimAraziProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResultRes> getAllUser() {

        List<User> user= userRepository.findAll();
        if (user.isEmpty()){
            throw  new UserNotFoundExceptions(UserErrorMessage.NOT_FOUND);
        }
        UserResultRes userResultRes=new UserResultRes();
       for (User user1:user){

           userResultRes.setUsername(user1.getUsername());

           List<CustomFarmRes> customFarmRes = user1.getFarms().stream()
                   .map(farm -> {
                       CustomFarmRes customFarmRes1 = new CustomFarmRes();

                       customFarmRes1.setSize(farm.getSize());
                        customFarmRes1.setReady(farm.getReady());
                        customFarmRes1.setIsActive(farm.getIsActive());
                       return customFarmRes1;
                   })
                   .collect(Collectors.toList());
           userResultRes.setCustomFarmRes(customFarmRes);

           List<CustomVehicleRes> customVehicleRes1 = user1.getVehicles().stream()
                   .map(vehicle -> {
                       CustomVehicleRes customVehicleRes = new CustomVehicleRes();
                       customVehicleRes.setVehicleName(vehicle.getName());
                       return customVehicleRes;
                   })
                   .collect(Collectors.toList());
           userResultRes.setCustomVehicleRes(customVehicleRes1);

           List<CustomWarehouseRes> customWarehouseRes = user1.getWarehouses().stream()
                   .map(warehouse -> {
                       CustomWarehouseRes customWarehouseRes1 = new CustomWarehouseRes();
                       customWarehouseRes1.setCapacity(warehouse.getCapacity());
                       customWarehouseRes1.setOccupancy(warehouse.getOccupancy());
                       customWarehouseRes1.setWarehouseName(warehouse.getName());
                       return customWarehouseRes1;
                   })
                   .collect(Collectors.toList());
           userResultRes.setCustomWarehouseRes(customWarehouseRes);

       }
       return null;
    }

    @Override
    public UserResultRes getUserById(Long userId) {
        return null;
    }

    @Override
    public UserResultRes saveUser() {
        return null;
    }
}
