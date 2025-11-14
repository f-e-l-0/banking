package com.feloo.banking.service;

import com.feloo.banking.dto.AccountDto;



public interface AccountService {


    ///  Methods Definitions
    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);

    AccountDto withdraw(Long id,double amount);

    /// transer to another account

    ///AccountDto checkBalance()



}
