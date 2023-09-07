package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/getUser")
    public Map<String,Object> getUser(){

        Map<String, Object> allUser = userService.getAllUser();
        return allUser;
    }
}
