package task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shape shape = null;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the figure what will be calculated: ");
        String figure = in.nextLine();
        if ("circle".equalsIgnoreCase(figure)) {
            System.out.print("Enter the radius: ");
            shape = new Circle(in.nextDouble());
        } else if ("square".equalsIgnoreCase(figure)) {
            System.out.print("Enter the side length: a = ");
            shape = new Square(in.nextDouble());
        } else if ("rectangle".equalsIgnoreCase(figure)) {
            System.out.println("Enter the sides length a and b:");
            shape = new Rectangle(in.nextDouble(), in.nextDouble());
        } else if ("triangle".equalsIgnoreCase(figure)) {
            while (!Triangle.doesTriangleExist()) {
                System.out.println("Enter an existing triangle");
                System.out.println("Enter the sides length a, b, c:");
                shape = new Triangle(in.nextDouble(), in.nextDouble(), in.nextDouble());
            }
        }

        System.out.printf("The area of %s is: " + shape.calculateArea() + "\n", figure);
        System.out.printf("The perimeter of %s is: " + shape.calculatePerimeter() + "\n", figure);
        if ("square".equalsIgnoreCase(figure)) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", figure);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + (Square.a * (2 + Math.sqrt(2))) , figure);
        }
        if ("rectangle".equalsIgnoreCase(figure)) {
            System.out.printf("The area of triangle in the %s is: " + shape.calculateArea() / 2 + "\n", figure);
            System.out.printf("The perimeter of triangle in the %s is: "
                    + (Rectangle.a + Rectangle.b + Math.sqrt(Rectangle.a * Rectangle.a + Rectangle.b * Rectangle.b)), figure);
        }
    }
}