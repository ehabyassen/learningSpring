package com.itranks.employees.repository;

import com.itranks.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJpaImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeesByBranchId(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee WHERE branch.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
