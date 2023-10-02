package com.example.demo.service.impl;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.User;
import com.example.demo.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> getAllEmp(Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<Employee> allEmployee = employeeMapper.getAllEmployee();
        PageInfo<Employee> employeePageInfo = new PageInfo<>(allEmployee, 3);
        return employeePageInfo;
    }
}
