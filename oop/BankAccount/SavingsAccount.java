package BankAccount;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, double currentBalance) {
        super(accountNumber, currentBalance);
    }

    @Override
    public void deposit(double amount) {
        setCurrentBalance(getCurrentBalance() + amount);
        System.out.println("Deposited " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getCurrentBalance()) {
            setCurrentBalance(getCurrentBalance() - amount);
            System.out.println("Withdrawed " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String toString() {
        return "Savings account " + getAccountNumber() + " Current balance: " + getCurrentBalance();
    }
}
