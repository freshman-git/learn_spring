package com.example.mybatisplus.controller;

import com.example.mybatisplus.DTO.UserDto;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getAllUser")
    public Map<String, List<User>> getAllUser(@RequestBody UserDto userDto){
        Map<String,List<User>> map = userService.getAllUser(userDto);
        return map;
    }
}
