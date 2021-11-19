package task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shape shape = null;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the figure what will be calculated: ");
        Form type = Form.valueOf(in.nextLine().toUpperCase());

        switch (type) {
            case CIRCLE:
                shape = new Circle();
                System.out.print("Enter the radius: ");
                Input.setR(in.nextDouble());
                break;
            case SQUARE:
                shape = new Square();
                System.out.print("Enter the side length: a = ");
                Input.setA(in.nextDouble());
                break;
            case RECTANGLE:
                shape = new Rectangle();
                System.out.print("Enter the sides length:\na = ");
                Input.setA(in.nextDouble());
                System.out.print("b = ");
                Input.setB(in.nextDouble());
                break;
            case TRIANGLE:
                shape = new Triangle();
                while (!Triangle.doesTriangleExist()) {
                    System.out.println("Enter an existing triangle");
                    System.out.print("Enter the sides length:\na = ");
                    Input.setA(in.nextDouble());
                    System.out.print("b = ");
                    Input.setB(in.nextDouble());
                    System.out.print("c = ");
                    Input.setC(in.nextDouble());
                }
                break;
        }

        System.out.printf("The area of %s is: " + shape.calculateArea() + "\n", type);
        System.out.printf("The perimeter of %s is: " + shape.calculatePerimeter() + "\n", type);
        if (type == Form.SQUARE) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", type);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + Square.calculateTrianglePerimeter(), type);
        }
        if (type == Form.RECTANGLE) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", type);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + Rectangle.calculateTrianglePerimeter(), type);
        }

    }
}