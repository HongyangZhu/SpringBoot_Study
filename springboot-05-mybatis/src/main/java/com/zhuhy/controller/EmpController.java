package com.zhuhy.controller;

import com.zhuhy.mapper.EmployeesMapper;
import com.zhuhy.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {


    @Autowired
    private EmployeesMapper employeesMapper;

    @GetMapping("/queryEmployeesList")
    public List<Employees> queryEmployeesList() {

        return employeesMapper.queryEmployeesList();
    }

}
