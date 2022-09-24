package com.javacode.task2.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {
    private Long customerId;
    private Long customerNumber;
    private Long civilId;
    private LocalDate dateOfBirth;
    private String fullName;
    private String mobileNumber;
}
