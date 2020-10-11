package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Optional<DepositTransaction> findById(int id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void createDepositTransaction(DepositTransaction depositTransaction) {
        transactionRepository.save(depositTransaction);
    }

}
