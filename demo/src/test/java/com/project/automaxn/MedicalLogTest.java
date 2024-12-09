package com.project.automaxn;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.automaxn.pages.MedicalLog;

public class MedicalLogTest extends BaseTest{

    @Test
    public void verifyAddingMedicalLogRecord() {
        //Navigate to Medical Log Page
        MedicalLog medicalLog = new MedicalLog(driver);    
        String pageName = "Medical Log";

        medicalLog.pageNavigation(pageName);

        //Verifying page Navigation
        Assert.assertTrue(medicalLog.verifyPageNavigation(pageName), pageName + "page navigation was NOT successfully.");

        String currentSchool = medicalLog.getSchoolName();
        if(currentSchool.contains("District")) {
            medicalLog.addNewStudentInSchool("994");
        }

    }
}
