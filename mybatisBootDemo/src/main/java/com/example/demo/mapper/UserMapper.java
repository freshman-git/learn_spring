package com.example.demo.mapper;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserMapper {

    User getUser(String username, String password);

    List<User> getAllUser();
}
