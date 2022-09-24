package com.javacode.task2.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {

    private Long customerId;
    private Long customerNumber;
    private Long civilId;
    private LocalDate dateOfBirth;
    private String fullName;
    private String mobileNumber;
}
