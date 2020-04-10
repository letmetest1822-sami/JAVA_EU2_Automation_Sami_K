package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_eBaySearch {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Test case 1
            * Go to ebay
            * enter search term
            * click on search button
            * print number of results
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Asus");

        driver.findElement(By.id("gh-btn")).click();

        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        //close all the current tabs
        driver.quit();



    }
}
