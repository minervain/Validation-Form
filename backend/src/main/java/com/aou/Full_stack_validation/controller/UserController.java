package com.aou.Full_stack_validation.controller;


import com.aou.Full_stack_validation.model.UserEntities;
import com.aou.Full_stack_validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    UserEntities CreateUser(@RequestBody UserEntities newUser){
        return userRepository.save(newUser);

    }

}
