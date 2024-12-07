package com.project.automaxn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demographics extends BasePage{

    public Demographics(WebDriver driver) {
        super(driver);
    }

    //defining page elements
    WebElement addBtn, studentNotFoundBtn;

    public void addStudent() {
        addBtn = getElementByXPath("//input[@value='Add']");
        click(addBtn);
        studentNotFoundBtn = getElementByXPath("//input[@value=\"Add\"]");
        click(studentNotFoundBtn);
    }
}
