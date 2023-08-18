package org.example.controller;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求参数的方式
 * 1.通过ServletAPI获取  设置HttpServletRequest类型的形参  在方法中通过request对象获取请求参数
 * 2.通过控制器方法的形参   方法设置形参，形参名字和请求参数的名字一致
 *
 *
 * @RequestHeader
 * @CookieValue
 */
@Controller
public class TestParamsController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletApi(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username"+username+":password"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println("username"+username+":password"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamPojo(User user){
        System.out.println(user);
        return "success";
    }

}
