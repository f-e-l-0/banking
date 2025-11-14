package com.feloo.banking.service.impl;

import com.feloo.banking.dto.AccountDto;
import com.feloo.banking.entity.Account;
import com.feloo.banking.mapper.AccountMapper;
import com.feloo.banking.repository.AccountRepository;
import com.feloo.banking.service.AccountService;
import org.springframework.stereotype.Service;




@Service
public class AccountServiceImpl implements AccountService {

/// methods Implimantions class  ....they are implimented from the cccountRepository class

    private AccountRepository accountRepository;

    // dependency injection
// we can use @Autowired to automatically inject The dependency when they are mo than one
    // but spring automatically inject the dependency by default  when its only one
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }



    @Override
  public   AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccountDto(accountDto);
        //local variable introduction Account After calling the account repository to save //account
        Account savedAccount=  accountRepository.save(account);
        return AccountMapper.mapToAccount(savedAccount);

    }


    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        return AccountMapper.mapToAccount(account);
    }


    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
       double total= account.getBalance()+amount;
       account.setBalance(total);
       ///introduce a local  variable and  save the changes to the account
      Account saved=  accountRepository.save(account);
      ///return type comes from the varibale
        return AccountMapper.mapToAccount(saved);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient Balance");

        }
        double total= account.getBalance()-amount;
        account.setBalance(total);
// can work without creating a local variable for the return type
        return AccountMapper.mapToAccount(accountRepository.save(account));
    }


}
