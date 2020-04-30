package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    //Will be used for future classes
    //Start here

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    // Untill here


    @Test
    public void test(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        // //*[.='Yes']
        // //*[text()='Yes']

        //locate and click Destroy the World button(lazy way)
        driver.findElement(By.xpath("button[.='Destroy the World']")).click();

        //Locate and click No button
        driver.findElement(By.xpath("//button[.='No']")).click();


    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //1.locate click the Click for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        //click OK button on the alert
        alert.accept();
        Thread.sleep(2000);

        //2.locate click the Click for JS confirm button
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);

       //click cancel button
        alert.dismiss();

        //3.locate click the Click for JS  prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);

        //write a message "Mike Smith" and send it
        alert.sendKeys("Mike Smith");
        Thread.sleep(2000);
        alert.accept();

    }
}