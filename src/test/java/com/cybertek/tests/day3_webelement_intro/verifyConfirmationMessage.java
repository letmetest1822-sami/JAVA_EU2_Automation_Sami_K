package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */

        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //find yhe place to write the email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "test@gmail.com";
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //first way getText() --> it will work %99 and it will return a string
        //second option getAttribute("value")

        String actualEmail = emailInputBox.getAttribute("value");

        if(actualEmail.equalsIgnoreCase(expectedEmail)) {
            System.out.println(" PASS ");

        }else{
            System.out.println("Fail ");
            System.out.println("actualEmail   = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        //findElement-->method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //click()--> clicking web element
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = actualConfirmationMessage.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println(" PASS ");
        }else{
            System.out.println(" FAIL " );
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();

    }
}
