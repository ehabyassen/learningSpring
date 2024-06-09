package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee find(int employeeId);

    Employee save(Employee employee);

    void delete(int employeeId);
}
