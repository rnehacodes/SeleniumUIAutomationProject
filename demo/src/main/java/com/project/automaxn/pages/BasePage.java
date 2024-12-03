package com.project.automaxn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    
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

    public void clickBtn(WebElement btn) {
        btn.click();
    }

    public void enterText(WebElement el, String text) {
        el.sendKeys(text);
    }
}
