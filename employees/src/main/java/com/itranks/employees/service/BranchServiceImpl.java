package com.itranks.employees.service;

import com.itranks.employees.entity.Branch;
import com.itranks.employees.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    @Transactional
    public void saveBranch(Branch branch) {
        if (branch.getId() == 0) {
            branchRepository.saveBranch(branch);
        } else {
            branchRepository.updateBranch(branch);
        }
    }

    @Override
    public Branch findBranch(int id) {
        return branchRepository.findBranch(id);
    }

    @Override
    @Transactional
    public void deleteBranch(int id) {
        branchRepository.deleteBranch(id);
    }

    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAllBranches();
    }
}
