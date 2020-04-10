package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC02_VerifyTitleSearch {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Test case 2
            * go to amazon
            * Go to ebay
            * enter search term
            * click on search button
            * verify title contains search term
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("lenovo");

        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());



/*
        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        //close all the current tabs
        driver.quit();
*/



    }
}
