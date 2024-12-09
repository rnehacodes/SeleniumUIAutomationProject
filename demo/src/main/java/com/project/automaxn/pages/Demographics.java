package com.project.automaxn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Demographics extends BasePage{

    public Demographics(WebDriver driver) {
        super(driver);
    }

    //defining page elements
    WebElement addBtn, studentNotFoundBtn, saveBtn;

    public String addStudent() {
        //Click Add button
        addBtn = getElementByXPath("//input[@value='Add']");
        click(addBtn);

        //Click Student Not Found button
        studentNotFoundBtn = getElementByXPath("//input[@value='Student Not Found']");
        click(studentNotFoundBtn);

        //Click No on "Would you like to search for a sibling?" modal
        click(getElementByXPath("//input[@value='No']"));

        try {
            Thread.sleep(1000); // Pause for 1 second
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted!");
            e.printStackTrace();
        }

        //Fill important fields
        String firstName = "test" + getTodaysDTS();
        enterText(getinputFieldByFieldCode("STU.LN"), firstName);
        enterText(getinputFieldByFieldCode("STU.FN"), "demo");
        enterText(getElementByXPath("//td[@data-tcfc='STU.GN']/table//div/input"), "N");
        // enterText(getFieldByFieldCode("STU.GR"), "9");
        enterText((WebElement) new Actions(driver).moveToElement(getElementByXPath("//td[@data-tcfc='STU.CL']//div/input")), "00");

        enterText((getinputFieldByFieldCode("STU.CL")), "00");

        //Click on Save Button
        saveBtn = getElementByXPath("//div[@id='footer-btns']/input[@value='Save']");
        click(saveBtn);

        return getCurrentStudentID();
    }
}
