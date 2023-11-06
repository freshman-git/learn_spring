package com.example.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.HttpSender;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id){
        User curUser = userService.getUserById(id);
        return curUser;
    }

    @ResponseBody
    @PostMapping("/send")
    public int send() throws IOException {
        HashMap<String, String> heads = new HashMap<>();
        heads.put("Content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> bizdata = new HashMap<>();
        jsonObject.put("bizdata",bizdata);
        int send = HttpSender.send("http://www.baidu.com", heads, jsonObject.toString());
        return send;
    }


}
