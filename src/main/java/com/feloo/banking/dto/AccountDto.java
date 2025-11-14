package com.feloo.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class AccountDto {


    private long id;
    private String userName;
    private String email;
    private double age;
    private double balance;
    private String  position;


}
