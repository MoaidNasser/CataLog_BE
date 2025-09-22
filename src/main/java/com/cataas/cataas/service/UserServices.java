package com.cataas.cataas.service;

import com.cataas.cataas.model.User;
import com.cataas.cataas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void login(User user) {
      Optional<User> returnedUser =  userRepository.findById(user.getEmail());
      if(returnedUser.isEmpty())
      {
          System.out.println("No such user");
      }

      else
         System.out.println(returnedUser.get().getEmail());
    }
}
