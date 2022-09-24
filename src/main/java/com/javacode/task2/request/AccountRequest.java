package com.javacode.task2.request;


import com.javacode.task2.constant.AccountType;
import com.javacode.task2.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRequest {

    private Long accountId;
    private Long accountNumber;
    private String currency;
    private BigDecimal currentBalance;
    private BigDecimal previousBalance;
    private AccountType accountType;
    private Long customerId;
}
