package com.luv2code.demo.rest;

import java.util.Date;

public class StudentErrorResponse {

    private int status;
    private String message;
    private Date date;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, Date date) {
        this.status = status;
        this.message = message;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
