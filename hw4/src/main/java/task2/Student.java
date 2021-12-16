package task2;

import java.math.BigDecimal;
import java.util.*;

public class Student {
    Random random = new Random();
    static List<String> students = new ArrayList<>();
    static Map<String, List> hwOfEachStudent = new LinkedHashMap<>();
    Map<String, List> deadlineOfEachStudent = new LinkedHashMap<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public static void addHwToEachStudent() {
        for (String student : students) {
            hwOfEachStudent.put(student, Homework.giveGradesForHw(5));
        }
    }

    public void addDeadlineToEachStudent() {
        for (String student : students) {
            deadlineOfEachStudent.put(student, Homework.madeItToTheDeadline(5));
        }
    }

    public void beOnLecture(int numberOfLectures) {
        Map<String, List> lectureOfStudent = new LinkedHashMap<>();
        Map<Integer, String> absenteeismToStudent = new LinkedHashMap<>();

        for (String student : students) {
            List<String> lectures = new LinkedList<>();
            for (int i = 0; i < numberOfLectures; i++) {
                boolean beOnLecture = random.nextBoolean();
                if (beOnLecture) {
                    lectures.add("+");
                } else {
                    lectures.add("-");
                }
            }
            int absenteeism = Collections.frequency(lectures, "-");
            absenteeismToStudent.put(absenteeism, student);
            lectureOfStudent.put(student, lectures);
        }
        int maxAbsenteeism = absenteeismToStudent.keySet()
                .stream()
                .max(Integer::compareTo)
                .get();
        System.out.println("The student who missed the most lectures is " + absenteeismToStudent.get(maxAbsenteeism));
        for (int i = 0; i < lectureOfStudent.get(absenteeismToStudent.get(maxAbsenteeism)).size(); i++) {
            if (lectureOfStudent.get(absenteeismToStudent.get(maxAbsenteeism)).get(i) == "-") {
                System.out.printf("Student has to learn the %s lecture %n", i + 1);
            }
        }
        System.out.println("Attendance at lectures: " + lectureOfStudent);
    }

    public void removeStudent() {
        for (String student : hwOfEachStudent.keySet()) {
            List<BigDecimal> listOfGrades = new ArrayList<>();
            listOfGrades = hwOfEachStudent.get(student);
            int lengthListOfGrades = listOfGrades.size();
            double sum = 0;
            for (int i = 0; i < lengthListOfGrades; i++) {
                double grade = Double.parseDouble(listOfGrades.get(i).toString());
                sum += grade;
            }
            double averageGrade = sum / lengthListOfGrades;
            if (averageGrade < 3.5) {
                students.remove(student);
            }
        }

        for (String student : deadlineOfEachStudent.keySet()) {
            List<String> listOfDeadlines = new ArrayList<>();
            listOfDeadlines = deadlineOfEachStudent.get(student);
            int numberOfFailedDeadlines = Collections.frequency(listOfDeadlines, "-");
            if (numberOfFailedDeadlines >= 3) {
                students.remove(student);
            }
        }
    }
}
