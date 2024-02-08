package se.yrgo;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    public void testTransaction() {
        Date date = new Date();
        String description = "Test transaction";
        double amount = 100.0;

        Transaction transaction = new Transaction(date, description, amount);

        assertEquals(date, transaction.getDate());
        assertEquals(description, transaction.getDescription());
        assertEquals(amount, transaction.getAmount(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Date date = new Date();
        String description = "Test transaction";
        double amount = 100.0;

        Transaction transaction = new Transaction(date, description, amount);

        Date newDate = new Date();
        String newDescription = "New transaction";
        double newAmount = 200.0;

        transaction.setDate(newDate);
        transaction.setDescription(newDescription);
        transaction.setAmount(newAmount);

        assertEquals(newDate, transaction.getDate());
        assertEquals(newDescription, transaction.getDescription());
        assertEquals(newAmount, transaction.getAmount(), 0.001);
    }

    @Test
    public void testToString() {
        Date date = new Date();
        String description = "Test transaction";
        double amount = 100.0;

        Transaction transaction = new Transaction(date, description, amount);

        String expectedString = "Transaction{date=" + date + ", description='" + description + "', amount=" + amount + '}';
        assertEquals(expectedString, transaction.toString());
    }
}
