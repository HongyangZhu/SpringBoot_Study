package com.zhuhy;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        // 查看默认数据源 ： com.zaxxer.hikari.HikariDataSource
        // Druid数据源     com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass());
        // 获得数据库连接
        Connection connection = dataSource.getConnection();
        // HikariProxyConnection@898283008 wrapping com.mysql.cj.jdbc.ConnectionImpl@e26af6
        System.out.println(connection);

        // xxxTemplate: Springboot已经配置好的模板
        // jdbcTemplate
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        // 关闭
        connection.close();

    }

}
