package ProjExer11;

import java.util.*;

public class UseSubject {
    public static void main(String[] args) {
        Subject[] data = new Subject[10];
        Scanner sc = new Scanner(System.in);
        String x;
        int y;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the subject code: ");
            x = sc.nextLine();
            System.out.println("Enter the credit units: ");
            y = sc.nextInt();
            sc.nextLine();

            data[i] = new Subject(x, y);
        }

        System.out.printf("--------------------------------%n");
        System.out.printf("| %-10s | %-8s |%n", "SUBJCODE", "UNITS");
        System.out.printf("--------------------------------%n");

        for (int i = 0; i < 10; i++) {
            System.out.printf("| %-10s | %-8s |%n", data[i].getCode(), data[i].getUnits(), 64);
        }

        System.out.printf("--------------------------------%n");
    }
}
