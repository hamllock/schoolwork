import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] arr = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q" };

        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int input = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("Base: ");
            int base = sc.nextInt();
            sc.nextLine();

            if (base >= 2 && base <= 27) {

                int remainder;
                Stack<Integer> stack = new Stack<>();
                while (input != 0) {
                    remainder = input % base;
                    input = input / base;
                    stack.push(remainder);
                }

                System.out.print("Output: ");
                while (!stack.empty()) {
                    System.out.print(arr[stack.pop()]);
                }
                
                sc.close();
                break;
            } else {
                System.out.println("Invalid output, base must be between 2 - 27");
            }
        }
    }
}