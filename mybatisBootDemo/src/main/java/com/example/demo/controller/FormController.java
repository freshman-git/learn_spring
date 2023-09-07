package com.example.demo.controller;

import com.example.demo.VO.ResponseResult;
import com.example.demo.VO.ResultEnumCode;
import com.example.demo.pojo.Form;
import com.example.demo.pojo.SimpleUser;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
//@CrossOrigin
public class FormController {

    @Autowired
    private UserService userService;

//    @ResponseBody
//    @PostMapping("/save")
//    public String getFormMsg(HttpServletRequest request,Model model){
////        return "redirect:/success.html";
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        model.addAttribute("username",username);
//        model.addAttribute("password",password);
//        return "success";
//    }



    @ResponseBody
    @PostMapping("/save")
    public Map<String,Object> getFormMsg(HttpServletRequest request, Model model){
        String[] items = request.getParameterValues("items");
        System.out.println(items);
        model.addAttribute("item",items);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",items);
        String checkValue = request.getParameter("checkValue");
        if ("true".equals(checkValue)){
            map.put("isMatch", ResultEnumCode.MATCH);
        }else {
            map.put("isMatch",ResultEnumCode.NOAP);
        }
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String[] adds = address.split("ADD");
        map.put("totalName",name+adds[0]);
        return map;
    }

//    npm config set registry http://registry.npm.taobao.org/
    @ResponseBody
    @PostMapping("/check")
    public Form checkBox(@RequestBody Form form){
        return form;
    }

    @PostMapping("/test")
    public String test(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String beneficialAccount = request.getParameter("beneficialAccount");
        String checkValue = request.getParameter("checkValue");
        System.out.println("id:"+id+",name:"+name+",beneficialAccount:"+beneficialAccount+",checkValue:"+checkValue);
        return "success";
    }

//    @ResponseBody
//    @PostMapping(value = "/getUser",consumes = "application/json")
//    public SimpleUser getUser(@RequestBody SimpleUser user){
//        return user;
//    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseResult login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String,Object> map = userService.getUser(username,password);
        if (map!=null){
            return new ResponseResult(ResultEnumCode.MATCH.getCode(),"Match",map);
        }
        return new ResponseResult(ResultEnumCode.NOAP.getCode(),"Noap",null);
    }

    @ResponseBody
    @GetMapping("/info")
    public ResponseResult getUserInfo(@RequestParam("token") String token){
        Map<String,Object> map = userService.getUserInfo(token);
        if (map!=null){
            return new ResponseResult(ResultEnumCode.MATCH.getCode(),"userInfo",map);
        }
        return new ResponseResult(ResultEnumCode.NOAP.getCode(),"do not get info",null);
    }

    @ResponseBody
    @PostMapping("/logout")
    public ResponseResult logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return new ResponseResult(2000,"logout success",null);
    }

    @GetMapping("/getAllUser")
    @ResponseBody
    public ResponseResult getAllUser(@RequestParam(value = "username",required = false) String username,
                                     @RequestParam(value = "password",required = false) String password,
                                     @RequestParam(value = "pageNo",required = false) Long pageNo,
                                     @RequestParam(value = "pageSize",required = false) Long pageSize){

        Map<String,Object> map = userService.getAllUser();
        if (map!=null){
            return new ResponseResult(ResultEnumCode.MATCH.getCode(),"userInfo",map);
        }
        return new ResponseResult(ResultEnumCode.NOAP.getCode(),"do not get info",null);
    }
}
