package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee find(@PathVariable int employeeId) {
        Employee employee = employeeService.find(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException(String.format("Employee with id [%d] not found.", employeeId));
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        Employee employee = employeeService.find(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException(String.format("Employee with id [%d] not found.", employeeId));
        }
        employeeService.delete(employeeId);

        return String.format("Deleted %s", employee);
    }
}
