package se.yrgo;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String date;
    private String description;
    private double amount;
    private Account accountFrom;
    private Account accountTo;
    public static List<Transaction> transactionList = new ArrayList<>();

    public Transaction(String date, String description, double amount, Account accountFrom, Account accountTo) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (accountFrom == null || accountTo == null) {
            throw new IllegalArgumentException("Both source and destination accounts must be specified.");
        }

        if (amount > accountFrom.getBalance()) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }

        Transaction.withdraw(amount, accountFrom);
        Transaction.deposit(amount, accountTo);

        transactionList.add(this);
    }

    public Transaction(String date, String description, double amount, Account accountTo){
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.accountTo = accountTo;

        if (description.equals("withdraw")) {
            Transaction.withdraw(amount, accountTo);
        }
        if (description.equals("deposit")) {
            Transaction.deposit(amount, accountTo);
        }
        transactionList.add(this);
    }

    public static void withdraw(double amount, Account accountNumber) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > accountNumber.getBalance()) {
            throw new IllegalStateException("Insufficient funds in the account.");
        }
        accountNumber.setBalance(accountNumber.getBalance() - amount);
    }

    public static void deposit(double amount, Account accountNumber) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        accountNumber.setBalance(accountNumber.getBalance() + amount);
    }

    @Override
    public String toString() {
        return "Transaction [date=" + date + ", description=" + description + ", amount=" + amount + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo + "]";
    }
}