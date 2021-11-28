package task2;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    List<String> teachers = new ArrayList<>();

    public void addTeacher(String name) {
        this.name = name;
        teachers.add(name);
    }

}
