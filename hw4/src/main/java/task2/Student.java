package task2;

import java.math.BigDecimal;
import java.util.*;

public class Student extends Homework {
    String name;
    int maxAbsenteeism = 0;
    List<String> students = new ArrayList<>();
    Map<String, List> hwOfEachStudent = new LinkedHashMap<>();
    Map<String, List> deadlineOfEachStudent = new LinkedHashMap<>();
    Map<String, List> lectureOfStudent = new LinkedHashMap<>();
    Map<String, Integer> studentToAbsenteeism = new LinkedHashMap<>();
    Map<Integer, String> absenteeismToStudent = new LinkedHashMap<>();

    public void addStudent(String name) {
        this.name = name;
        students.add(name);
    }

    public void addHwToEachStudent() {
        for (String student : students) {
            hwOfEachStudent.put(student, giveGradesForHw(5));
        }
    }

    public void addDeadlineToEachStudent() {
        for (String student : students) {
            deadlineOfEachStudent.put(student, madeItToTheDeadline(5));
        }
    }

    public void beOnLecture(int numberOfLectures) {
        for (String student : students) {
            List<String> lectures = new LinkedList<>();
            for (int i = 0; i < numberOfLectures; i++) {
                boolean beOnLecture = r.nextBoolean();
                if (beOnLecture) {
                    lectures.add("+");
                } else {
                    lectures.add("-");
                }
            }
            int absenteeism = Collections.frequency(lectures, "-");
            studentToAbsenteeism.put(student, absenteeism);
            lectureOfStudent.put(student, lectures);
        }
        for (String student : studentToAbsenteeism.keySet()) {
            if (studentToAbsenteeism.get(student) > maxAbsenteeism) {
                maxAbsenteeism = studentToAbsenteeism.get(student);
                absenteeismToStudent.put(maxAbsenteeism, student);
            }
        }
        for (int absenteeism : absenteeismToStudent.keySet()) {
            if (absenteeism > maxAbsenteeism) {
                maxAbsenteeism = absenteeism;
            }
        }
        System.out.println("The student who missed the most lectures is " + absenteeismToStudent.get(maxAbsenteeism));
        for (int i = 0; i < lectureOfStudent.get(absenteeismToStudent.get(maxAbsenteeism)).size(); i++) {
            if (lectureOfStudent.get(absenteeismToStudent.get(maxAbsenteeism)).get(i) == "-") {
                System.out.printf("Student has to learn the %s lection", i + 1);
                System.out.println();
            }
        }

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
            ;
            if (numberOfFailedDeadlines >= 3) {
                students.remove(student);
            }
        }
    }
}
