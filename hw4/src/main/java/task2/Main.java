package task2;

public class Main {

    public static void main(String[] args) {
        Homework.giveGradesForHw(5);

        Student student = new Student();
        student.addStudent("Danylo Kuzebnyi");
        student.addStudent("Igor Baranov");
        student.addStudent("Maxim Shevchenko");
        student.addStudent("Serhiy Antipov");
        student.addStudent("Yuriy Boiko");
        student.addHwToEachStudent();
        student.addDeadlineToEachStudent();
        student.beOnLecture(5);
        student.removeStudent();

        Teacher teacher = new Teacher();
        teacher.addTeacher("Dmytro Gordon");
        teacher.addTeacher("Oleksandr Usyk");
        teacher.addHwToEachTeacher();

        System.out.println("These students get such grades as: " + student.hwOfEachStudent);
        System.out.println("deadlines: " + student.deadlineOfEachStudent);
        System.out.println("students who stayed: " + student.students);

    }
}
