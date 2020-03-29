package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Verify URL changed
         * open browser
         * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
         * enter any email
         * click on Retrieve password
         * verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email

        WebElement emailInputBox =  driver.findElement(By.name("email"));

        emailInputBox.sendKeys("test@gmail.com");

        //findElement-->method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //click()--> clicking web element
        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equalsIgnoreCase(expectedUrl)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("Actual   : " + actualUrl);
            System.out.println("Expected : " + expectedUrl);
        }

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();

    }
}
