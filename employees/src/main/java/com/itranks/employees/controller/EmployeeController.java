package com.itranks.employees.controller;

import com.itranks.employees.entity.Branch;
import com.itranks.employees.entity.Employee;
import com.itranks.employees.service.BranchService;
import com.itranks.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final BranchService branchService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, BranchService branchService) {
        this.employeeService = employeeService;
        this.branchService = branchService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/listEmployees";
    }

    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model model) {
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("branches", branches);
        model.addAttribute("employee", new Employee());
        return "employees/addEmployeeForm";
    }

    @PostMapping("/processAddEmployeeForm")
    public String processAddEmployeeForm(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateEmployeeForm")
    public String showUpdateEmployeeForm(@RequestParam int employeeId, Model model) {
        Employee employee = employeeService.findEmployee(employeeId);
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("branches", branches);
        model.addAttribute("employee", employee);
        return "employees/addEmployeeForm";
    }

    @GetMapping("/processDeleteEmployee")
    public String processDeleteEmployee(@RequestParam int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees/list";
    }
}
