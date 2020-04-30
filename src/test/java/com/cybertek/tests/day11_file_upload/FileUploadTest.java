package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    //Will be used for future methods and Tests
    //Start here
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    // Untill here

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        //sendkeys button the pathname
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\letme\\Desktop\\text.txt");

        //click on upload button
        driver.findElement(By.id("file-submit")).click();

        //verify your filename
        System.out.println("Name of the uploaded file : " + driver.findElement(By.id("uploaded-files")).getText());
        String expectedFileName = "text.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);

        //verify message that you uploaded the file
        System.out.println("Message                   : " + driver.findElement(By.xpath("//h3")).getText());
        String expectedMessage = "File Uploaded!";
        String actualMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println(driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        //sendkeys button the pathname

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";
        String filePath = projectPath + "\\" + relativePath;

        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        //click on upload button
        driver.findElement(By.id("file-submit")).click();

        //verify your filename
        System.out.println("Name of the uploaded file : " + driver.findElement(By.id("uploaded-files")).getText());
        String expectedFileName = "testfile.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);

        //verify message that you uploaded the file
        System.out.println("Message                   : " + driver.findElement(By.xpath("//h3")).getText());
        String expectedMessage = "File Uploaded!";
        String actualMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println(driver.findElement(By.xpath("//p")).getText());







    }


}
