package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void fillStudents() {
        students = List.of(new Student("Ehab", "Ahmed"),
                new Student("Aya", "Ahmed"),
                new Student("Eslam", "Ahmed"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    //http://localhost:8080/api/students/1
    @GetMapping("/students/{studentId}")
    public Student getStudentByPathVariable(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException(String.format("Student with Id: [%d] not found.", studentId));
        }
        return students.get(studentId);
    }

    /*
    //http://localhost:8080/api/students?studentId=1
    @GetMapping("/students")
    public Student getStudentByRequestParameter(@RequestParam int studentId) {
        return students.get(studentId);
    }*/

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
