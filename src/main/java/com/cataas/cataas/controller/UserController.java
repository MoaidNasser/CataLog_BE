package com.cataas.cataas.controller;

import com.cataas.cataas.dto.UserDto;
import com.cataas.cataas.dto.VerifyRequest;
import com.cataas.cataas.model.User;
import com.cataas.cataas.security.JwtUtil;
import com.cataas.cataas.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("signup")
    public void register(@RequestBody User user) {
        userServices.register(user);
    }

    @PostMapping("verify")
    public String verify(@RequestBody VerifyRequest request) {
        return userServices.verify(request.getEmail(), request.getCode());
    }

}
