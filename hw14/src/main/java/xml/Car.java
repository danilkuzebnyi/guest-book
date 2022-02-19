package xml;

import java.util.List;

public class Car {
    private Engine engine;
    private List<Wheel> wheels;

    public Car(Engine engine, List<Wheel> wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public String getDescription(Wheel wheel) {
        return "Engine capacity: " + engine.getCapacity() + " liters; " + wheels.size() + " " +
                wheel.getTypeOfTyre() + " tires on wheels of " + wheel.getSizeOfTyre() + " size";
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", wheels=" + wheels +
                '}';
    }
}
