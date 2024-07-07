package com.itranks.employees.controller;

import com.itranks.employees.entity.Branch;
import com.itranks.employees.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("branches", branches);
        return "branches/listBranches";
    }
}
