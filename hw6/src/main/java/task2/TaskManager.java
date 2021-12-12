package task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    List<Task> tasks = new ArrayList<>();
    Map<LocalDate, Task> tasksByDate = new TreeMap<>();
    List<Task> fiveNearestImportantTasks = new ArrayList<>();
    List<Task> fiveNearestImportantTasksReversed = new ArrayList<>();
    List<Task> listOfDoneTasks = new ArrayList<>();
    List<Task> listOfUncompletedTasks = new ArrayList<>();
    Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress = new HashMap<>();

    public void addTask(Task task) {
        tasks.add(task);
        tasksByDate.put(task.getStartsOn(), task);
    }

    List<Task> find5NearestImportantTasks(List<Task> tasks) {
        fiveNearestImportantTasks.addAll(tasksByDate.values());
        int size = fiveNearestImportantTasks.size();
        for (int i = size - 1; i >= 0; i--) {
            fiveNearestImportantTasksReversed.add(fiveNearestImportantTasks.get(i));
        }
        return fiveNearestImportantTasksReversed.stream()
                .filter(task -> !task.isDone() && task.getType() == TaskType.IMPORTANT)
                .limit(5)
                .collect(Collectors.toList());
    }

    List<String> getUniqueCategories(List<Task> tasks) {
        return null;
    }

    Map<String, List<Task>> getCategoriesWithTasks(List<Task> tasks) {
        return null;
    }

    Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress(List<Task> tasks) {
        for (Task task : tasks) {
            if (task.isDone()) {
                listOfDoneTasks.add(task);
            }
            else if (!task.isDone()) {
                listOfUncompletedTasks.add(task);
            }
        }
        splitTasksIntoDoneAndInProgress.put(true, listOfDoneTasks);
        splitTasksIntoDoneAndInProgress.put(false, listOfUncompletedTasks);
        return splitTasksIntoDoneAndInProgress;
    }

    boolean existsTaskOfCategory(List<Task> tasks, String category) {
        return true;
    }

    String getTitlesOfTasks(List<Task> tasks, int startNo, int endNo) {
        return null;
    }

    Map<String, Long> getCountsByCategories(List<Task> tasks) {
        return null;
    }

    IntSummaryStatistics getCategoriesNamesLengthStatistics(List<Task> tasks) {
        return null;
    }

    Task findTaskWithBiggestCountOfCategories(List<Task> tasks) {
        return null;
    }
}
