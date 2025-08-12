package com.example.kickoff.controller;

import com.example.kickoff.dto.UserRequestDTO;
import com.example.kickoff.dto.UserResponseDTO;
import com.example.kickoff.service.UserService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService,NewTopic newTopic){this.userService=userService;}

    @PostMapping
    public UserResponseDTO insertNewUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserResponseDTO> getUserById(@PathVariable int id){
        return userService.findById(id);
    }

}
