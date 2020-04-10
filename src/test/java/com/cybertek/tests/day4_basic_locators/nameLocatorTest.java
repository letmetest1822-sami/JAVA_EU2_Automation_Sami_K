package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));
        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("test@gm.com");

        WebElement sendButton = driver.findElement(By.name("wooden_spoon"));
        sendButton.click();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement actualMessageBox = driver.findElement(By.name("signup_message"));

        String actualMessage = actualMessageBox.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }




        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();

    }
}
