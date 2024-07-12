package com.luv2code.aopDemo.entity;

public class Account {

    private String name;
    private String type;

    public Account(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
