package com.zhuhy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//@Controller
@RestController
public class JDBC_Controller {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from employees";
        return jdbcTemplate.queryForList(sql);
    }


}
