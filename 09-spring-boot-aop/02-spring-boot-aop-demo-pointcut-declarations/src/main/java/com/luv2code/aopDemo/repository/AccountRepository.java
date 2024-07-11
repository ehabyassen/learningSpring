package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;

import java.util.List;

public interface AccountRepository {

    void addAccount();

    Account getAccount();

    void setAccount();

    List<Account> findAccounts();
}
