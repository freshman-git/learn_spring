package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 使用RequestBody注解将json格式的请求参数转换为java对象
 * 1）导入jackson的依赖
 * 2）springMVC的配置文件中设置<mvc:annotation-driven/>
 * 3）在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换成的java类型的形参，使用@RequestBody注解标识即可
 *
 * @ResponseBody:将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 *
 * 使用@ResponseBody注解响应浏览器json格式的数据
 * 1）导入jackson的依赖
 * 2）springMVC的配置文件中设置<mvc:annotation-driven/>
 * 3）将需要转换为json格式的java对象直接作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
 * 就可以将java对象转换为json字符串，并且相应到浏览器
 *
 * @RestController = @Controller+@ResponseBody
 */

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test1(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id,@RequestBody String requestBody,HttpServletResponse response) throws IOException {
        System.out.println(requestBody);
        System.out.println(id);
        response.getWriter().write("hello.axios");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map,HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,requestBody");
    }

    @RequestMapping("/test/resposeBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }
}
