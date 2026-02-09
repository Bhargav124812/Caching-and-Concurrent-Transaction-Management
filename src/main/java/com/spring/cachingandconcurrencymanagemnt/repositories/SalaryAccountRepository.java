package com.spring.cachingandconcurrencymanagemnt.repositories;

import com.spring.cachingandconcurrencymanagemnt.entities.SalaryAccount;
import org.springframework.data.repository.CrudRepository;

public interface SalaryAccountRepository extends CrudRepository<SalaryAccount,Long> {
}
