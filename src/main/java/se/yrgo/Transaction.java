package se.yrgo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private Date date;
    private String description;
    private double amount;
    private Account accountFrom;
    private Account accountTo;
    private static List<Transaction> transactionList = new ArrayList<>();

    public Transaction(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        transactionList.add(this);
    }

    public void transferFunds(double amount, Account accountFrom, Account accountTo) {
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
    }

    public static void withdraw(double amount, Account accountNumber) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > accountNumber.getBalance()) {
            throw new IllegalStateException("Insufficient funds in the account.");
        }
        accountNumber.balance -= amount;
    }

    public static void deposit(double amount, Account accountNumber) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        accountNumber.balance += amount;
    }
    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public Account getAccountFrom() {

        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {

        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {

        return accountTo;
    }

    public void setAccountTo(Account accountTo) {

        this.accountTo = accountTo;
    }

    @Override
    public String toString() {
        return "Transaction [date=" + date + ", description=" + description + ", amount=" + amount + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo + "]";
    }
}