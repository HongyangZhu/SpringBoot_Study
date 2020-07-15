package com.zhuhy.controller;

import com.zhuhy.pojo.Employee;
import com.zhuhy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/empList")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        return employeeService.getEmpList();
    }


    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }
}
