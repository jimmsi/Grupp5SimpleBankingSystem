package se.yrgo;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    public void testTransferFunds() {
        // Create two accounts
        Account accountFrom = new Account("123", 1000);
        Account accountTo = new Account("456", 500);

        // Create a transaction
        Date date = new Date();
        Transaction transaction = new Transaction(date, "Transfer", 200, accountFrom, accountTo);

        // Perform the transfer
        transaction.transferFunds();

        // Check if the balance of both accounts has been updated correctly
        assertEquals(800, accountFrom.getBalance(), 0.001); // 1000 - 200
        assertEquals(700, accountTo.getBalance(), 0.001); // 500 + 200
    }
}
