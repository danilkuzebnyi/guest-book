package javacode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SummerTyre extends Tyre {
    @Value("20")
    private int size;
    @Value("summer")
    private String name;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String driveAccordingToTheSeason() {
        return "I can drive at summer";
    }
}
