package com.luv2code.aopDemo.entity;

public class Account {

    private final String name;
    private final String type;

    public Account(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
