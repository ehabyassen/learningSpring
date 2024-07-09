package com.luv2code.aopDemo.repository;

import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Making some DB work. Adding an account.");
    }
}
