package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * go to amazon.com
         * search for selenium
         * click search button
         * print 1-48 of 304 results for "selenium"
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");


        WebElement searchInputBox = driver.findElement(By.id("twotabsearchtextbox"));
                                                    //(By.xpath("input[@id='twotabsearchtextbox']")
        searchInputBox.sendKeys("selenium");


       // WebElement submitClick = driver.findElement(By.xpath("//input[@class='nav-input']"));

      //  submitClick.click();

        //WebElement result = driver.findElement(By.xpath("//span[@dir='auto']"));
        //WebElement result = driver.findElement(By.xpath("//span[contains(text(),'result for']"));
        //System.out.println("result = " + result.getText() + " " + submitClick);

        //finding search button and clicking directly
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("result.getText() = " + result.getText());

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();


    }
}
