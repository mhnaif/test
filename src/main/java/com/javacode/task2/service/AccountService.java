package com.javacode.task2.service;


import com.javacode.task2.entity.Account;
import com.javacode.task2.entity.Customer;
import com.javacode.task2.repo.AccountRepository;
import com.javacode.task2.repo.CustomerRepository;
import com.javacode.task2.request.AccountRequest;
import com.javacode.task2.response.AccountBalanceResponse;
import com.javacode.task2.response.AccountResponse;
import com.javacode.task2.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;


    @Transactional
    public AccountResponse addAccount(AccountRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        Account account = new Account();
        account.setAccountType(request.getAccountType());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);


        Customer customer1 = savedAccount.getCustomer();

        return getAccountResponse(savedAccount, customer1);


    }
    public AccountBalanceResponse getAccountBalance(Long accountId){

        Account account = getAccount(accountId);
        AccountBalanceResponse response = new AccountBalanceResponse();
        response.setCurrentBalance(account.getCurrentBalance());
        response.setPreviousBalance(account.getPreviousBalance());

        return response;

    }


    public List<AccountResponse> getAllAccountsByCustomerNumber(Long id) {
        return accountRepository.getAllAccountsByCustomerNumber(id)
                .stream()
                .map(account -> getAccountResponse(account, account.getCustomer()))
                .collect(Collectors.toList());
    }

    public List<AccountResponse> getAllAccountsByCivilId(Long id) {
        return accountRepository.getAllAccountsByCivilId(id)
                .stream()
                .map(account -> getAccountResponse(account, account.getCustomer()))
                .collect(Collectors.toList());

    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("account not found"));
    }
    @Transactional
    public AccountResponse updateAccount(Long id, AccountRequest request) {

        Account account = getAccount(id);
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));

        account.setAccountType(request.getAccountType());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);

        Customer customer1 = savedAccount.getCustomer();

        return getAccountResponse(savedAccount, customer1);


    }
    @Transactional
    public void DeleteAccount(Long id) {
        Account account = getAccount(id);
        accountRepository.deleteById(account.getAccountId());
    }

    private AccountResponse getAccountResponse(Account savedAccount, Customer customer1) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setMobileNumber(customer1.getMobileNumber());
        customerResponse.setCivilId(customer1.getCivilId());
        customerResponse.setCustomerId(customer1.getCustomerId());
        customerResponse.setCustomerNumber(customer1.getCustomerNumber());
        customerResponse.setFullName(customer1.getFullName());
        customerResponse.setDateOfBirth(customer1.getDateOfBirth());


        AccountResponse response = new AccountResponse();
        response.setAccountType(savedAccount.getAccountType());
        response.setCurrency(savedAccount.getCurrency());
        response.setCurrentBalance(savedAccount.getCurrentBalance());
        response.setPreviousBalance(savedAccount.getPreviousBalance());
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setCustomer(customerResponse);
        return response;
    }


}
