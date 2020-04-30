package com.cybertek.tests.Assignment.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7 {

    @Test //testCase_07
    public void test07() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
/*
Test case #7
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from yourcomputer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
Run this method against “Choose File” button.
 */


        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “File Upload".
        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        //Step 3. Upload any file with .txt extension from yourcomputer.
        String Filepath = "src\\test\\resources\\text.txt";
        String projPath = System.getProperty("user.dir");
        System.out.println("Project path : " + projPath + "\\" + Filepath) ;
        String truePath = projPath + "\\" + Filepath ;
        driver.findElement(By.id("file-upload")).sendKeys(truePath);

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        String expectedMEssage = "File Uploaded!";
        String actualMessage = driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText();

        Assert.assertEquals(expectedMEssage, actualMessage);


        //Step 6. Verify that uploaded file name is displayed.
        String expectedFileName = "text.txt";
        String actuaLfileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(expectedFileName, actuaLfileName, "Verify file name is test.txt");

        //Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
        //Run this method against “Choose File” button.

        Thread.sleep(3000);
        driver.quit();

    }
}
