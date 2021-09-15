package com.example.springbootweb.service;

import com.example.springbootweb.entity.User;
import com.example.springbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
