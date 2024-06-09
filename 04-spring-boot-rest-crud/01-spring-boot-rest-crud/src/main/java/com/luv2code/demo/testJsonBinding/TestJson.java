package com.luv2code.demo.testJsonBinding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student("Ehab", 34);

        ObjectMapper objectMapper = new ObjectMapper();

        //serialization
        String studentJSON = objectMapper.writeValueAsString(student);
        System.out.println(studentJSON);

        //deserialization
        Student deserializedStudent = objectMapper.readValue(studentJSON, Student.class);
        System.out.println(deserializedStudent);
    }
}
