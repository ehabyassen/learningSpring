package com.itranks.employees.repository;

import com.itranks.employees.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void saveEmployee(Employee employee);

    Employee findEmployee(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> findAllEmployees();

    List<Employee> findEmployeesByBranchId(int id);
}
