package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.Map;

public interface UserService {


    Map<String,Object> getUser(String username, String password);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);

    Map<String, Object> getAllUser();
}
