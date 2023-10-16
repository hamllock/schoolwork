import java.util.Scanner;

public class Vales_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal, base;
        String result;
        while (true) {
            System.out.print("decimal value: ");
            decimal = sc.nextInt();
            sc.nextLine();

            if (decimal < 0) {
                System.out.println("thank you for using the program. bye!");
                break;
            }

            System.out.print("target base: ");
            base = sc.nextInt();
            sc.nextLine();

            result = convert(decimal, base);

            System.out.println("value of " + decimal + " in base " + base + " is " + result);
        }
        sc.close();
    }

    public static String convert(int decimal, int base) {
        String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F" };
        int remainder = decimal % base;
        int quotient = decimal / base;

        if (quotient == 0) {
            return hex[remainder];
        } else {
            return convert(quotient, base) + hex[remainder];
        }
    }
}