package task3;

import task1.Ignore;

public class Car {
    private String model;
    private String type;
    private String color;
    private int maxSpeed;
    private int passengerCapacity;
    @Ignore
    private final int power = 250;

    public Car(String model, String type, String color, int maxSpeed, int passengerCapacity) {
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.passengerCapacity = passengerCapacity;
    }
}
