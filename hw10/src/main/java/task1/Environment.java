package task1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    private final Properties properties = new Properties();

    public Environment(String propertyFileName) throws IOException {
        properties.load(new FileReader(propertyFileName));
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
