package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.DepositTransaction;

import java.util.Optional;

public interface ITransactionService {
    Optional<DepositTransaction> findById(int id);

    void createDepositTransaction(DepositTransaction depositTransaction);
}
