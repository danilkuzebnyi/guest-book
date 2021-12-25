package task2;

import java.lang.reflect.Field;

public class CloneCreator {
    public static Object createClone(Object object, Object clonedObject) throws IllegalAccessException {
        Class objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            field.set(clonedObject, value);
            field.setAccessible(false);
        }
        return clonedObject;
    }
}
