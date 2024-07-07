package com.itranks.employees.service;

import com.itranks.employees.entity.Employee;
import com.itranks.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        if (employee.getId() == 0) {
            employeeRepository.saveEmployee(employee);
        } else {
            employeeRepository.updateEmployee(employee);
        }
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeRepository.findEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public List<Employee> findEmployeesByBranchId(int id) {
        return employeeRepository.findEmployeesByBranchId(id);
    }
}
