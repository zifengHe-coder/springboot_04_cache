package com.lagou.service;

import com.lagou.mapper.EmployeeMapper;
import com.lagou.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hezifeng
 * @create 2022/8/15 18:13
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    public Employee getEmpById(Integer id) {
        return mapper.getEmpById(id);
    }
}
