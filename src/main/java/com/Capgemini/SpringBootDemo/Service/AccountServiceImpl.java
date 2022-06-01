package com.Capgemini.SpringBootDemo.Service;

import com.Capgemini.SpringBootDemo.Model.Account;
import com.Capgemini.SpringBootDemo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAccountByCustomerId(int customerId) {
        List<Account> account=(accountRepository.getAccountByCustomerId(customerId));
        return account;
    }
}
