package com.javacode.task2.repo;

import com.javacode.task2.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {


}
