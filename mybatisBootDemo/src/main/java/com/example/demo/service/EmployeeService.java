package com.example.demo.service;

import com.example.demo.pojo.Employee;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
    PageInfo<Employee> getAllEmp(Integer curPage, Integer pageSize);
}
