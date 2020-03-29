package com.cybertek.tests.day3_webelement_intro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class verifyUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * click on Retrieve password
         * verify that url did not change
         */
        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // use get current url and save it to verify if it is changed or not
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        //WebElement -->Interface that represent elements on the webpage
        //findElement-->method used to find element on a webpage

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //click()--> clicking web element
        retrievePasswordButton.click();

        //verify that url did not change

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equalsIgnoreCase(expectedUrl)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();

    }
}