package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.AccountRole;

import java.util.List;

public interface AccountRoleService {
    AccountRole getAccountRoleByAccount(Account account);
    List<AccountRole> getList();
}
