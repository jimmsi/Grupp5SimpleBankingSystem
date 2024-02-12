package se.yrgo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import se.yrgo.Customer;
import se.yrgo.Account;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "john@example.com");

        assertEquals(1, customer.getCustomerID());
        assertEquals("John Doe", customer.getName());
        assertEquals("123 Main St", customer.getAdress());
        assertEquals("john@example.com", customer.getEmail());
    }

    @Test
    public void testAddAccount() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "john@example.com");
        Account account = new Account("123456", 1000.0);

        customer.addAccount(account);

        assertEquals(1, customer.getAccountList().size());
        assertEquals(account, customer.getAccountList().get(0));
    }

    @Test
    public void testToString() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "john@example.com");
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);

        customer.addAccount(account1);
        customer.addAccount(account2);

        String expectedToString = "Customer {customerID = 1, name = 'John Doe', adress = '123 Main St', email = 'john@example.com', accountList = [" + account1.toString() + ", " + account2.toString() + "]}";

        assertEquals(expectedToString, customer.toString());
    }
}
