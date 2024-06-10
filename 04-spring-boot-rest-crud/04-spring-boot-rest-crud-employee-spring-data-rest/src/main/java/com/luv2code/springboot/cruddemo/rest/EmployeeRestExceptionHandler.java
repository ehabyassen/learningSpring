package com.luv2code.springboot.cruddemo.rest;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(ResourceNotFoundException exception) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), getZonedDateTime());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), getZonedDateTime());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ZonedDateTime getZonedDateTime() {
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneOffset cairoZoneOffset = ZoneOffset.ofHours(3);
        return ZonedDateTime.ofInstant(instant, cairoZoneOffset);
    }
}
