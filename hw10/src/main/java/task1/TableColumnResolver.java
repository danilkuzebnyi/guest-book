package task1;

import task1.Annotations.Column;

import java.lang.reflect.Field;

public class TableColumnResolver {

    public <T extends Entity> Field resolveField(String raw, Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return fields[0];
    }

    public String resolve(Field field) {
        String fieldName = field.getName();
        if (field.isAnnotationPresent(Column.class)) {
            Column annotation = field.getAnnotation(Column.class);
            fieldName = annotation.name();
        }
        return fieldName;
    }
}
