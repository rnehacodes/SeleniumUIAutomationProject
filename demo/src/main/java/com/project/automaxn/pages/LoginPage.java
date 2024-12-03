package com.project.automaxn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.automaxn.resources.ConfigReader;
import com.project.automaxn.utils.JsonConfigReader;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //defining Web page elements
    WebElement usernameInpuElement = getElementById("Username_Aeries");
    WebElement passwordInpuElement = getElementById("Password_Aeries");
    WebElement yearDropdown = getElementByXPath("//span[@aria-labelledby=\"Year_Aeries_label\"]");
    WebElement loginBtn = getElementByXPath("//input[@value=\"Log In\"]");

    String username = JsonConfigReader.getCredential(ConfigReader.getProperty("role"), "username");
    String password = JsonConfigReader.getCredential(ConfigReader.getProperty("role"), "password");

    public void enterUsername() {
        enterText(usernameInpuElement, username);
    }

    public void enterPassword() {
        enterText(passwordInpuElement, password);
    }

    public void enterLoginCredentials() {
        enterUsername();
        enterPassword();
    }
}
