package com.cataas.cataas.controller;

import com.cataas.cataas.dto.UserDto;
import com.cataas.cataas.model.User;
import com.cataas.cataas.service.UserServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:59262")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("signup")
    public void register(@RequestBody User user) {

        userServices.register(user);
        System.out.println(user);
    }
}
