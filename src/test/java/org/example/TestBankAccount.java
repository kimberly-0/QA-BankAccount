package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBankAccount {

    @Test
    public void depositShouldIncreaseBalance() {
        BankAccount ba = new BankAccount(0, 0, "John Doe");

        double expected = 100;
        double actual = ba.deposit(100);

        assertEquals(expected, actual);
    }

    @Test
    public void negativeDepositShouldThrowError() {
        BankAccount ba = new BankAccount(0, 0, "John Doe");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> ba.deposit(-100));

        assertTrue(thrown.getMessage().contains("Deposit balance cannot be negative or zero"));
    }

    @Test
    public void withdrawShouldLowerBalance() {
        BankAccount ba = new BankAccount(500, 0, "John Doe");

        double expected = 450;
        double actual = ba.withdraw(50);

        assertEquals(expected, actual);
    }

    @Test
    public void withdrawWithOverdraftShouldLowerBalance() {
        BankAccount ba = new BankAccount(0, -10, "John Doe");

        double expected = -10;
        double actual = ba.withdraw(10);

        assertEquals(expected, actual);
    }

    @Test
    public void negativeWithdrawShouldThrowError() {
        BankAccount ba = new BankAccount(500, 0, "John Doe");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(-100));

        assertTrue(thrown.getMessage().contains("Withdraw balance cannot be negative or zero"));
    }

    @Test
    public void withdrawMoreThanAvailableShouldThrowError() {
        BankAccount ba = new BankAccount(200, 0, "John Doe");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(201));

        assertTrue(thrown.getMessage().contains("You have insufficient funds"));
    }

    @Test
    public void withdrawMoreThanAvailableWithOverdraftShouldThrowError() {
        BankAccount ba = new BankAccount(0, -10, "John Doe");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> ba.withdraw(11));

        assertTrue(thrown.getMessage().contains("You have insufficient funds"));
    }

}
