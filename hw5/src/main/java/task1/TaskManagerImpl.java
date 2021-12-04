package task1;

import java.time.LocalDateTime;
import java.util.*;

public class TaskManagerImpl implements TaskManager{
    Set<String> categories = new LinkedHashSet<>();
    Map<LocalDateTime, String> tasksByDate  = new TreeMap<>();
    Map<LocalDateTime, String> categoriesByDate  = new TreeMap<>();
    Map<LocalDateTime, List<Task>> listTasksByDate= new TreeMap<>();
    Map<String, String> tasksByCategories= new TreeMap<>();
    List<Task> tasksForToday = new ArrayList<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        tasksByDate.put(date, task.getName());
        categoriesByDate.put(date, task.getCategory());
        tasksByCategories.put(task.getCategory(), task.getName());
    }

    @Override
    public void remove(LocalDateTime date) {
        tasksByDate.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        for (LocalDateTime dateTime : categoriesByDate.keySet()) {
            categories.add(categoriesByDate.get(dateTime));
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        for (String category : categories) {

        }
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {

        return null;
    }

    @Override
    public List<Task> getTasksForToday() {
        return tasksForToday;
    }
}
