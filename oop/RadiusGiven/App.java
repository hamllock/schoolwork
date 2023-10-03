package RadiusGiven;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double radius, height;
        System.out.print("Radius: ");
        radius = sc.nextDouble();

        System.out.print("Height: ");
        height = sc.nextDouble();
        

        Circle circle = new Circle(radius);
        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Diameter: " + circle.diameter());
        System.out.println("Circle Circumference: " + circle.circumference());

        System.out.println("Cylinder Surface Area: " + cylinder.surfaceArea());
        System.out.println("Cylinder Volume: " + cylinder.volume());
    }
}
