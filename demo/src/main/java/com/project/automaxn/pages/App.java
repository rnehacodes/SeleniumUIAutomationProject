package com.project.automaxn.pages;

import com.project.automaxn.resources.config.ConfigReader;
import com.project.automaxn.utils.JsonConfigReader;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // WebDriver driver = new ChromeDriver();
        // driver = DriverManager.getDriver();
        String url = ConfigReader.getProperty("baseUrl");
        System.out.println("URL: " + url);

        String username = JsonConfigReader.getCredential("admin", "username");
        System.out.println("Username: " + username);
        // String password = JsonConfigReader.getCredential(ConfigReader.getProperty("role"), "password");
    }
}