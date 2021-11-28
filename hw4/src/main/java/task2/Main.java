package task2;

public class Main {

    public static void main(String[] args) {
        Homework hw = new Homework();
        hw.addTeacher("Dmytro Gordon");
        hw.addTeacher("Oleksandr Usyk");
        hw.giveGradesForHw(5);

        Student student = new Student();
        student.addStudent("Danylo Kuzebnyi");
        student.addStudent("Igor Baranov");
        student.addStudent("Maxim Shevchenko");
        student.addStudent("Serhiy Antipov");
        student.addStudent("Yuriy Boiko");
        student.addHwToEachStudent();
        student.addDeadlineToEachStudent();
        student.beOnLecture(5);
        System.out.println("lectures: " + student.lectureOfStudent);
        student.removeStudent();
        System.out.println("students who stayed: " + student.students);
        System.out.println(student.hwOfEachStudent);
        System.out.println("deadlines: " + student.deadlineOfEachStudent);

    }
}
