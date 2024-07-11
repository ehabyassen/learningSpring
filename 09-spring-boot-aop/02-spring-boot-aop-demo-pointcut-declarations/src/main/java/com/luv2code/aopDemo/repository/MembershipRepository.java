package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;

public interface MembershipRepository {

    boolean addMembershipAccount(Account account, boolean premium, String id);
}
