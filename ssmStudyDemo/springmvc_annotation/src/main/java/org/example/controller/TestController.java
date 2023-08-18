package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test(){
//        System.out.println(1/0);
        return "success";
    }
}
