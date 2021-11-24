package task2;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double calculateArea() {
        return Math.PI * r * r;
    }

    public double calculatePerimeter() {
        return 2 * r * Math.PI;
    }
}
