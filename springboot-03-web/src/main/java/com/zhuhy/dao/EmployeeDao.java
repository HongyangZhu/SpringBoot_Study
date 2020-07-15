package com.zhuhy.dao;

import com.zhuhy.pojo.Department;
import com.zhuhy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }

    //员工ID 主键自增
    private static Integer initId = 1006;

    /**
     * 增加员工
     */
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    /**
     * 获取全部员工信息
     *
     * @return 全部员工信息
     */
    public Collection<Employee> getAll() {
        return employees.values();
    }

    /**
     * 根据Id 获取指定员工信息
     *
     * @param id 员工ID
     * @return 指定员工信息
     */
    public Employee get(Integer id) {
        return employees.get(id);
    }

    /**
     * 根据Id 删除指定员工
     *
     * @param id 员工ID
     */
    public void delete(Integer id) {
        employees.remove(id);
    }
}
