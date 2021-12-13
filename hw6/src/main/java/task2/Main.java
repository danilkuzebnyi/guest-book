package task2;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
        TaskManager tasks = new TaskManager();
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("category1");
        set1.add("category2");
        tasks.addTask(new Task(1, TaskType.IMPORTANT, "homework1", true, set1, LocalDate.of(2021, 12, 1)));
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("category1");
        set2.add("category2");
        set2.add("category3");
        set2.add("category4");
        tasks.addTask(new Task(2, TaskType.UNIMPORTANT, "homework2", true, set2, LocalDate.of(2021, 12, 4)));
        Set<String> set3 = new LinkedHashSet<>();
        set3.add("category1");
        set3.add("category2");
        set3.add("category3");
        tasks.addTask(new Task(3, TaskType.IMPORTANT, "homework3", false, set3, LocalDate.of(2021, 12, 6)));
        Set<String> set4 = new LinkedHashSet<>();
        set4.add("category1");
        tasks.addTask(new Task(4, TaskType.IMPORTANT, "homework4", false, set4, LocalDate.of(2021, 12, 2)));
        Set<String> set5 = new LinkedHashSet<>();
        set5.add("category2");
        set5.add("category3");
        tasks.addTask(new Task(5, TaskType.UNIMPORTANT, "homework5", false, set5, LocalDate.of(2021, 12, 5)));
        Set<String> set6 = new LinkedHashSet<>();
        set6.add("category3");
        set6.add("category4");
        tasks.addTask(new Task(6, TaskType.IMPORTANT, "homework6", true, set6, LocalDate.of(2021, 12, 3)));
        Set<String> set7 = new LinkedHashSet<>();
        set7.add("category2");
        set7.add("category3");
        set7.add("category4");
        tasks.addTask(new Task(7, TaskType.IMPORTANT, "homework7", false, set7, LocalDate.of(2021, 12, 7)));
        Set<String> set8 = new LinkedHashSet<>();
        set8.add("category1");
        tasks.addTask(new Task(8, TaskType.IMPORTANT, "homework8", false, set8, LocalDate.of(2021, 12, 10)));
        Set<String> set9 = new LinkedHashSet<>();
        set9.add("category1");
        set9.add("category3");
        tasks.addTask(new Task(9, TaskType.IMPORTANT, "homework9", false, set9, LocalDate.of(2021, 12, 9)));
        Set<String> set10 = new LinkedHashSet<>();
        set10.add("category1");
        set10.add("category2");
        set10.add("category5");
        tasks.addTask(new Task(10, TaskType.IMPORTANT, "homework10", false, set10, LocalDate.of(2021, 12, 8)));
        print(tasks.find5NearestImportantTasks(tasks.tasks));
        print(tasks.splitTasksIntoDoneAndInProgress(tasks.tasks));
        print(tasks.getTitlesOfTasks(tasks.tasks, 2, 5));
        print(tasks.getUniqueCategories(tasks.tasks));
        print(tasks.getCategoriesWithTasks(tasks.tasks));
        print(tasks.findTaskWithBiggestCountOfCategories(tasks.tasks));
        print(tasks.existsTaskOfCategory(tasks.tasks, "category1"));
        print(tasks.getCountsByCategories(tasks.tasks));
        print(tasks.getCategoriesNamesLengthStatistics(tasks.tasks));

    }
}
