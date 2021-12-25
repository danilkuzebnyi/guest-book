package task2;

public class Engine {
    private int power;
    private double capacity;

    public Engine(int power, double capacity) {
        this.power = power;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", capacity=" + capacity +
                '}';
    }
}
