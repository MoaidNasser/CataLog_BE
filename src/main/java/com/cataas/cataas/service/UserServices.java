package com.cataas.cataas.service;

import com.cataas.cataas.model.User;
import com.cataas.cataas.repository.UserRepository;
import org.springframework.stereotype.Service;

import static java.sql.DriverManager.println;

@Service
public class UserServices {
    private UserRepository userRepository;

    public UserServices(UserRepository userrepository) {
        this.userRepository = userrepository;
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
