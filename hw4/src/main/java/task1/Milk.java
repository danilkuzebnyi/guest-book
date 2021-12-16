package task1;

import java.util.Random;

public class Milk extends Product {
    Random random = new Random();

    public Milk(String name, double price, int qty) {
        super(name, price, qty);
    }

    public void isSpoiled() {
        boolean spoiled = random.nextBoolean();
        if (spoiled) {
            System.out.println("Milk is spoiled");
        } else {
            System.out.println("Milk isn't spoiled");
        }
    }

}
