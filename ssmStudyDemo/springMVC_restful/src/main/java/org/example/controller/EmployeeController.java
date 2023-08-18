package org.example.controller;

import org.example.dao.EmployeeDao;
import org.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/save")
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/getAll";
    }

    @GetMapping("/getAll")
    public ModelAndView getAll(){
        Collection<Employee> allEmployees = employeeDao.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allEmployees",allEmployees);
        modelAndView.setViewName("employees");
        return modelAndView;
    }

    @GetMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") Integer id){
        Employee employee = employeeDao.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee",employee);
        modelAndView.setViewName("employeeUpdate");
        return modelAndView;
    }

    @PutMapping("/update")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/getAll";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/getAll";
    }
}
