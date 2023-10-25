package org.example;

public class BankAccount {

    private double balance;
    private double minimumBalance;
    private String accountHolderName;

    public BankAccount(double balance, double minimumBalance, String accountHolderName) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit balance cannot be negative or zero");
        } else {
            double newBalance = this.getBalance() + amount;
            this.setBalance(newBalance);
        }
        return this.getBalance();
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw balance cannot be negative or zero");
        } else if ((this.getBalance() - amount) < this.getMinimumBalance()) {
            throw new IllegalArgumentException("You have insufficient funds");
        } else {
            double newBalance = this.getBalance() - amount;
            this.setBalance(newBalance);
        }
        return this.getBalance();
    }
}
