package task2;

public class Rectangle implements Shape {

    protected static double a;
    protected static double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculateArea() {
        return a * b;
    }

    public double calculatePerimeter() {
        return 2 * (a + b);
    }
}
