package com.feloo.banking.mapper;

import com.feloo.banking.dto.AccountDto;
import com.feloo.banking.entity.Account;

public class AccountMapper {
// converting account dto to account
    public  static Account mapToAccountDto(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getUserName(),
                accountDto.getEmail(),
                accountDto.getAge(),
                accountDto.getBalance(),
                accountDto.getPosition()
        );
        return account;
    }
    //converting account to account dto

    public static AccountDto mapToAccount(Account account){

        AccountDto accountDto=new AccountDto(
               account.getId(),
                account.getUserName(),
                account.getEmail(),
                account.getAge(),
                account.getBalance(),
                account.getPosition()
        );
        return accountDto;

    }
}