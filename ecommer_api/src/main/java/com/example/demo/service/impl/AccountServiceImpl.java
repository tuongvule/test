package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account getAccount(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsAccountByUsername(String username) {
        return accountRepository.existsAccountByUsername(username);
    }

    @Override
    public int saveAccount(Account account) {
        accountRepository.save(account);
        return 1;
    }
}
