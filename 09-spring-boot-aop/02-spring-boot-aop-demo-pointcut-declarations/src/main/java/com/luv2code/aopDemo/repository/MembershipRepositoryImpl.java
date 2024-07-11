package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipRepositoryImpl implements MembershipRepository {

    @Override
    public boolean addMembershipAccount(Account account, boolean premium, String id) {
        System.out.println(getClass() + ": Making some DB work. Adding a membership account.");
        return true;
    }
}
