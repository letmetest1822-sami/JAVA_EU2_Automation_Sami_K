package com.cybertek.tests.Assignment.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T6 {

    @Test //testCase_06
    public void test06() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        /*
        Test case #6
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed:
“Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
         */

        //Step 1. Go to “https://www.tempmailaddress.com/”
        driver.get("https://www.fakemail.net");

        //Step 2. Copy and save email as a string.
        WebElement email = driver.findElement(By.xpath("//span[@id='email']"));
        String emailAdress = email.getText();


        //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Mike");

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(emailAdress);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        Thread.sleep(2000);

        //Step 8. Verify that following message is displayed:
        // “Thank you for signing up. Click the button below to return to the home page.”
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Verify that message is : -Thank you for signing up. Click the button below to return to the home page.-");

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(5000);

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”

        String expectedMailTitle = "do-not-reply@practice.cybertekschool.com";
        String actualMailTitle = driver.findElement(By.xpath("(//td[contains(.,'do-not-reply@practice.cybertekschool.com')])[1]")).getText().trim();
/*
        System.out.println("exp: " + expectedMailTitle);
        System.out.println("act: " + actualMailTitle);

 */
        Assert.assertEquals(actualMailTitle, expectedMailTitle,"verify that mail title is do-not-reply@practice.cybertekschool.com");

        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//td[contains(.,'do-not-reply@practice.cybertekschool.com')]")).click();

        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        String expectedEmailSender = "do-not-reply@practice.cybertekschool.com";
        String actualEmailSender= driver.findElement(By.id("odesilatel")).getText().trim();
        Assert.assertEquals(actualEmailSender,expectedEmailSender,"verifying that email is sent by Cybertek");

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”

        String expectedMailMessage = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualMailMessage = driver.findElement(By.id("predmet")).getText();

        Assert.assertEquals(expectedMailMessage, actualMailMessage, "Verify subscribed succesfuly -Thanks for subscribing to practice.cybertekschool.com!-");


        Thread.sleep(3000);
        driver.quit();


    }
}
