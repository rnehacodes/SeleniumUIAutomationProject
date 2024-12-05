package com.project.automaxn;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.project.automaxn.pages.HomePage;
import com.project.automaxn.pages.LoginPage;
import com.project.automaxn.resources.config.ConfigReader;
import com.project.automaxn.utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        String baseUrl = ConfigReader.getProperty("baseUrl");
        // System.out.println(baseUrl);
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new IllegalArgumentException("Base URL is not set in the configuration file.");
        }
        driver.get(ConfigReader.getProperty("baseUrl"));
        Login();
    }

    public void Login() {
        loginPage = new LoginPage(driver);

        loginPage.login();

        homePage = new HomePage(driver);

        // Assert the login was successful
        Assert.assertTrue(homePage.isUserLoggedIn(), "User could NOT log in successfully.");
    }

    public void Logout() {
        homePage.logout();

        loginPage = new LoginPage(driver);

        // Assert that logout was successful
        Assert.assertTrue(loginPage.isUserLoggedOut(), "User could NOT log out successfully.");
    }

    // @AfterMethod
    public void tearDown() {
        Logout();
        DriverManager.quitDriver();
    }
}