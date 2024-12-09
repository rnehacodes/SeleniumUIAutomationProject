package com.project.automaxn.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    WebElement userDropdownMenu, logOutElement, navigationFilter, loggedInSchool;

    public String getTodaysDTS() {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");

        // Format the date
        return today.format(formatter);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getElementByClass(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }

    public WebElement getElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementByCSS(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement getElementByLinkText(String txt) {
        return driver.findElement(By.linkText(txt));
    }

    public void click(WebElement btn) {
        btn.click();
    }

    public void enterText(WebElement el, String text) {
        el.sendKeys(text);
    }

    public void pageNavigation(String pageName) {
        navigationFilter = getElementByXPath("//input[@placeholder=\"Filter Navigation\"]");
        enterText(navigationFilter, pageName);
        click((getElementByXPath("//a[@title=\"" + pageName + "\"]")));
    }

    public boolean verifyPageNavigation(String pageTitle) {
        return getElementByXPath("//h2[contains(text(), '" + pageTitle + "')]").isDisplayed();
    }

    public String getSchoolName() {        
        loggedInSchool = getElementByXPath("//a[@title='Change School']");
        return loggedInSchool.getText();
    }

    public String getCurrentStudentID() {
        return getElementByXPath("//span[@data-tcfc='STU.ID']").getText();
    }

    public void changeSchool(String schoolName) {
        loggedInSchool = getElementByXPath("//a[@title='Change School']");
        loggedInSchool.click();
        getElementByXPath("//a[contains(text(), '" + schoolName + "')]").click();
    }

    public String addNewStudentInSchool(String schoolName) {
        if (getSchoolName().contains("District")) {
            changeSchool(schoolName);
        }
        pageNavigation("Demographics");

        Demographics demographics = new Demographics(driver);        

        //import addStudent function from Demographics page
        return demographics.addStudent();
    }

    public WebElement getinputFieldByFieldCode(String fieldCode) {
        return driver.findElement(By.xpath("//td[@data-tcfc='" + fieldCode + "']/input"));
    }

    public void logout() {
        userDropdownMenu = getElementByClass("next-navbar-avatar");
        click(userDropdownMenu);
        logOutElement = getElementByLinkText("Log Out");
        click(logOutElement);
    }
}
