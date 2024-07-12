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
    @PutMapping("/user/{id}")
    UserEntities updateUser(@RequestBody UserEntities newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());  
                    return userRepository.save(user);
                }).orElseThrow(() -> new userNotFoundException(id));
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new userNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
