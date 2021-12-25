package task3;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Car car1 = new Car("BMW X3", "hatchback", "white", 210, 5);
        Car car2 = new Car("BMW X6", "hatchback", "black", 255, 7);
        BeanComparator.compareTwoObjects(car1, car2);
    }
}
