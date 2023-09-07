package com.example.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @GetMapping("/car/{id}/owner/{name}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("name") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> headerMap,
                                     @RequestParam("hobby") List<String> hobby,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-c84d05c") String cookie,
                                     @CookieValue("Idea-c84d05c") Cookie totalCookie){

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headerMap",headerMap);
        map.put("hobby",hobby);
        map.put("params",params);
        map.put("cookie",cookie);
        map.put("totalCookie",totalCookie);
        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> getForm(@RequestBody String content){
        HashMap<String, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

//     /matrixVar/1;age=10/2;age=20
    @GetMapping("/matrixVar/{bossId}/{empId}")
    public Map<String,Object> getMatrixVar(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                                           @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
