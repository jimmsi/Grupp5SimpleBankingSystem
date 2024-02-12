package se.yrgo;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    @Test
    public void testDeposit() {
        Account account = new Account("123456", 1000.0);
        account.deposit(500.0);

        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        Account account = new Account("123456", 1000.0);
        account.withdraw(500.0);

        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegativeAmount() {
        Account account = new Account("123456", 1000.0);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-500.0));
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Account account = new Account("123456", 1000.0);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-500.0));
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        Account account = new Account("123456", 1000.0);

        assertThrows(IllegalStateException.class, () -> account.withdraw(1500.0));
    }
}
