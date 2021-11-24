package task2;

public class Triangle implements Shape {

    private static double a;
    private static double b;
    private static double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double calculatePerimeter() {
        return a + b + c;
    }

    public static boolean doesTriangleExist() {
        return (a + b > c) &&
                (a + c > b) &&
                (b + c > a);
    }
}
