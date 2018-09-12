package com.sda.weatherapi.properties;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {

    private static final Path propertyFile = Paths.get("src/main/resources/application.properties");

    public static void saveConfiguration() {

        Properties properties = new Properties();
        properties.setProperty("url", "http://api.apixu.com/v1/current.json");
        properties.setProperty("key", "336d39b18670470196780108180709");

        try {
            Writer propertiesWriter = Files.newBufferedWriter(propertyFile);
            properties.store(propertiesWriter, "Application properties");
            propertiesWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppProperties loadProperties() {
        AppProperties appProperties = new AppProperties();
        try {
            Reader propertiesReader = Files.newBufferedReader(propertyFile);
            Properties properties = new Properties();
            properties.load(propertiesReader);
            appProperties.setUrl(properties.getProperty("url"));
            appProperties.setKey(properties.getProperty("key"));
            propertiesReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProperties;
    }
}
