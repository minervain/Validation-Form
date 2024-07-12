package com.aou.Full_stack_validation.controller;


import com.aou.Full_stack_validation.exceptions.userNotFoundException;
import com.aou.Full_stack_validation.model.UserEntities;
import com.aou.Full_stack_validation.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    UserEntities CreateUser(@RequestBody UserEntities newUser){
        return userRepository.save(newUser);

    }
    @GetMapping("/user")
    List<UserEntities> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    UserEntities GetUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new userNotFoundException(id));
    }
}
