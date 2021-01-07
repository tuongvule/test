package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.model.AccountRole;
import com.example.demo.repository.AccountRoleRepository;
import com.example.demo.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;
    @Override
    public AccountRole getAccountRoleByAccount(Account account) {
        return accountRoleRepository.getAccountRoleByAccount(account);
    }

    @Override
    public List<AccountRole> getList() {
        return accountRoleRepository.findAll();
    }
}
