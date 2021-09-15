package com.example.springbootweb.controller;

import com.example.springbootweb.entity.User;
import com.example.springbootweb.repository.UserRepository;
import com.example.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

//    UserService userService;

//    @GetMapping("home")
//    public ResponseEntity<List<User>> getAllUser(){
//        List<User> users = userService.getListUser();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
    @GetMapping("/all")
    public List<User> getAllUser(){
//        return userService.getListUser();
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }
    @GetMapping("/search/{id}")
    public Optional<User> search(@PathVariable Integer id){

        return userRepository.findById(Long.valueOf(id));
    }
    @PostMapping("/uppdate/{id}")
    public List<User> update(@PathVariable Integer id,@RequestBody User user){
        User usu = userRepository.findById(Long.valueOf(id)).get();
        usu.setName(user.getName());
        usu.setEmail(user.getEmail());
        usu.setPhone(user.getPhone());
        usu.setPassword(user.getPassword());
        userRepository.save(usu);
        return userRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        userRepository.deleteById(Long.valueOf(id));
    }
}
