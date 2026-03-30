package utils;

import java.io.*;
import java.util.Properties;

public class FileUtility {

    static String propertiesFilePath = "./src/test/resources/config.properties";

    // Method to write or update a property
    public static void write(String key, String value) throws IOException {
        Properties props = new Properties();

        // Load existing properties if file exists
        File file = new File(propertiesFilePath);
        if (file.exists()) {
            try (InputStream input = new FileInputStream(file)) {
                props.load(input);
            }
        }

        // Set the new property
        props.setProperty(key, value);

        // Write back to file
        try (OutputStream output = new FileOutputStream(file)) {
            props.store(output, null);
        }
    }

    // Method to read a property
    public static String read(String key) throws IOException {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            props.load(input);
        }

        return props.getProperty(key);
    }
}