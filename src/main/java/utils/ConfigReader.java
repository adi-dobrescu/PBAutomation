package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties initProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
