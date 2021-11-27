package task1;

public class Inventory {

    public static void main(String[] args) {
        Product chicken = new Product("chicken", 80, 4);
        Product fish = new Product("fish", 110.15, 13);
        Product milk = new Product("milk", 28.88, 7);
        Product cake = new Product("cake", 205.18, 5);
        Product cookie = new Product("cookie", 75.46, 2);

        double sum = 0;
        for (double value : Product.inventoryValue.values()) {
            sum += value;
        }
        System.out.println("The inventory value is " + sum);
    }
}
