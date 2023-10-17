public class Rectangle implements GetArea {
    // +length(double)
    // +width(double)
    // +Create your getArea override, area of rectangle is lenght * width
    // +toString, to print the area of the shape

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return "Area of the rectangle is: " + getArea();
    }

}
