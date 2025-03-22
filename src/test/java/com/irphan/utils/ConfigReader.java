package com.irphan.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            // Ambil nama file dari parameter -DconfigFile=nama.properties
            String fileName = System.getProperty("configFile", "config.properties");

            FileInputStream fis = new FileInputStream("src/test/resources/" + fileName);
            props.load(fis);
            System.out.println("✅ Config loaded: " + fileName);

        } catch (IOException e) {
            System.out.println("❌ Gagal load konfigurasi: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
