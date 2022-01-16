package task1;

import task1.Annotations.Table;

public class TableNameResolver {

    public <T extends Entity> String resolve(Class<T> clazz) {
        String tableName = clazz.getSimpleName().toLowerCase();
        if (clazz.isAnnotationPresent(Table.class)) {
            Table annotation = clazz.getAnnotation(Table.class);
            tableName = annotation.name();
        }
        return tableName;
    }
}
