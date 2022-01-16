package task1;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import task1.Objects.Cat;
import task1.Objects.User;
import javax.sql.DataSource;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        Environment env = new Environment("hw10\\src\\main\\resources\\application.properties");

        DataSource dataSource = createDataSource(env);

        applyDatabaseMigrations(dataSource);

        Storage storage = new DatabaseStorage(dataSource);

        for (int i = 1; i <= 20; i++) {
            Cat cat = new Cat();
            cat.setName("cat" + i);
            cat.setAge(i);
            storage.save(cat);
        }
        List<Cat> cats = storage.list(Cat.class);
        System.out.println(cats);

        for (Cat cat : cats) {
            System.out.println(storage.delete(cat));
        }
        cats = storage.list(Cat.class);
        System.out.println(cats);
        if (!cats.isEmpty()) throw new Exception("Cats should not be in database!");

        for (int i = 1; i <= 20; i++) {
            Cat cat = new Cat();
            cat.setName("cat" + i);
            cat.setAge(i);
            storage.save(cat);
        }
        cats = storage.list(Cat.class);
        System.out.println(cats);
        if (cats.size() != 20) throw new Exception("Number of cats in storage should be 20!");

        for (int i = 1; i <= 20; i++) {
            Cat cat = new Cat();
            cat.setId(i + 120);
            cat.setName("cat." + i);
            cat.setAge(i + 2);
            storage.save(cat);
        }

        User user = new User();
        user.setAdmin(true);
        user.setAge(23);
        user.setName("Victor");
        user.setBalance(22.23);
        storage.save(user);

        User user1 = storage.get(User.class, user.getId());
        if (!user1.getName().equals(user.getName())) throw new Exception("Users should be equals!");

        user.setAdmin(false);
        storage.save(user);

        User user2 = storage.get(User.class, user.getId());
        if (!user.getAdmin().equals(user2.getAdmin())) throw new Exception("Users should be updated!");

        storage.delete(user1);

        User user3 = storage.get(User.class, user.getId());

        if (user3 != null) throw new Exception("User should be deleted!");
    }

    private static DataSource createDataSource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }

    private static void applyDatabaseMigrations(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
    }
}
