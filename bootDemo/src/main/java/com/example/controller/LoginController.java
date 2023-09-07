package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class LoginController {


    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String login(String userName,String password){

        return "redirect:/success.html";
    }

    @GetMapping("/success.html")
    public String getSuccess(){
        return "success";
    }

    /**
     * MultipartFile 自动封装上传上来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\tempCache\\"+originalFilename));
        }

        if (photos.length>0){
            for (MultipartFile photo : photos) {
                String currentPhotoName = photo.getOriginalFilename();
                photo.transferTo(new File("E:\\tempCache\\"+currentPhotoName));
            }
        }

        return "success";
    }
}
