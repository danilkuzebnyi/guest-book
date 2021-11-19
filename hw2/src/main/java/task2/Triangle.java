package task2;

public class Triangle implements Shape {

    public double calculateArea() {
        double p = (Input.getA() + Input.getB() + Input.getC()) / 2;
        return Math.sqrt(p * (p - Input.getA()) * (p - Input.getB()) * (p - Input.getC()));
    }

    public double calculatePerimeter() {
        return Input.getA() + Input.getB() + Input.getC();
    }

    public static boolean doesTriangleExist() {
        return (Input.getA() + Input.getB() > Input.getC()) &&
                (Input.getA() + Input.getC() > Input.getB()) &&
                (Input.getB() + Input.getC() > Input.getA());
    }
}
