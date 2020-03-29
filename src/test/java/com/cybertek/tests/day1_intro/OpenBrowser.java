package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        //we have to enter this line everytime we want to open chrome
        //hey webdriver manager, can you make chrome ready for me for automation
        WebDriverManager.chromedriver().setup(); // bonny garcia

        //Web Driver represent the browser
        //We are creating driver for chrome browser
        //new ChromeDriver() --> this part will open chrome browser

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

       // WebDriverManager.firefoxDriver().setup();
       // WebDriver driver = new firefoxDriver();
       // driver.get("https://www.amazon.com");
    }
}