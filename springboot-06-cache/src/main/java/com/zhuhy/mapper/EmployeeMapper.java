package com.zhuhy.mapper;

import com.zhuhy.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper // 这个注解表示这是一个mybatis的mapper类
@Repository
public interface EmployeeMapper {

    @Select("SELECT * FROM Employees")
    List<Employee> queryEmployeesList();

    @Select("SELECT * FROM Employees WHERE employeeNumber = #{id}")
    Employee queryEmployees(Integer id);

    @Insert("INSERT INTO yiibaidb.employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) " +
            "VALUES (#{employeeNumber}, #{lastName}, #{firstName}, #{extension}, #{email}, #{officeCode}, #{reportsTo}, #{jobTitle});")
    int addEmployees(Employee employee);

    int updateEmployees(Employee employee);

    int deleteEmployees(int id);

}
