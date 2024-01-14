package com.example.TarimAraziProject.services.Impl;

import com.example.TarimAraziProject.dto.req.UserSaveReq;
import com.example.TarimAraziProject.dto.res.UserResultRes;
import com.example.TarimAraziProject.repositories.UserRepository;
import com.example.TarimAraziProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResultRes> getAllUser() {
//
//        List<User> user= userRepository.findAll();
//        if (user.isEmpty()){
//            throw  new UserNotFoundExceptions(UserErrorMessage.NOT_FOUND);
//        }
//        List<UserResultRes> userResultsRes=new ArrayList<>();
//       for (User user1:user){
//           UserResultRes userResultRes=new UserResultRes();
//
//           userResultRes.setUsername(user1.getUsername());
//
//           List<CustomFarmRes> customFarmRes = user1.getFarms().stream()
//                   .map(farm -> {
//                       CustomFarmRes customFarmRes1 = new CustomFarmRes();
//
//                       customFarmRes1.setSize(farm.getSize());
//                        customFarmRes1.setReady(farm.getReady());
//                       return customFarmRes1;
//                   })
//                   .collect(Collectors.toList());
//           userResultRes.setCustomFarmRes(customFarmRes);
//
//           List<CustomVehicleRes> customVehicleRes1 = user1.getVehicles().stream()
//                   .map(vehicle -> {
//                       CustomVehicleRes customVehicleRes = new CustomVehicleRes();
//                       customVehicleRes.setVehicleName(vehicle.getName());
//                       return customVehicleRes;
//                   })
//                   .collect(Collectors.toList());
//           userResultRes.setCustomVehicleRes(customVehicleRes1);
//
//           List<CustomWarehouseRes> customWarehouseRes = user1.getWarehouses().stream()
//                   .map(warehouse -> {
//                       CustomWarehouseRes customWarehouseRes1 = new CustomWarehouseRes();
//                       customWarehouseRes1.setCapacity(warehouse.getCapacity());
//                       customWarehouseRes1.setOccupancy(warehouse.getOccupancy());
//                       customWarehouseRes1.setWarehouseName(warehouse.getName());
//                       return customWarehouseRes1;
//                   })
//                   .collect(Collectors.toList());
//           userResultRes.setCustomWarehouseRes(customWarehouseRes);
//            userResultsRes.add(userResultRes);

//       }
        return null;
//       return userResultsRes;
    }

    @Override
    public UserResultRes getUserById(Long userId) {
        return null;
    }

    @Override
    public UserResultRes saveUser(UserSaveReq userSaveReq) {
//        if (userSaveReq ==null){
//            throw new BusinessException(UserErrorMessage.BAD_REQUEST);
//        }
//        User user=new User();
//
//        user.setEmail(userSaveReq.getEmail());
//        user.setUsername(userSaveReq.getUsername());
//        user.setPassword(userSaveReq.getPassword());
//        User saveUser=userRepository.save(user);
//
//        UserResultRes userResultRes=UserMapper.INSTANCE.userToUserResultRes(saveUser);
//
//
//        return userResultRes;
        return null;
    }


}
