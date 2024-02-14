package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransactionTest {

    @Test
    public void testValidTransaction() {
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);
        Transaction transaction = new Transaction("2024-02-12", "Transfer", 200.0, account1, account2);

        assertEquals(800.0, account1.getBalance(), 0.001);
        assertEquals(700.0, account2.getBalance(), 0.001);
    }

    @Test
    public void testException() {
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);
        Account account3 = null;

        // Attempting to create a transaction with a negative amount should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction("2024-02-12", "Transfer", -200.0, account1, account2);
        });
        // Attempting to create a transaction with null source account should also throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction("2024-02-12", "Transfer", -200.0, account3, account3);
        });
    }

    @Test
    public void testInsufficientFundsException() {
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);

        // Attempting to create a transaction with an amount greater than the balance of the source account should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            new Transaction("2024-02-12", "Transfer", 1500.0, account1, account2);
        });
    }

}
