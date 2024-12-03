package com.project.automaxn.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;

public class JsonConfigReader {

    private static Map<String, Map<String, String>> credentials;

    // Static block to load the JSON file at runtime
    static {
        try (InputStream inputStream = JsonConfigReader.class.getClassLoader().getResourceAsStream("credentials.json")) {
            if (inputStream != null) {
                Gson gson = new Gson();
                credentials = gson.fromJson(new InputStreamReader(inputStream), Map.class);
            } else {
                throw new RuntimeException("Could not find credentials.json in resources folder");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load credentials.json", e);
        }
    }

    // Method to retrieve credentials based on role (e.g., admin, teacher) and type (e.g., username, password)
    public static String getCredential(String role, String type) {
        return credentials.get(role).get(type);
    }
}
