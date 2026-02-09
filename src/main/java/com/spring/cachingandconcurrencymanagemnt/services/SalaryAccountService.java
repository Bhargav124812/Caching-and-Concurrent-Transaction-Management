package com.spring.cachingandconcurrencymanagemnt.services;

import com.spring.cachingandconcurrencymanagemnt.entities.Employee;
import com.spring.cachingandconcurrencymanagemnt.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
