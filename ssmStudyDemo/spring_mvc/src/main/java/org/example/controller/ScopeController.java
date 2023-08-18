package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 1.使用ModelAndView向请求域中共享数据
 * 2.使用Model向请求域中共享数据
 * 3.使用ModelMap向请求域中共享数据
 * 4.使用map向请求域中共享数据
 */
@Controller
public class ScopeController {

    @RequestMapping("/mav")
    public ModelAndView testMAV(){

//      ModelAndView包含Model和View的功能
//        Model向请求域中共享数据
//          View设置逻辑视图实现页面跳转
        ModelAndView modelAndView = new ModelAndView();
//        向请求域中共享数据
        modelAndView.addObject("requestScope","hello,ModelAndView");
//        设置逻辑视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/model")
    public String testModel(Model model){
        model.addAttribute("requestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("requestScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/map")
    public String testMap(Map<String,Object> map){
        map.put("requestScope","hello,Map");
        return "success";
    }

    @RequestMapping("/session")
    public String testSession(HttpSession session){
        session.setAttribute("sessionScope","hello,Session");
        return "success";
    }

    @RequestMapping("/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("applicationScope","hello,Application");
        return "success";
    }
}
