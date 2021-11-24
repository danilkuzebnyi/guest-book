package task1;

public class Square extends Shape {
    protected static double a;

    public Square(double a) {
        this.a = a;
    }

    public double calculateArea() {
        return a * a;
    }

    public double calculatePerimeter() {
        return 4 * a;
    }
}
