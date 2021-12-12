package task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void printCollection(Collection collection) {
        for (Object obj : collection) {
            System.out.println(obj.toString());
        }
    }

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
        TaskManager tasks = new TaskManager();
        tasks.addTask(new Task(1, TaskType.IMPORTANT, "homework1", true, LocalDate.of(2021, 12, 1)));
        tasks.addTask(new Task(2, TaskType.UNIMPORTANT, "homework2", true, LocalDate.of(2021, 12, 4)));
        tasks.addTask(new Task(3, TaskType.IMPORTANT, "homework3", false, LocalDate.of(2021, 12, 6)));
        tasks.addTask(new Task(4, TaskType.IMPORTANT, "homework4", false, LocalDate.of(2021, 12, 2)));
        tasks.addTask(new Task(5, TaskType.UNIMPORTANT, "homework5", false, LocalDate.of(2021, 12, 5)));
        tasks.addTask(new Task(6, TaskType.IMPORTANT, "homework6", true, LocalDate.of(2021, 12, 3)));
        tasks.addTask(new Task(7, TaskType.IMPORTANT, "homework7", false, LocalDate.of(2021, 12, 7)));
        tasks.addTask(new Task(8, TaskType.IMPORTANT, "homework8", false, LocalDate.of(2021, 12, 10)));
        tasks.addTask(new Task(9, TaskType.IMPORTANT, "homework9", false, LocalDate.of(2021, 12, 9)));
        tasks.addTask(new Task(10, TaskType.IMPORTANT, "homework10", false, LocalDate.of(2021, 12, 8)));
        System.out.println(tasks.tasks);
        //print(tasks.tasksByDate);
        //print(tasks.find5NearestImportantTasks(tasks.tasks));
        print(tasks.splitTasksIntoDoneAndInProgress(tasks.tasks));
    }
}
