package task2;

import java.math.BigDecimal;
import java.util.*;

public class Teacher {
    List<String> teachers = new ArrayList<>();

    public void addTeacher(String name) {
        teachers.add(name);
    }

    public void addHwToEachTeacher() {
        List<BigDecimal> allGrades = new ArrayList<>();
        Map<BigDecimal, String> hwCheckedBy = new LinkedHashMap<>();

        for (List grades : Student.hwOfEachStudent.values()) {
            allGrades.addAll(grades);
        }

        Random random = new Random();
        for (BigDecimal grade : allGrades) {
            int randomIndex = random.nextInt(teachers.size());
            hwCheckedBy.put(grade, teachers.get(randomIndex));
        }

        String teacherWhoSet5 = "Teachers don't want to set grade of 5";
        for (BigDecimal grade : hwCheckedBy.keySet()) {
            if (grade.equals(BigDecimal.valueOf(5.0))) {
                teacherWhoSet5 = hwCheckedBy.get(grade);
            }
        }
        System.out.println("Teacher who set grade of 5 is: " + teacherWhoSet5);
        System.out.println("Homework checked by: " + hwCheckedBy);
    }

}
