package com.javacode.task2.repo;

import com.javacode.task2.entity.Account;
import com.javacode.task2.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value ="select a from Account a , Customer c where 1=1 and  a.customer.customerId = c.customerId and c.customerNumber = :customerNumber" )
    List<Account> getAllAccountsByCustomerNumber(Long customerNumber);


    @Query(value ="select a from Account a , Customer c where 1=1 and  a.customer.customerId = c.customerId and c.civilId = :civilId" )
    List<Account> getAllAccountsByCivilId(Long civilId);
}
