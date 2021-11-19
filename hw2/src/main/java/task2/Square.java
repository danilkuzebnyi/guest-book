package task2;

public class Square implements Shape {

    public double calculateArea() {
        return Input.getA() * Input.getA();
    }

    public double calculatePerimeter() {
        return 4 * Input.getA();
    }

    public static double calculateTrianglePerimeter() {
        double hypotenuse = Math.sqrt(2) * Input.getA();
        return 2 * Input.getA() + hypotenuse;
    }
}
