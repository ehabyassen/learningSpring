package com.luv2code.demo.rest;

import java.time.ZonedDateTime;

public class StudentErrorResponse {

    private int status;
    private String message;
    private ZonedDateTime zonedDateTime;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, ZonedDateTime zonedDateTime) {
        this.status = status;
        this.message = message;
        this.zonedDateTime = zonedDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }
}
