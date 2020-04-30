package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExapmle {
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

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click start button
        driver.findElement(By.tagName("button")).click();

        //locate username inputbox
        WebElement usernameInput =  driver.findElement(By.id("username"));

        //how to wait explicitly?
        //Crate explicit wait object

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //calling until method from wait object

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("Mike Smith");
    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //finding inputbox
        WebElement inputbox = driver.findElement(By.xpath("(//input)[2]"));

        //wait until element is clickable
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(inputbox));

        inputbox.sendKeys("MikeSmith");


    }
}
