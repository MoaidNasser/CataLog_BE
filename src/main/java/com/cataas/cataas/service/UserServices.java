package com.cataas.cataas.service;

import com.cataas.cataas.model.ActivationCode;
import com.cataas.cataas.model.User;
import com.cataas.cataas.repository.ActivationCodeRepository;
import com.cataas.cataas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import static java.sql.DriverManager.println;

@Service
public class UserServices {
    private final UserRepository userRepo;
    private final ActivationCodeRepository activationCodeRepo;
    private final EmailService emailService;

    public UserServices(UserRepository userRepo, ActivationCodeRepository activationCodeRepo, EmailService emailService) {
        this.userRepo = userRepo;
        this.activationCodeRepo = activationCodeRepo;
        this.emailService = emailService;
    }

    public void register(User user) {
        user.setEnabled(false);
        userRepo.save(user);

        String code = String.format("%06d", new Random().nextInt(999999));

        ActivationCode activationCode = new ActivationCode();
        activationCode.setCode(code);
        activationCode.setUser(user);
        activationCode.setExpiryDate(LocalDateTime.now().plusMinutes(15));
        activationCodeRepo.save(activationCode);

        emailService.sendActivationCode(user.getEmail(), code);
    }

    public String verify(String email, String code) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) return "User not found";

        ActivationCode activationCode = activationCodeRepo.findByUser(user);
        if (activationCode == null || !activationCode.getCode().equals(code)) {
            return "Invalid";
        }
        if (activationCode.getExpiryDate().isBefore(LocalDateTime.now())) {
            return "expired";
        }

        user.setEnabled(true);
        userRepo.save(user);
        return "activated";
    }

    public void login(User user) {
      Optional<User> returnedUser =  userRepo.findById(user.getEmail());
      if(returnedUser.isEmpty())
      {
          System.out.println("No such user");
      }

      else
         System.out.println(returnedUser.get().getEmail());
    }
}
