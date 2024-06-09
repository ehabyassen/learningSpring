package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), getZonedDateTime());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), getZonedDateTime());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ZonedDateTime getZonedDateTime() {
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneOffset gmtPlus3 = ZoneOffset.ofHours(3);
        return ZonedDateTime.ofInstant(instant, gmtPlus3);
    }
}
