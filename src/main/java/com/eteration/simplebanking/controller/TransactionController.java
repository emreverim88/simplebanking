package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction/v1/")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public void createDepositTransaction(@Valid @RequestBody DepositTransaction depositTransaction) {
        transactionService.createDepositTransaction(depositTransaction);
    }

}
