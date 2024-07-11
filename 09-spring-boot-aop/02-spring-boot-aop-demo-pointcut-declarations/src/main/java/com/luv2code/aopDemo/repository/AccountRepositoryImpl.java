package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Making some DB work. Adding an account.");
    }

    @Override
    public Account getAccount() {
        System.out.println("Returning new account.");
        return new Account("Dua", "Basic");
    }

    @Override
    public void setAccount() {
        System.out.println("Setting an account");
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(new Account("Sophie", "Advance"), new Account("Aisha", "Platinum"));
    }
}
