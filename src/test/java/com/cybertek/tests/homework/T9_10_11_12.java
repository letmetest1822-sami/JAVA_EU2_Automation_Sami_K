package com.cybertek.tests.Assignment.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T9_10_11_12 {


    /*
Optional: If you want to to be a real selenium hero,
use @DataProvider for for tests cases from 9 through 12.
Please use following documentation: https://testng.org/doc/documentationmain.html#parameters-dataproviders
*/

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test //testCase_09

       public void testCase09(){
        /*
Test case #9
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
         */


//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

//      Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();

//      Step 3. Then click on “200”.
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();

//      Step 4. Verify that following message is displayed: “This page returned a 200 status code”
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        String expectedResult = "This page returned a 200 status code";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test // Test Case 10
    public void task_10(){
        /*
        Test case #10
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
         */

//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

//      Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();

//      Step 3. Then click on “301”.
        driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();

//      Step 4. Verify that following message is displayed: “This page returned a 301 status code”
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        String expectedResult = "This page returned a 301 status code";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test // Test Case 11
    public void task_11(){
        /*
        Test case #11
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”
         */

//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

//      Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();

//      Step 3. Then click on “404”.
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();

//      Step 4. Verify that following message is displayed: “This page returned a 404 status code”
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        String expectedResult = "This page returned a 404 status code";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test // Test Case 12
    public void task_12(){
         /*
Test case #12
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a 500 status code”
     */

//      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

//      Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();

//      Step 4. Then click on “500”.
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();

//      Step 5. Verify that following message is displayed: “This page returned a 500 status code”
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        String expectedResult = "This page returned a 500 status code";
        Assert.assertTrue(actualResult.contains(expectedResult));


    }



}
