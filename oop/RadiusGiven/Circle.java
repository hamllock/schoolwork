package RadiusGiven;
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double diameter() {
        return this.radius * 2;
    }

    public double area() { 
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double circumference() {
        return 2 * Math.PI * this.radius;
    }
}
