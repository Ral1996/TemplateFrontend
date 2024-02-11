package com.ral1996.sv.utilities;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class to select variables of the files .properties
                 and use for execute test in command line
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config-" + System.getProperty("environment") + ".properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
