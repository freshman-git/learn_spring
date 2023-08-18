package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 查询所有的用户信息 --> /user --> get
 * 根据id查询用户信息 --> /user/1 --> get
 * 添加用户信息 --> /user --> post
 * 修改用户信息 --> /user --> put
 * 根据id删除用户信息 --> /user/1 --> delete
 *
 *
 * 浏览器目前只能发送get和post请求
 * 若要发送put和delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求要满足两个条件，才能将请求转换为put或delete
 * 1.当前请求必须为post
 * 2.当前请求必须传输请求参数_method,_method的值才是最终的请求方式
 * eg:
 * <form th:action="@{/user}" method="post">
 *     <input type="hidden" name="_method" value="put">
 *     <input type="submit" value="修改用户信息">
 * </form><br>
 *
 */


@Controller
public class RestController {

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    public String getAllUser(){
//        System.out.println("查询所有的用户信息 --> /user --> get");
//        return "success";
//    }
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有的用户信息 --> /user --> get");
        return "success";
    }

//    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
//    public String getUserById(@PathVariable("id") Integer id){
//        System.out.println("根据id查询用户信息 --> /user/"+id+" --> get");
//        return "success";
//    }
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息 --> /user/"+id+" --> get");
        return "success";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public String insertUser(){
//        System.out.println("添加用户信息 --> /user --> post");
//        return "success";
//    }
    @PostMapping("/user")
    public String insertUser(){
        System.out.println("添加用户信息 --> /user --> post");
        return "success";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
//    public String updateUser(){
//        System.out.println("修改用户信息 --> /user --> put");
//        return "success";
//    }
    @PutMapping("/user")
    public String updateUser(){
        System.out.println("修改用户信息 --> /user --> put");
        return "success";
    }

//    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable("id") Integer id){
//        System.out.println("根据id删除用户信息 --> /user/"+id+" --> delete");
//        return "success";
//    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("根据id删除用户信息 --> /user/"+id+" --> delete");
        return "success";
    }
}
