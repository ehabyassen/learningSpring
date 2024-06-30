package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface Repository {

    void save(Instructor instructor);

    Instructor findById(int id);

    List<Instructor> findAll();

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);
}
