package com.luv2code.springboot.thymeleafdemo.repository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee find(int employeeId);

    Employee save(Employee employee);

    void delete(int employeeId);
}
