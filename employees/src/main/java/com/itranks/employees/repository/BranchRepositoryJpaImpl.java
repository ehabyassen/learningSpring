package com.itranks.employees.repository;

import com.itranks.employees.entity.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchRepositoryJpaImpl implements BranchRepository {

    private final EntityManager entityManager;

    @Autowired
    public BranchRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveBranch(Branch branch) {
        entityManager.persist(branch);
    }

    @Override
    public Branch findBranch(int id) {
        return entityManager.find(Branch.class, id);
    }

    @Override
    public void updateBranch(Branch branch) {
        entityManager.merge(branch);
    }

    @Override
    public void deleteBranch(int id) {
        Branch branch = entityManager.find(Branch.class, id);
        entityManager.remove(branch);
    }

    @Override
    public List<Branch> findAllBranches() {
        TypedQuery<Branch> query = entityManager.createQuery("FROM Branch", Branch.class);
        return query.getResultList();
    }
}
