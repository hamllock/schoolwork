package Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		Triangle triangle = new Triangle();

        triangle.setSide1(sc.nextDouble());
        triangle.setSide2(sc.nextDouble());
        triangle.setSide3(sc.nextDouble());
        sc.nextLine();
        triangle.setColor(sc.nextLine());

        if (sc.nextLine().equalsIgnoreCase("f")) {
            triangle.setFilled(false);
        } else {
            triangle.setFilled(true);
        }
        sc.close();
        System.out.println("area: " + triangle.area());
		System.out.println("perimeter: " + String.format("%.1f", triangle.perimeter()));
		System.out.println("color: " + triangle.getColor());
        System.out.println("filled: " + triangle.isFilled());
    }
}
