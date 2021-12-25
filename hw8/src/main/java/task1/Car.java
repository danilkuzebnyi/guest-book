package task1;

@SuppressWarnings("unused")
public class Car {
    private String model;
    private String type;
    private String color;
    private int maxSpeed;

    public Car(String model, String type, String color, int maxSpeed) {
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String race(Car car) {
        return "Automobile " + car.model + " will take part in races!";
    }
}
