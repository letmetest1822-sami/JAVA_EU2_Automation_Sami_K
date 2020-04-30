package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    //Will be used for future methods and Tests
    //Start here
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//must be before findElement command
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    // Untill here

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //Thread.sleep(10000); //it may not be enough or too long
        //We need to wait just enough to see our web element

        //wait up to 20 s and fail if it doesnot appear, but if it appears earlier go on and RETURN .
        //must be before findElement command
        //It can be set in the Before Matehod part
        //It will be valid for all tests
        //Not VALID FOR INVISIBLE elements
        //Element must be a part of HTML
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String message = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(message);
    }
}
