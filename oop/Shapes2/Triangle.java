public class Triangle implements GetArea {
    // +base(double)
    // +height(double)
    // +Create your getArea override, area of triangle is 0.5 * base * height
    // +toString, to print the area of the shape

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String toString() {
        return "Area of the triangle is: " + getArea();
    }
}
