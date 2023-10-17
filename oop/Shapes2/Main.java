import java.util.*;

public class Main {
    public static void main(String[] args) {
        // SAMPLE INPUT
        // 5 10
        // 15
        // 12 20
        // 18

        // SAMPLE OUTPUT
        // Area of the rectangle is: 50.0
        // Area of the square is: 225.0
        // Area of the triangle is: 120.0
        // Area of the circle is: 1017.36

        Scanner sc = new Scanner(System.in);
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        double sides = sc.nextDouble();
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double radius = sc.nextDouble();

        Rectangle rectangle = new Rectangle(length, width);
        Square square = new Square(sides);
        Triangle triangle = new Triangle(base, height);
        Circle circle = new Circle(radius);

        System.out.println("Area of the rectangle is: " + rectangle.getArea());
        System.out.println("Area of the square is: " + square.getArea());
        System.out.println("Area of the triangle is: " + triangle.getArea());
        System.out.println("Area of the circle is: " + circle.getArea());

        sc.close();
    }
}
