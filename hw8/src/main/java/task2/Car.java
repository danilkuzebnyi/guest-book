package task2;

@SuppressWarnings("unused")
public class Car {
    private String model;
    private String type;
    private String color;
    private int maxSpeed;
    private Engine engine;
    private Wheels wheels;

    public Car() {
    }

    public Car(String model, String type, String color, int maxSpeed, Engine engine, Wheels wheels) {
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.engine = engine;
        this.wheels = wheels;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", engine=" + engine +
                ", wheels=" + wheels +
                '}';
    }
}
