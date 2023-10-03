package RadiusFinder;

public class Cylinder extends Circle{

    private double height;

    public Cylinder() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double diameter_radius() {
        return getDiameter() / 2;
    }

    public double area_radius() { 
        return Math.sqrt(getArea() / 3.142);
    }

    public double circumference_radius() {
        return getCircumference() / (2 * 3.142);
    }

    public double volume() {
        return this.height * getArea();
    }

    public double diameter() { // 2 x sqrt(v/πh
        return 2 * Math.sqrt(volume() / (3.142 * this.height));
    }

    public double surface_area() { // 2πrh+2πr2
        return 2 * 3.142 * area_radius() * this.height + 2 * 3.142 * Math.pow(area_radius(), 2);
    }
}
