public class Circle implements GetArea {
    // +radius(double)
    // +final PI(double)(3.14)
    // +Create your getArea override, area of circle is PI * radius2
    // +toString, to print the area of the shape

    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public String toString() {
        return "Area of the circle is: " + getArea();
    }
}
