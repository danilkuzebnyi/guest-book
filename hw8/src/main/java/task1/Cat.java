package task1;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Cat {
    private String color;
    private int age;
    private int legCount;
    private int fullLength;

    public Cat(String color, int age, int legCount, int fullLength) {
        this.color = color;
        this.age = age;
        this.legCount = legCount;
        this.fullLength = fullLength;
    }

    @Ignore
    public static List<Cat> addCat(Cat... cats) {
        List<Cat> allCats = new LinkedList<>();
        allCats.addAll(List.of(cats));
        return allCats;
    }

    public String say() {
        return "Meow";
    }

    public void play() {
    }
}
