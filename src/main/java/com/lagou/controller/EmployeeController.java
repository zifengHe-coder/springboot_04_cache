package com.lagou.controller;

import com.lagou.pojo.Employee;
import com.lagou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hezifeng
 * @create 2022/8/15 18:16
 */
@RestController
@RequestMapping("/demo")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }

    @RequestMapping("/updateEmp/{id}")
    public Employee updateEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmpById(id);
        emp.setLastName("张三");
        return employeeService.updateEmp(emp);
    }

    @RequestMapping("/delEmp/{id}")
    public Employee delEmp(@PathVariable("id") Integer id) {
        employeeService.delEmp(id);
        return null;
    }

    @RequestMapping("/insertEmp/{lastName}/{email}/{gender}/{dId}")
    public Employee insertEmp(@PathVariable("lastName") String lastName,
                              @PathVariable("email") String email,
                              @PathVariable("gender") Integer gender,
                              @PathVariable("dId") Integer dId) {
        Employee employee = new Employee();
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setDId(dId);
        employeeService.insertEmp(employee);
        return employee;
    }

}
