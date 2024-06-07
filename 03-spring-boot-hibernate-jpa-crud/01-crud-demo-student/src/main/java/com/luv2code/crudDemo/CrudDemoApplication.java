package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.StudentDAO;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createMultipleStudent(studentDAO);
            //findStudentById(studentDAO);
            //findAllStudents(studentDAO);
            //findStudentsByName(studentDAO);
            //findStudentsByEmail(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting All Students...");
        System.out.println("Deleted " + studentDAO.deleteAll() + " Students.");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findByName("Eslam").stream().findFirst().get();
        System.out.println("Deleting Student: " + student);
        studentDAO.delete(student.getId());
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findByName("Ehab").stream().findFirst().get();
        System.out.println("Found Student: " + student);
        student.setEmail("ehab@luv2code.com");
        System.out.println("Update student...");
        studentDAO.update(student);
        System.out.println("Updated Student: " + student);
    }

    private void findStudentsByEmail(StudentDAO studentDAO) {
        System.out.println("Found Students By Email:");
        studentDAO.findByEmail("luv2code.com").forEach(System.out::println);
        System.out.println("#".repeat(100));
    }

    private void findStudentsByName(StudentDAO studentDAO) {
        System.out.println("Found Students By Name:");
        studentDAO.findByName("Aya").forEach(System.out::println);
        System.out.println("#".repeat(100));
    }

    private void findAllStudents(StudentDAO studentDAO) {
        System.out.println("Found All Students:");
        studentDAO.findAll().forEach(System.out::println);
        System.out.println("#".repeat(100));
    }

    private void findStudentById(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
        System.out.println("Found Student By Id: " + student);
        System.out.println("#".repeat(100));
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        createStudent(studentDAO, new Student("Ehab", "Ahmed", "ehab@luv2code.com"));
        createStudent(studentDAO, new Student("Eslam", "Ahmed", "eslam@luv2code.com"));
        createStudent(studentDAO, new Student("Aya", "Ahmed", "aya@luv2code.com"));
    }

    private static void createStudent(StudentDAO studentDAO, Student student) {
        System.out.println("Created Student: " + student);
        studentDAO.save(student);
        System.out.println("Saved Student: " + student);
        System.out.println("#".repeat(100));
    }
}
