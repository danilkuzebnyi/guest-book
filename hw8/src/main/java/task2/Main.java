package task2;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Wheels wheels = new Wheels(4);
        Engine engine = new Engine(280, 2.5);
        Car car1 = new Car("BMW X5", "hatchback", "black", 250, engine, wheels);
        Car car2 = new Car();
        System.out.println(car1);
        System.out.println(CloneCreator.createClone(car1, car2));
        System.out.println();
        car2.setModel("BMW X6");
        System.out.println(car1);
        System.out.println(car2);
    }
}
