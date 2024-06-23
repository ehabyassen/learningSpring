package com.luv2code.springboot.thymeleafdemo.repository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class EmployeeRepositoryJpaImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList().stream().sorted(Comparator.comparing(Employee::getLastName)).toList();
    }

    @Override
    public Employee find(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }
}
