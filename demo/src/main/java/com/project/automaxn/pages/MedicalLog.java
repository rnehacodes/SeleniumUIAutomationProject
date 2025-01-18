package com.project.automaxn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MedicalLog extends BasePage{

    public MedicalLog(WebDriver driver) {
        super(driver);
    }

    public void addMedicalLogRecord() {
        WebElement addNewRecordBtn = getElementByXPath("//input[contains(@value, 'Add New Record')]");
        addNewRecordBtn.click();
        enterText(getElementByXPath("//input[contains(@onchange, 'CD_DropDownGrid')]"), "01");
        enterText(getElementByXPath("//input[contains(@ID, 'ST_txtKendoTimePicker')]"), "9:30 AM");
        enterText(getElementByXPath("//input[contains(@ID, 'ET_txtKendoTimePicker')]"), "6:00 PM");
        enterText(getElementByXPath("//input[contains(@onchange, 'RE_DropDownGrid')]"), "RC");
        enterText(getElementByName("ctl00$MainContent$subMED$rptMedicalLog$ctl01$txtCO"), "This is a test comment");
        enterText(getElementByXPath("//input[contains(@onchange, 'BC_DropDownGrid')]"), "Health Technician");
        enterText(getElementByXPath("//input[contains(@onchange, 'IN_DropDownGrid')]"), "HCL");
    }
}
