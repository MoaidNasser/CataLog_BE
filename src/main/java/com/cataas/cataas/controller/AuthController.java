package com.cataas.cataas.controller;

import com.cataas.cataas.model.User;
import com.cataas.cataas.repository.UserRepository;
import com.cataas.cataas.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(loginRequest.getPassword()) || !user.isEnabled()) {
            throw new RuntimeException("Invalid password || Not activated");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}
