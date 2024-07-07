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
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;

    private final EmployeeService employeeService;

    @Autowired
    public BranchController(BranchService branchService, EmployeeService employeeService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("branches", branches);
        return "branches/listBranches";
    }

    @GetMapping("/listBranchEmployees")
    public String listBranchEmployees(@RequestParam int branchId, Model model) {
        List<Employee> employees = employeeService.findEmployeesByBranchId(branchId);
        model.addAttribute("employees", employees);
        return "employees/listEmployees";
    }

    @GetMapping("/showAddBranchForm")
    public String showAddBranchForm(Model model) {
        model.addAttribute("branch", new Branch());
        return "branches/addBranchForm";
    }

    @PostMapping("/processAddBranchForm")
    public String processAddBranchForm(@ModelAttribute Branch branch) {
        branchService.saveBranch(branch);
        return "redirect:/branches/list";
    }

    @GetMapping("/showUpdateBranchForm")
    public String showUpdateBranchForm(@RequestParam int branchId, Model model) {
        Branch branch = branchService.findBranch(branchId);
        model.addAttribute("branch", branch);
        return "branches/addBranchForm";
    }

    @GetMapping("/processDeleteBranch")
    public String processDeleteBranch(@RequestParam int branchId) {
        branchService.deleteBranch(branchId);
        return "redirect:/branches/list";
    }
}
