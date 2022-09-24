package com.javacode.task2.controller;


import com.javacode.task2.entity.Account;
import com.javacode.task2.request.AccountRequest;
import com.javacode.task2.response.AccountBalanceResponse;
import com.javacode.task2.response.AccountResponse;
import com.javacode.task2.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    public AccountResponse addAccount(@RequestBody AccountRequest request) {
        return accountService.addAccount(request);
    }

    @GetMapping("/{id}")
    public List<AccountResponse> getAllAccountByCustomerNumber(@PathVariable Long id) {
        return accountService.getAllAccountsByCustomerNumber(id);
    }

    @GetMapping("/ce/{id}")
    public List<AccountResponse> getAllAccountByCivilId(@PathVariable Long id) {
        return accountService.getAllAccountsByCivilId(id);
    }
    @PutMapping("/{id}")
    public AccountResponse updateAccount(Long id, AccountRequest request) {
        return accountService.updateAccount(id,request);
    }
    @DeleteMapping("/{id}")
    public String DeleteAccount(Long id) {
        accountService.DeleteAccount(id);
        return "account has been deleted";
    }
    @GetMapping("/balance/{id}")
    public AccountBalanceResponse getAccountBalance(Long accountId){
        return accountService.getAccountBalance(accountId);
    }
}
