package com.zhuhy.service;

import com.zhuhy.mapper.EmployeeMapper;
import com.zhuhy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getEmpList() {
        System.out.println("查询所有员工信息");
        return employeeMapper.queryEmployeesList();
    }


    /**
     * 将方法的运行结果进行缓存，以后要再次请求相同的数据，直接从缓存中获取，不用调用方法
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
     *      几个属性：
     *      cacheNames/value:指定缓存 的名字
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *              编写SpEL； #id;参数id的值   #a0  #p0  #root.args[0]
     *              getEmp[2]
     *              keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *      key/keyGenerator：二选一使用;
     *
     *
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *
     *      condition：指定符合条件的情况下才缓存；
     *                   ,condition = "#id>0"
     *               condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *                   unless = "#result == null"
     *                   unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      sync：是否使用异步模式
     * @param id 员工ID
     * @return 员工对象
     */
    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "员工");
        Employee employee = employeeMapper.queryEmployees(id);
        System.out.println("员工信息：" + employee);
        return employee;
    }
}
