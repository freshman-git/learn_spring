package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.pojo.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 查询所有员工信息 --> /employee --> get
 * 根据id查询员工信息 --> /employee/1 -->get
 * 跳转到添加页面 --> /to/add -->get
 * 添加员工信息 /employee --> post
 * 修改员工信息 /employee --> put
 * 删除出员工信息 /employee/1 --> delete
 *
 * 分页查询 /employee/page/1 --> get
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeeByPage(@PathVariable("pageNum") Integer pageNum,Model model){
        PageInfo<Employee> pageInfo = employeeService.getEmployeeByPage(pageNum);
        model.addAttribute("pageInfo",pageInfo);
        return "employeePage";
    }

    @GetMapping("/getAllEmployee")
    public String getAllEmployee(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList",employeeList);
//        System.out.println(employeeList.toString());
        return "employeeList";
    }
}
