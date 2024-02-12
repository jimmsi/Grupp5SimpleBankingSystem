package se.yrgo;

import java.util.Date;


public class Transaction {
    private Date date;
    private String description;
    private double amount;
    private Account accountFrom;
    private Account accountTo;

    public Transaction(Date date, String description, double amount, Account accountFrom, Account accountTo) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public double transferFunds(double amount, Account accountFrom, Account accountTo){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    
        if (accountFrom == null || accountTo == null) {
            throw new IllegalArgumentException("Both source and destination accounts must be specified.");
        }
    
        if (amount > accountFrom.getBalance()) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }
    
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
    
        return amount;
    }

    public double withdraw(double amount){

    }

    public double deposit(double amount){
        
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

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
