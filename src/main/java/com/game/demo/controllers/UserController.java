package com.game.demo.controllers;

import com.game.demo.models.User;
import com.game.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("create")
    public User create(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }

    @GetMapping("{id}")
    public User getId(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @GetMapping("getAll")
    public List<User> getAllId(){
        return userRepository.findAll();
    }

}
