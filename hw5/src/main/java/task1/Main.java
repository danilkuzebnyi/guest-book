package task1;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        TaskManagerImpl task = new TaskManagerImpl();
        task.add(LocalDateTime.of(2021, 12, 6, 10, 0), new Task("morning duties", "do exercises"));
        task.add(LocalDateTime.of(2021, 12, 6, 8, 0), new Task("morning duties", "take a shower"));
        task.add(LocalDateTime.of(2021, 12, 6, 8, 0), new Task("morning duties", "have breakfast"));
        task.add(LocalDateTime.of(2021, 12, 6, 10, 0), new Task("job", "read materials"));
        task.add(LocalDateTime.of(2021, 12, 6, 11, 0), new Task("job", "make a website "));
        task.add(LocalDateTime.of(2021, 12, 6, 21, 0), new Task("sport", "visit gym"));
        task.add(LocalDateTime.of(2021, 12, 6, 19, 0), new Task("housework", "clean the house"));
        task.add(LocalDateTime.of(2021, 12, 6, 20, 0), new Task("housework", "cook food"));
        task.add(LocalDateTime.of(2021, 12, 6, 20, 0), new Task("housework", "iron the clothes"));
        task.add(LocalDateTime.now(), new Task("time", "look at time"));
        System.out.println("Tasks by date: " + task.tasksByDate);
        System.out.println("Tasks for today: " + task.getTasksForToday());
        task.addTasksToCategories();
        System.out.println("Tasks by categories: " + task.tasksByCategories);
        System.out.println("Categories: " + task.getCategories());
        System.out.println("Tasks by few categories: " + task.getTasksByCategories("sport", "housework"));
        System.out.println("Tasks by category: " + task.getTasksByCategory("morning duties"));
        task.remove(LocalDateTime.of(2021, 12, 6, 8, 0));
        System.out.println("Tasks by date after removing: " + task.tasksByDate);
    }
}
