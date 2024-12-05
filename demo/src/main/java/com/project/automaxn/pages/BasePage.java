package com.project.automaxn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    WebElement userDropdownMenu, logOutElement, navigationFilter, loggedInSchool;

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
        String schoolName = getElementByXPath("//a[@title=\"Change School\"]").getText();
        return schoolName;
    }

    public void logout() {
        userDropdownMenu = getElementByClass("next-navbar-avatar");
        click(userDropdownMenu);
        logOutElement = getElementByLinkText("Log Out");
        click(logOutElement);
    }
}
