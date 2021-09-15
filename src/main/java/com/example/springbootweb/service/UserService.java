package com.example.springbootweb.service;

import com.example.springbootweb.entity.User;

import java.util.List;

public interface UserService {

    List<User> getListUser();
    void save(User user);
    void delete(Long id);
}
