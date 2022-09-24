package com.javacode.task2.service;


import com.javacode.task2.entity.Customer;
import com.javacode.task2.repo.CustomerRepository;
import com.javacode.task2.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer addCustomer(CustomerRequest request){

        Customer customer = new Customer();
        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setCivilId(request.getCivilId());
        customer.setDateOfBirth(request.getDateOfBirth());
        customer.setFullName(request.getFullName());
        customer.setMobileNumber(request.getMobileNumber());
        return customerRepository.save(customer);

    }
    public Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found"));
    }


}
