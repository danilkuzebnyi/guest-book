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
                System.out.print("Enter the radius: ");
                shape = new Circle(in.nextDouble());
                break;
            case SQUARE:
                System.out.print("Enter the side length: a = ");
                shape = new Square(in.nextDouble());
                break;
            case RECTANGLE:
                System.out.println("Enter the sides length a and b:");
                shape = new Rectangle(in.nextDouble(), in.nextDouble());
                break;
            case TRIANGLE:
                while (!Triangle.doesTriangleExist()) {
                    System.out.println("Enter an existing triangle");
                    System.out.println("Enter the sides length a, b, c:");
                    shape = new Triangle(in.nextDouble(), in.nextDouble(), in.nextDouble());
                }
                break;
        }

        System.out.printf("The area of %s is: " + shape.calculateArea() + "\n", type);
        System.out.printf("The perimeter of %s is: " + shape.calculatePerimeter() + "\n", type);
        if (type == Form.SQUARE) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", type);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + (Square.a * (2 + Math.sqrt(2))), type);
        }
        if (type == Form.RECTANGLE) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", type);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + (Rectangle.a + Rectangle.b + Math.sqrt(Rectangle.a * Rectangle.a + Rectangle.b * Rectangle.b)), type);
        }

    }
}