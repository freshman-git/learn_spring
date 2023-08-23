package org.example.controller;

import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private User user;

    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot!,你好";
    }

    @RequestMapping("/user")
    public User getUser(){
        return user;
    }
}
