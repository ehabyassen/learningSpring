package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<Account> findAccounts(boolean tripWire) throws RuntimeException {
        if (tripWire) {
            throw new RuntimeException("Test Exception!");
        } else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(new Account("Sophie", "Advance"));
            accounts.add(new Account("Dia", "Platinum"));
            return accounts;
        }
    }
}
