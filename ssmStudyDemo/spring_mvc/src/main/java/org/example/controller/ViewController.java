package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/view/forward")
    public String testInternalResources(){
        return "forward:/model";
    }

    @RequestMapping("/view/redirect")
    public String testRedirectView(){
        return "redirect:/model";
    }

}
