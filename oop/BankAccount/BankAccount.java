package BankAccount;

public abstract class BankAccount {
    private final int accountNumber;
    private double currentBalance;

    public BankAccount(int accountNumber, double currentBalance) {
        this.currentBalance = currentBalance;
        this.accountNumber = accountNumber;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
