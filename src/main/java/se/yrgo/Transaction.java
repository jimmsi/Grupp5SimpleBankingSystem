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

    /**
     * Constructs a transaction between two accounts, transferring a specified amount from one account to another.
     * Validates that the amount is positive, both accounts are specified, and the source account has sufficient funds.
     * Automatically performs the withdrawal from the source account and the deposit to the destination account.
     * Adds the transaction to a global list of transactions.
     *
     * @param date The date of the transaction.
     * @param description A description of the transaction.
     * @param amount The monetary amount to be transferred.
     * @param accountFrom The account from which the funds will be withdrawn.
     * @param accountTo The account to which the funds will be deposited.
     * @throws IllegalArgumentException If the amount is less than or equal to zero, or if either account is null.
     * @throws IllegalStateException If the source account has insufficient funds.
     */
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

        accountFrom.withdraw(amount);
        accountTo.deposit(amount);

        transactionList.add(this);
    }

    /**
     * Constructs a transaction for a single account, intended for deposits or withdrawals based on the description.
     * The transaction is executed as either a deposit or a withdrawal on the specified account and added to a global list of transactions.
     *
     * @param date The date of the transaction.
     * @param description A description of the transaction indicating whether it is a "deposit" or "withdraw".
     * @param amount The monetary amount to be deposited or withdrawn.
     * @param accountTo The account on which the transaction is performed. This account is either credited or debited based on the description.
     * @throws IllegalArgumentException If the amount is less than or equal to zero (implicit through account methods).
     */
    public Transaction(String date, String description, double amount, Account accountTo){
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.accountTo = accountTo;

        if (description.equals("withdraw")) {
            accountTo.withdraw(amount);
        }
        if (description.equals("deposit")) {
            accountTo.deposit(amount);
        }
        transactionList.add(this);
    }

    @Override
    public String toString() {
        return "Transaction [date=" + date + ", description=" + description + ", amount=" + amount + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo + "]";
    }
}