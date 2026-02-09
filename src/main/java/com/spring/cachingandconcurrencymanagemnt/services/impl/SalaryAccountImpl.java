package com.spring.cachingandconcurrencymanagemnt.services.impl;

import com.spring.cachingandconcurrencymanagemnt.entities.Employee;
import com.spring.cachingandconcurrencymanagemnt.entities.SalaryAccount;
import com.spring.cachingandconcurrencymanagemnt.exceptions.ResourceNotFoundException;
import com.spring.cachingandconcurrencymanagemnt.repositories.SalaryAccountRepository;
import com.spring.cachingandconcurrencymanagemnt.services.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class SalaryAccountImpl implements SalaryAccountService {

    private final SalaryAccountRepository salaryAccountRepository;

    @Override
    public void createAccount(Employee employee) {
        SalaryAccount salaryAccount = SalaryAccount.builder()
                .employee(employee)
                .balance(BigDecimal.ZERO)
                .build();

        salaryAccountRepository.save(salaryAccount);
    }

    @Override
    @Transactional
    public SalaryAccount incrementBalance(Long accountId) {
        SalaryAccount salaryAccount =salaryAccountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("No Salary Account With ID "+accountId ));
        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add(BigDecimal.valueOf(1L));
        salaryAccount.setBalance(newBalance);

        return salaryAccountRepository.save(salaryAccount);
    }
}
