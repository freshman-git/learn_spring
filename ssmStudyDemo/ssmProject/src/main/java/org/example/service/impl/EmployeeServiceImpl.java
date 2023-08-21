package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeMapper.getAllEmployee();
        return employeeList;
    }

    @Override
    public PageInfo<Employee> getEmployeeByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Employee> employeeList = employeeMapper.getEmployeeByPage();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,3);
        return pageInfo;
    }
}
