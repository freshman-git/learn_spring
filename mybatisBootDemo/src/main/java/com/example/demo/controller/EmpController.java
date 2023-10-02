package com.example.demo.controller;

import com.example.demo.pojo.Employee;
import com.example.demo.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAllEmp")
    public String getAllEmp(@RequestParam(defaultValue = "1") Integer curPage,
                            @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<Employee> pageInfo = employeeService.getAllEmp(curPage,pageSize);
        return "employeeList";
    }
}
