package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Making some DB work. Adding an account.");
    }

    @Override
    public Account getAccount() {
        System.out.println("Returning new account.");
        return new Account();
    }

    @Override
    public void setAccount() {
        System.out.println("Setting an account");
    }
}
