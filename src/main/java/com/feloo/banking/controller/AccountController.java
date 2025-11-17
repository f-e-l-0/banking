package com.feloo.banking.controller;

import com.feloo.banking.dto.AccountDto;
import com.feloo.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//passing the base url
@RequestMapping("/api/accounts")
public class AccountController {
    //dependency injection
    private AccountService accountService;

//creation of constructor
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account REST API
//create a Method then you will make that method as a spring Api using spring annotations
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    //Get account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


    /// Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        AccountDto accountDto = accountService.deposit(id, request.get("amount"));

        return ResponseEntity.ok(accountDto);
    }



    /// withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {
        AccountDto accountDto = accountService.withdraw(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }



}
