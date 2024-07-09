package com.luv2code.aopDemo.repository;

import com.luv2code.aopDemo.entity.Account;
import com.luv2code.aopDemo.entity.Trainer;

public interface MembershipRepository {

    boolean addMembershipAccount(Account account, boolean premium, String id, Trainer trainer);
}
