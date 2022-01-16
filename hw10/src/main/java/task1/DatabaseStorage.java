package task1;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import task1.Annotations.Ignore;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatabaseStorage implements Storage {

    private final DataSource dataSource;
    private final org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
    private final TableNameResolver tableNameResolver = new TableNameResolver();
    private final TableColumnResolver tableColumnResolver = new TableColumnResolver();
    private Map<String, Object> fieldsAndTheirValues = new HashMap<>();

    public DatabaseStorage(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) {
        return jdbcTemplate.query("SELECT * FROM " + tableNameResolver.resolve(clazz) + " WHERE id = ?",
                new BeanPropertyRowMapper<>(clazz), id).stream().findAny().orElse(null);
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) {
        return jdbcTemplate.query("SELECT * FROM " + tableNameResolver.resolve(clazz),
                new BeanPropertyRowMapper<>(clazz));
    }

    @Override
    public <T extends Entity> boolean delete(T entity) {
        Class<? extends Entity> clazz = entity.getClass();
        int id = entity.getId();
        int sizeOfListBeforeDeleting = list(clazz).size();
        jdbcTemplate.update("DELETE FROM " + tableNameResolver.resolve(clazz) + " WHERE id = ?", id);
        int sizeOfListAfterDeleting = list(clazz).size();
        return sizeOfListBeforeDeleting != sizeOfListAfterDeleting;
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException, IllegalAccessException {
        Class<? extends Entity> clazz = entity.getClass();
        fieldsAndTheirValues = prepareEntity(entity);
        Field[] fields = clazz.getDeclaredFields();
        int id = entity.getId();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            }
            if (!entity.isNew()) {
                jdbcTemplate.update("UPDATE " + tableNameResolver.resolve(clazz) + " SET " +
                        tableColumnResolver.resolve(field) + " = '" +
                        fieldsAndTheirValues.get(tableColumnResolver.resolve(field)) + "' WHERE id = ?", id);
            } else if (entity.isNew()) {
                List<String> columnElements = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
                String columnElement = String.join(", ", columnElements);
                int numberOfColumns = fields.length;
                String questionMarkElement = IntStream.range(0, numberOfColumns)
                        .mapToObj(index -> "?")
                        .collect(Collectors.joining(", "));
                jdbcTemplate.update("INSERT INTO " + tableNameResolver.resolve(clazz) + "(" + columnElement + ") VALUES("
                        + questionMarkElement + ")", fields[0].get(entity), fields[1].get(entity));
            }
        }
    }

    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws IllegalAccessException {
        Class<? extends Entity> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldsAndTheirValues.put(field.getName(), field.get(entity));
        }
        return fieldsAndTheirValues;
    }
}
