package com.wipro.CustomerAccountTracker.DTO;

public class TransferRequest {
    private long fromAccount;  // Change from int to long
    private long toAccount;    // Change from int to long
    private double amount;     // Keep double for amount

    // Getters and Setters
    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
