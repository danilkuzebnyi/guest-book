package task3;

import task1.Ignore;
import java.lang.reflect.Field;

public class BeanComparator {
    public static void compareTwoObjects(Object object1, Object object2) throws IllegalAccessException {
        Class<?> clazz = object1.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.format("%-20s%-14s%-12s%-6s%n", "Field", "A", "B", "Match");
        for (Field field : fields) {
            if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            } else {
                field.setAccessible(true);
                Object object1Value = field.get(object1);
                Object object2Value = field.get(object2);
                boolean areObjectsEqual = object1Value.equals(object2Value);
                System.out.format("%-20s%-14s%-12s%-6s%n", field.getName(), object1Value, object2Value, areObjectsEqual);
                field.setAccessible(false);
            }
        }
    }
}
