package se.yrgo;

import static se.yrgo.Transaction.transactionList;
//Test för jenkins
public class Main {
    public static void main(String[] args) {
        // Create accounts
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);

        System.out.println("Initial balance on account 1: " + account1.getBalance());
        System.out.println("Initial balance on account 2: " + account2.getBalance());
        System.out.println("");

        // Create a customer
        Customer customer = new Customer(1, "John Doe", "123 Main St", "john@example.com");
        customer.addAccount(account1);
        customer.addAccount(account2);

        // Display customer information
        System.out.println("Customer Information:");
        System.out.println(customer);
        System.out.println("");

        // Perform transactions
        try {
            // Transfer from account1 to account2
            Transaction transferTransaction = new Transaction("2024-02-14", "Transfer", 200.0, account1, account2);
            System.out.println("Transfer Transaction:");
            System.out.println(transferTransaction);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Withdraw from account1
            Transaction withdrawTransaction = new Transaction("2024-02-14", "withdraw", 100.0, account1);
            System.out.println("");
            System.out.println("Withdraw Transaction:");
            System.out.println(withdrawTransaction);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Deposit to account2
            Transaction depositTransaction = new Transaction("2024-02-14", "deposit", 300.0, account2);
            System.out.println("");
            System.out.println("Deposit Transaction:");
            System.out.println(depositTransaction);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display updated account balances
        System.out.println("");
        System.out.println("Updated Account Balances:");
        System.out.println("Account 1 Balance: " + account1.getBalance());
        System.out.println("Account 2 Balance: " + account2.getBalance());
        System.out.println("");
        System.out.println("All Transactions:");
        for (Transaction transaction : Transaction.transactionList) {
            System.out.println(transaction);
        }
    }
}
