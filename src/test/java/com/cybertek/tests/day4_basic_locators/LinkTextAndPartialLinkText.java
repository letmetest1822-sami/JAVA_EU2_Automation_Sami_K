package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();

        // after opening the page wait 3 seconds for next order
        Thread.sleep(3000);

        WebElement homelink = driver.findElement(By.className("nav-link"));
        homelink.click();
        // after opening the page wait 3 seconds for next order

        Thread.sleep(3000);

        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));

        link4.click();


        // after opening the page wait 3 seconds for next order
        Thread.sleep(3000);

        ///close all the current tabs
        driver.quit();


    }
}
