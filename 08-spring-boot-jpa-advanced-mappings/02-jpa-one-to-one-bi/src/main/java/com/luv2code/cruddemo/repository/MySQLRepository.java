package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
public class MySQLRepository implements Repository {

    private final EntityManager entityManager;

    @Autowired
    public MySQLRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor> query = entityManager.createQuery("FROM Instructor", Instructor.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}
