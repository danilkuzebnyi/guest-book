package task1;

public class Inventory {

    public void countInventoryValue() {
        double sum = 0;
        for (double value : Product.inventoryValue.values()) {
            sum += value;
        }
        System.out.println("The inventory value is " + sum);
    }
}
