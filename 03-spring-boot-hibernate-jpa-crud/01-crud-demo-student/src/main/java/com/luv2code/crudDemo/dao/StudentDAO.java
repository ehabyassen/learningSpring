package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByName(String name);

    List<Student> findByEmail(String email);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
