package com.example.mybatisplus.service;

import com.example.mybatisplus.DTO.UserDto;
import com.example.mybatisplus.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, List<User>> getAllUser(UserDto userDto);
}
