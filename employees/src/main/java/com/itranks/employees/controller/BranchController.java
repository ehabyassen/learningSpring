package com.itranks.employees.controller;

import com.itranks.employees.entity.Branch;
import com.itranks.employees.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
