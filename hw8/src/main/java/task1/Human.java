package task1;

@SuppressWarnings("all warnings")
public class Human {
    private String gender;
    private int age;
    private int height;
    private int weight;

    public Human(String gender, int age, int height, int weight) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public double calculateWeightToHeightRatio(Human human) {
        return human.weight / (human.height * human.height);
    }

    public boolean isWorkable(Human human) {
        return human.age <= 60 && human.age >= 18;
    }
}
