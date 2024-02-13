package se.yrgo;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount to the account.
     * Throws IllegalArgumentException if the amount is less than or equal to 0.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
    }

    /**
     * Withdraws the specified amount from the account.
     * Throws IllegalArgumentException if the amount is less than or equal to 0.
     * Throws IllegalStateException if insufficient funds.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds in the account.");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
    }
}
