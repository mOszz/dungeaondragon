package fr.ecolenum.dd.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DotenvProperties {
    private static Properties properties;
    private DotenvProperties() {
        properties = loadProperties();
    }
    public static Properties propertiesGetInstance() {
        if (properties == null) {
            properties = loadProperties();
        }
        return properties;
    }

    private static Properties loadProperties() {
        Properties env = new Properties();
        String filename = ".env";
        try {
            env.load(new FileInputStream(filename));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties from file", e);
        }
        return env;
    }
}
