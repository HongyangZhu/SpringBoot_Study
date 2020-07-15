package com.zhuhy.mapper;

import com.zhuhy.pojo.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper // 这个注解表示这是一个mybatis的mapper类
@Repository
public interface EmployeesMapper {

    List<Employees> queryEmployeesList();

    Employees queryEmployees(int id);

    int addEmployees(Employees employees);

    int updateEmployees(Employees employees);

    int deleteEmployees(int id);

}
