package com.eteration.simplebanking.model;

// This class is a place holder you can change the complete implementation

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String accountNumber;

    @Column
    private String owner;

    @Column
    private double balance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(String owner, String accountNumber) {

        this.owner = owner;
        this.accountNumber = accountNumber;

        //this.transactions = Collections.<Transaction>emptyList();

        // DepositTransaction depositTransaction = new DepositTransaction();
        //   this.transactions.add(depositTransaction);

        // List<Transaction> transactions = Collections.<Transaction>emptyList();
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        if ("DepositTransaction".equals(transaction.getType())) {
            this.balance += transaction.amount;
            transactions.add(transaction);
        }

        if ("WithdrawalTransaction".equals(transaction.getType())) {
            if (this.balance < transaction.amount) {
                throw new InsufficientBalanceException();
            } else {
                this.balance -= transaction.amount;
                transactions.add(transaction);
            }
        }
    }

    public double deposit(double credit) {
        this.balance += credit;
        return credit;
    }

    public double withdraw(double debit) throws InsufficientBalanceException {

        if (this.balance < debit) {

            throw new InsufficientBalanceException();
        } else
            this.balance -= debit;

        return debit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
