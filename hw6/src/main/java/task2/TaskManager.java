package task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskManager {
    List<Task> tasks = new ArrayList<>();
    Map<LocalDate, Task> tasksByDate = new TreeMap<>();

    public void addTask(Task task) {
        tasks.add(task);
        tasksByDate.put(task.getStartsOn(), task);
    }

    List<Task> find5NearestImportantTasks(List<Task> tasks) {
        List<Task> fiveNearestImportantTasksReversed = new ArrayList<>();
        List<Task> fiveNearestImportantTasks = new ArrayList<>(tasksByDate.values());
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
        Set<String> uniqueCategories = new TreeSet<>();
        for (Task task : tasks) {
            uniqueCategories.addAll(task.getCategories());
        }
        return new ArrayList<>(uniqueCategories);
    }

    Map<String, List<Task>> getCategoriesWithTasks(List<Task> tasks) {
        Map<String, List<Task>> categoriesWithTasks = new HashMap<>();
        Set<String> uniqueCategories = new TreeSet<>();
        for (Task task : tasks) {
            uniqueCategories.addAll(task.getCategories());
        }
        for (String category : uniqueCategories) {
            List<Task> listOfTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.getCategories().contains(category)) {
                    listOfTasks.add(task);
                }
            }
            categoriesWithTasks.put(category, listOfTasks);
        }
        return categoriesWithTasks;
    }

    Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress(List<Task> tasks) {
        List<Task> listOfDoneTasks = new ArrayList<>();
        List<Task> listOfUncompletedTasks = new ArrayList<>();
        Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress = new HashMap<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                listOfDoneTasks.add(task);
            } else if (!task.isDone()) {
                listOfUncompletedTasks.add(task);
            }
        }
        splitTasksIntoDoneAndInProgress.put(true, listOfDoneTasks);
        splitTasksIntoDoneAndInProgress.put(false, listOfUncompletedTasks);
        return splitTasksIntoDoneAndInProgress;
    }

    boolean existsTaskOfCategory(List<Task> tasks, String category) {
        try {
            Map<String, List<Task>> categoriesByTasks = new HashMap<>(getCategoriesWithTasks(tasks));
            Stream<Map> stream = Stream.of(categoriesByTasks);
            return stream.anyMatch(map -> categoriesByTasks.get(category).size() >= 1);
        } catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    String getTitlesOfTasks(List<Task> tasks, int startNo, int endNo) {
        StringBuilder titles = new StringBuilder();
        List<String> titleOfTasks = new ArrayList<>();
        List<Task> tasksByIdRange = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getId() >= startNo && task.getId() <= endNo) {
                tasksByIdRange.add(task);
            }
        }
        for (Task task : tasksByIdRange) {
            titleOfTasks.add(task.getTitle());
        }
        for (String titleOfTask : titleOfTasks) {
            titles.append(titleOfTask).append(", ");
        }
        return titles.substring(0, titles.length() - 2);
    }

    Map<String, Long> getCountsByCategories(List<Task> tasks) {
        Map<String, List<Task>> categoriesByTasks = new HashMap<>(getCategoriesWithTasks(tasks));
        Map<String, Long> countsByCategories = new TreeMap<>();
        for (String category : categoriesByTasks.keySet()) {
            countsByCategories.put(category, (long) categoriesByTasks.get(category).size());
        }
        return countsByCategories;
    }

    IntSummaryStatistics getCategoriesNamesLengthStatistics(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.summarizingInt(task -> task.getCategories().size()));
    }

    Task findTaskWithBiggestCountOfCategories(List<Task> tasks) {
        Map<Integer, Task> sizeOfCategoriesByTask = tasks.stream()
                .collect(Collectors.toMap(
                        task -> task.getCategories().size(),
                        Task -> Task,
                        (task1, task2) -> task1));
        int maxSize = 0;
        for (Integer sizeOfCategories : sizeOfCategoriesByTask.keySet()) {
            if (sizeOfCategories > maxSize) {
                maxSize = sizeOfCategories;
            }
        }
        return sizeOfCategoriesByTask.get(maxSize);
    }
}
