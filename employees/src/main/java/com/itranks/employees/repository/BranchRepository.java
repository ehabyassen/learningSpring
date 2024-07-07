package com.itranks.employees.repository;

import com.itranks.employees.entity.Branch;

import java.util.List;

public interface BranchRepository {

    void saveBranch(Branch branch);

    Branch findBranch(int id);

    void updateBranch(Branch branch);

    void deleteBranch(int id);

    List<Branch> findAllBranches();
}
