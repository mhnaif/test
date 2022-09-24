package com.javacode.task2.response;


import com.javacode.task2.constant.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountBalanceResponse {

    private Long accountId;
    private BigDecimal currentBalance;
    private BigDecimal previousBalance;

}
