import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> basevalue = new Stack<>();

        String[] arr = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q"
        };

        for (String x : arr) {
            basevalue.push(x);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        int input = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.println("Base: ");
            int base = sc.nextInt();
            sc.nextLine();

            if (base >= 2 && base <= 27) {
                for (int i = 0; i < 27 - base; i++) {
                    basevalue.pop();
                }

                int remainder;
                Stack<Integer> stack = new Stack<>();
                while (input != 0) {
                    remainder = input % base;
                    input = input / base;
                    stack.push(remainder);
                }

                while (!stack.empty()) {
                    String get = basevalue.get(stack.pop());
                    System.out.print(get);
                }

                break;
            } else {
                System.out.println("Invalid output, base must be between 2 - 27");
            }
        }
    }
}