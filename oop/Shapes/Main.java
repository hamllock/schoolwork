package Shapes;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Shape("red");
        Shape rectangle = new Rectangle("red", 10, 10);
        Shape triangle = new Triangle("red", 10, 10);

        getArea(shape);
        getArea(rectangle);
        getArea(triangle);

    }

    public static void getArea(Shape s) {
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            System.out.println("Rectangle area is " + r.getArea() + " (" + r.toString() + ")");
        } else if (s instanceof Triangle) {
            Triangle t = (Triangle) s;
            System.out.println("Triangle area is " + t.getArea() + " (" + t.toString() + ")");
        } else {
            System.out.println("Invalid option");
        }
    }
}
