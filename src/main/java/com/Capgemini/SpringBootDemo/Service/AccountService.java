package com.Capgemini.SpringBootDemo.Service;

import com.Capgemini.SpringBootDemo.Model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAccountByCustomerId(int customerId);
}
