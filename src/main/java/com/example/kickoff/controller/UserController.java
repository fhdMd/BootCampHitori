package com.example.kickoff.controller;

import com.example.kickoff.dto.UserRequestDTO;
import com.example.kickoff.dto.UserResponseDTO;
import com.example.kickoff.model.User;
import com.example.kickoff.repo.UserRepo;
import com.example.kickoff.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping
    public UserResponseDTO insertNewUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }
}
