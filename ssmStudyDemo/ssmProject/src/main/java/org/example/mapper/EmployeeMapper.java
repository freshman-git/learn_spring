package org.example.mapper;

import org.example.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    List<Employee> getEmployeeByPage();
}
