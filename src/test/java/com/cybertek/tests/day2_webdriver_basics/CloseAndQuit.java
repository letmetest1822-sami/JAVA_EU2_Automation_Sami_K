package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        // after opening the page wait 3 seconds for next order
        Thread.sleep(3000);

        ///close the current tab
        driver.close();

        driver = new ChromeDriver();

        //open new tab
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();
    }
}
