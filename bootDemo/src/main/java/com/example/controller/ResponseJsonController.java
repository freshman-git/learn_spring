package com.example.controller;

import com.example.pojo.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseJsonController {


    @GetMapping("/getPet")
    @ResponseBody
    public Pet getPet(){
        Pet pet = new Pet();
        pet.setName("a");
        pet.setAge(1);
        return pet;
    }
}
