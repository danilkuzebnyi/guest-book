package task1;

public class Task {
    private String name;
    private String category;

    public Task(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

}
