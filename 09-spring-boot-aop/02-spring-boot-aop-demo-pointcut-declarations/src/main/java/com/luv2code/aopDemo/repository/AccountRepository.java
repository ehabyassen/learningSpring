package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;

public interface AccountRepository {

    void addAccount();

    Account getAccount();

    void setAccount();
}
