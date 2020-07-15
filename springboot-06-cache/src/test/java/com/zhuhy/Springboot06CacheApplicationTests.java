package com.zhuhy;

import com.zhuhy.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        System.out.println(employeeMapper.queryEmployees(1002));
    }

}
