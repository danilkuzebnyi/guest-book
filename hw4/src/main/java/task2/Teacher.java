package task2;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Homework {
    String name;
    List<String> teachers = new ArrayList<>();
    List<String> checkedBy = new ArrayList<>();

    public void addTeacher(String name) {
        this.name = name;
        teachers.add(name);
    }

    public void checkHw(int numberOfHw) {
        for (int i = 0; i < numberOfHw; i++) {
            int x = r.nextInt(2);
            if (x == 0) {
                checkedBy.add(teachers.get(0));
            }
            else {
                checkedBy.add(teachers.get(1));
            }
        }
    }
}
