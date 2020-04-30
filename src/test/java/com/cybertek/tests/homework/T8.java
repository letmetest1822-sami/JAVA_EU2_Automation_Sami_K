package com.cybertek.tests.Assignment.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T8 {

    @Test  //testCase_08
    public void test08() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
    /*
    Test case #8
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed:
“You selected: United States of America”
*/
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();

        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();


        //Step 4. Verify that following message is displayed:
        //“You selected: United States of America”
        String expectedMesssage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedMesssage, actualMessage);

        Thread.sleep(3000);
        driver.quit();

    }
}
