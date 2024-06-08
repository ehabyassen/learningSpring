package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void fillStudents() {
        students = List.of(new Student(1, "Ehab", "Ahmed"),
                new Student(2, "Aya", "Ahmed"),
                new Student(3, "Eslam", "Ahmed"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    //http://localhost:8080/api/students/1
    @GetMapping("/students/{studentId}")
    public Student getStudentByPathVariable(@PathVariable int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }

    /*
    //http://localhost:8080/api/students?studentId=1
    @GetMapping("/students")
    public Student getStudentByRequestParameter(@RequestParam int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }*/
}
