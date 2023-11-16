package ProjExer16;

import java.util.*;

public class Vales_Converter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int input = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("Base: ");
            int base = sc.nextInt();
            sc.nextLine();

            if (base >= 2 && base <= 9) {

                int remainder;
                Stack<Integer> stack = new Stack<>();
                while (input != 0) {
                    remainder = input % base;
                    input = input / base;
                    stack.push(remainder);
                }

                System.out.print("Output: ");
                while (!stack.empty()) {
                    System.out.print(stack.pop());
                }

                sc.close();
                break;
            } else {
                System.out.println("Invalid output, base must be between 2 - 9");
            }
        }
    }
}