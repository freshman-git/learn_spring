package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @GetMapping
 * @PostMapping
 * @DeleteMapping
 * @PutMapping
 *
 * @RequestMapping params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * 四种表达式：
 * ”param“：表示当前请求的请求参数中必须携带param参数
 * ”！param“：表示当前请求的请求参数中一定不能携带param参数
 * ”param=value“：表示当前请求的请求参数中必须携带param参数的值必须为value
 * ”param！=value“：表示当前请求的请求参数中可以不携带param参数，若携带，值一定不是value
 */

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String portal(){
//        return "index";
//    }

    @RequestMapping("/hello")
    public String isSuccess(){
        return "success";
    }

    @RequestMapping("test/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        return "success";
    }
}
