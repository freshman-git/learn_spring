package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeeByPage(Integer pageNum);
}
