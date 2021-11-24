package task2;

public class Square implements Shape {

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
