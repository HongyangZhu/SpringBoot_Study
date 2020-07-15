package com.zhuhy.dao;

import com.zhuhy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>(); //创建一个部门表

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    /**
     * 获得所有的部门的信息
     *
     * @return 所有的部门对象
     */
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    /**
     * 根据部门ID 获取指定部门的信息
     *
     * @param id 部门ID
     * @return 指定的部门对象
     */
    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}
