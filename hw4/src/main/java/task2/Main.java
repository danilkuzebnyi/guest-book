package task2;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        student.addStudent("Danylo Kuzebnyi");
        student.addStudent("Igor Baranov");
        student.addStudent("Max Shevchenko");
        student.addStudent("Serhiy Antipov");
        student.addStudent("Yuriy Boiko");
        System.out.println(student.students);

        Teacher teacher = new Teacher();
        teacher.addTeacher("Dmytro Gordon");
        teacher.addTeacher("Oleksandr Usyk");
        System.out.println(teacher.teachers);
        teacher.checkHw(5);
        System.out.println(teacher.checkedBy);

        Homework hw = new Homework();
        hw.giveGradesForHw(5);
        System.out.println(hw.hwGrades);
        hw.madeItToTheDeadline(5);
        System.out.println(hw.deadline);
    }
}
