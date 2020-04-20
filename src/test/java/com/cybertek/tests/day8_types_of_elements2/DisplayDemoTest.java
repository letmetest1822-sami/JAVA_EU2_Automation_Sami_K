package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.id("username"));

        //verify that username not displayed on the screen
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        //click start button
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        // after opening the page wait 3 seconds for next order
        Thread.sleep(7000);

        //verify username displayed on the screen

        Assert.assertTrue(userNameInput.isDisplayed(),"Verify that username displayed on the screen");



        driver.quit();

    }




}
