package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Car {
    private Engine engine;
    private List<Wheel> wheels = new ArrayList<>();

    public Car(Engine engine) {
        this.engine = engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public void addWheels(Wheel wheel, int numberOfWheels) {
        for (int i = 0; i < numberOfWheels; i++) {
            wheels.add(wheel);
        }
    }

    @Autowired
    public String getDescription(List<Wheel> wheels) {
        return "Engine capacity: " + engine.getCapacity() + " liters; " + wheels.size() + " " +
                wheels.get(0).getTypeOfTyre() + " tires on wheels of " + wheels.get(0).getSizeOfTyre() + " size";
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", wheels=" + wheels +
                '}';
    }
}
