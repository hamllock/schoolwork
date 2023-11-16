package Shapes2;

public class Square implements GetArea {
    // +sides(double)
    // +Create your getArea override, area of square is sides2
    // +toString, to print the area of the shape

    private double sides;

    public Square(double sides) {
        this.sides = sides;
    }

    public double getArea() {
        return sides * sides;
    }

    public String toString() {
        return "Area of the square is: " + getArea();
    }
}
