package com.luv2code.cruddemo.repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface Repository {

    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    List<Instructor> findAllInstructors();

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    List<InstructorDetail> findAllInstructorDetails();

    void deleteInstructorDetailById(int id);
}
