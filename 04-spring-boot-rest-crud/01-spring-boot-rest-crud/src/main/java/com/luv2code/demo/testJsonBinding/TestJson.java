package com.luv2code.demo.testJsonBinding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
        String studentJson = "{\"name\": \"Ehab\", \"age\": 34}";

        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(studentJson, Student.class);

        System.out.println(student);

        String json = objectMapper.writeValueAsString(student);

        System.out.println(json);
    }
}
