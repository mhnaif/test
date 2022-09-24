package com.javacode.task2.controller;


import com.javacode.task2.entity.Customer;
import com.javacode.task2.request.CustomerRequest;
import com.javacode.task2.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody CustomerRequest request) {
        return customerService.addCustomer(request);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
    return customerService.getCustomer(id);
    }
}

