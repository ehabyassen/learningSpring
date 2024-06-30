package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Instructor;

import java.util.List;

public interface InstructorRepository {

    void save(Instructor instructor);

    Instructor findById(int id);

    List<Instructor> findAll();

    void deleteById(int id);
}
