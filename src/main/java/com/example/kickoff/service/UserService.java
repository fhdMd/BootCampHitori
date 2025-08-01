package com.example.kickoff.service;

import com.example.kickoff.config.Config;
import com.example.kickoff.dto.UserRequestDTO;
import com.example.kickoff.dto.UserResponseDTO;
import com.example.kickoff.model.User;
import com.example.kickoff.repo.UserRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Argon2PasswordEncoder encoder;
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo,Argon2PasswordEncoder encoder){
        this.userRepo=userRepo;
        this.encoder=encoder;
        ;
    }
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User newUser=new User(userRequestDTO);
        newUser.setPassword(encoder.encode(userRequestDTO.getPassword()));
        userRepo.save(newUser);
        return new UserResponseDTO(newUser);
    }
}
