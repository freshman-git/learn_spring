package org.example.mapper;

import org.example.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> getEmpByCondition(Emp emp);
}
