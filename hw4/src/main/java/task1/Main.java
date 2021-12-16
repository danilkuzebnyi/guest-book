package task1;

public class Main {

    public static void main(String[] args) {
        Product chicken = new Meat("chicken", 80, 4);
        Product fish = new Fish("fish", 110.15, 13);
        Product cake = new Sweets("cake", 205.18, 5);
        Product cookie = new Sweets("cookie", 75.46, 2);
        Milk milk = new Milk("milk", 28.88, 7);
        milk.isSpoiled();
        Inventory inventory = new Inventory();
        inventory.countInventoryValue();
    }
}
