package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Homework {
    String name;
    List<String> students = new ArrayList<>();
    Map<String, Homework> HwOfStudent = new HashMap<>();

    public void addStudent(String name) {
        this.name = name;
        students.add(name);
    }
}
