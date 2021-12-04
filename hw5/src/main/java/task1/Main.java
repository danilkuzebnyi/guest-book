package task1;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        TaskManagerImpl task = new TaskManagerImpl();
        task.add(LocalDateTime.of(2021, 12, 6, 8, 0), new Task("morning duties" , "do exercises"));
        task.add(LocalDateTime.of(2021, 12, 6, 8, 0), new Task("morning duties" , "take a shower"));
        task.add(LocalDateTime.of(2021, 12, 6, 9, 0), new Task("morning duties" , "have breakfast"));
        task.add(LocalDateTime.of(2021, 12, 6, 10, 0), new Task("job" , "read materials"));
        task.add(LocalDateTime.of(2021, 12, 6, 11, 0), new Task("job" , "make a website "));
        task.add(LocalDateTime.of(2021, 12, 6, 18, 0), new Task("sport" , "visit gym"));
        task.add(LocalDateTime.of(2021, 12, 6, 19, 0), new Task("housework" , "clean the house"));
        task.add(LocalDateTime.of(2021, 12, 6, 20, 0), new Task("housework" , "cook food"));
        task.add(LocalDateTime.of(2021, 12, 6, 20, 0), new Task("housework" , "iron the clothes"));
        System.out.println(task.tasksByDate);
        System.out.println(task.categoriesByDate);
        task.remove(LocalDateTime.of(2021, 12, 6, 8, 0));
        System.out.println(task.tasksByDate);
        task.getCategories();
        System.out.println(task.categories);
        task.getTasksByCategories("housework", "sport");
        System.out.println(task.tasksByCategories);
    }
}
