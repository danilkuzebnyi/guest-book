package task1;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class DatabaseStorage implements Storage {

    private DataSource dataSource;
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    public DatabaseStorage(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (StorageException e) {
            throw e;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        return null;
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        //TODO: Implement me
        return false;
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Entity> clazz = entity.getClass();
        Object object = clazz.getConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        /*for (Field field : fields) {
            field.setAccessible(true);
            jdbcTemplate.update("INSERT INTO " + clazz.getSimpleName().toLowerCase() +
                    "(" + field.getName() + ") VALUES(?) WHERE id = " + entity.getId(), field.get(entity));
        }*/

        jdbcTemplate.update("INSERT INTO cat(name, age) VALUES(?, ?)", fields[0].get(entity), fields[1].get(entity));
    }

    //creates list of new instances of clazz by using data from the result set
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        /*
        This method must a create a resulting list of entities. Fill objects with data from the results set.
        Use reflection to create an instance of given class. Extract data from result set by class' field name.
         */
        return null;
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws StorageException {
        //TODO: Implement me and use in the save method
        return null;
    }
}
