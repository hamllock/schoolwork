package MidtermExam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String barName = "JAVA";

        String managerName = sc.nextLine();
        double managerSalary = sc.nextDouble();
        sc.nextLine();
        Manager manager = new Manager(managerName, barName, managerSalary);

        String cashierName = sc.nextLine();
        double cashierSalary = sc.nextDouble();
        sc.nextLine();
        Cashier cashier = new Cashier(cashierName, barName, cashierSalary);

        String waiterName = sc.nextLine();
        double waiterSalary = sc.nextDouble();
        sc.nextLine();
        ArrayList<Integer> tableNumber = new ArrayList<>();
        ArrayList<Double> tip = new ArrayList<>();

        while (true) {
            tableNumber.add(sc.nextInt());
            tip.add(sc.nextDouble());
            sc.nextLine();

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("n")) {
                break;
            }
        }
        Waiter waiter = new Waiter(waiterName, barName, tableNumber, tip, waiterSalary);

        System.out.println(manager.getName() + " is the new manager of " + manager.getBarName()
                + " Bar and has a salary of " + manager.getSalary());
        System.out.println(cashier.getName() + " is the new cashier of " + cashier.getBarName()
                + " Bar and has a salary of " + cashier.getSalary());
        System.out.println(waiter.getName() + " is the waiter of " + waiter.getBarName()
                + " Bar and has a salary of " + waiter.getSalary());
        System.out.println(waiter.getName() + " serviced the following table(s) " + waiter.employeeTask());
        System.out.println(cashier.getName() + " has taken a total of " + waiter.getTableNumber().size() + " order(s)");

    }
}
