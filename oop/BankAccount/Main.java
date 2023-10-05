package BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //receive account number
        BankAccount account = new SavingsAccount(sc.nextInt(), 0);
        sc.nextLine();
        System.out.println(account.toString());
        
        //receive deposit
        account.deposit(sc.nextDouble());
        sc.nextLine();

        System.out.println(account.toString());

        //receive withdraw
        account.withdraw(sc.nextDouble());
        sc.nextLine();
 
        System.out.println(account.toString());

        //================================================================

        //receive account number
        account = new CheckingAccount(sc.nextInt(), 0);
        sc.nextLine();
        System.out.println(account.toString());

        //receive deposit
        account.deposit(sc.nextDouble());
        sc.nextLine();

        System.out.println(account.toString());

        //receive withdraw
        account.withdraw(sc.nextDouble());
        sc.nextLine();

        System.out.println(account.toString());

    }
}