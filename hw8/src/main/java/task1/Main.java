package task1;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Cat cat1 = new Cat("black", 9, 4, 45);
        Cat cat2 = new Cat("grey", 6, 4, 38);
        Cat cat3 = new Cat("white", 13, 4, 40);
        Car car = new Car("RX-7", "sedan", "white", 200);
        Human human = new Human("male", 25, 182, 77);
        BeanRepresenter representer = new BeanRepresenter(car);
        representer.representFields();
        representer.representConstructors();
        representer.representMethods();
    }
}
