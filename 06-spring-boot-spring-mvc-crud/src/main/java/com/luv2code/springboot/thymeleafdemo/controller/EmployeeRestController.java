package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/listEmployees";
    }

    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/addEmployeeForm";
    }

    @PostMapping("/processAddEmployeeForm")
    public String processAddEmployeeForm(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateEmployeeForm")
    public String showUpdateEmployeeForm(@RequestParam int employeeId, Model model) {
        Employee employee = employeeService.find(employeeId);
        model.addAttribute("employee", employee);
        return "employees/addEmployeeForm";
    }

    @GetMapping("/processDeleteEmployee")
    public String processDeleteEmployee(@RequestParam int employeeId) {
        employeeService.delete(employeeId);
        return "redirect:/employees/list";
    }
}
