package task1;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import task1.Annotations.Ignore;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatabaseStorage implements Storage {

    private final JdbcTemplate jdbcTemplate;
    private final TableNameResolver tableNameResolver = new TableNameResolver();
    private final TableColumnResolver tableColumnResolver = new TableColumnResolver();

    public DatabaseStorage(DataSource dataSource) {
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
    public <T extends Entity> void save(T entity) throws IllegalAccessException {
        Class<? extends Entity> clazz = entity.getClass();
        Map<String, Object> fieldsAndTheirValues = prepareEntity(entity);

        if (entity.isNew()) {
            List<String> columnNames = new ArrayList<>(fieldsAndTheirValues.keySet());
            String columnName = String.join(", ", columnNames);
            int numberOfColumns = fieldsAndTheirValues.size();

            String questionMarkElement = IntStream.range(0, numberOfColumns)
                    .mapToObj(index -> "?")
                    .collect(Collectors.joining(", "));

            KeyHolder keyHolder = new GeneratedKeyHolder();
            String SQL = "INSERT INTO " + tableNameResolver.resolve(clazz)
                    + "(" + columnName + ") VALUES(" + questionMarkElement + ") RETURNING id";
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < fieldsAndTheirValues.size(); i++) {
                    Field field = tableColumnResolver.resolveField(columnNames.get(i), clazz);
                    ps.setObject(i + 1, fieldsAndTheirValues.get(tableColumnResolver.resolve(field)));
                }
                return ps;
            }, keyHolder);
            entity.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        }
        if (!entity.isNew()) {
            int id = entity.getId();
            for (String fieldName : fieldsAndTheirValues.keySet()) {
                jdbcTemplate.update("UPDATE " + tableNameResolver.resolve(clazz) + " SET " + fieldName
                        + " = '" + fieldsAndTheirValues.get(fieldName) + "' WHERE id = ?", id);
            }
        }
    }


    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws IllegalAccessException {
        Map<String, Object> fieldsAndTheirValues = new HashMap<>();
        Class<? extends Entity> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            } else {
                field.setAccessible(true);
                fieldsAndTheirValues.put(tableColumnResolver.resolve(field), field.get(entity));
                field.setAccessible(false);
            }
        }
        return fieldsAndTheirValues;
    }
}
