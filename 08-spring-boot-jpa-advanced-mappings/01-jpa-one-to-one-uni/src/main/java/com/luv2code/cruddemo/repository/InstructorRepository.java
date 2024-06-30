package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Instructor;

public interface InstructorRepository {

    void save(Instructor instructor);

    Instructor findById(int id);
}
