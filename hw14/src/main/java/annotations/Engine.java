package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    @Value("4")
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "capacity=" + capacity +
                '}';
    }
}
