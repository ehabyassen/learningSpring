package com.itranks.employees.service;

import com.itranks.employees.entity.Branch;

import java.util.List;

public interface BranchService {

    void saveBranch(Branch branch);

    Branch findBranch(int id);

    void updateBranch(Branch branch);

    void deleteBranch(int id);

    List<Branch> findAllBranches();
}
