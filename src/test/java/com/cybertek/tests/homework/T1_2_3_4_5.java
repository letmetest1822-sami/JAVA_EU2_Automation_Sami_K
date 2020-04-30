package com.cybertek.tests.Assignment.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class T1_2_3_4_5 {

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

    @Test //testCase_01
    /*
    Test case #1
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input
box.
Step 4. Verify that warning message is displayed:
“The date of birth is not valid”
     */


    public void testCase_01() throws InterruptedException {
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        Thread.sleep(2000);
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Enter “wrong_dob” into date of birth inputbox.
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed: “The date of birth is not valid”
        String expectedMessage = "The date of birth is not valid";
        String actualMessage = driver.findElement(By.xpath("(//small[@data-bv-for='birthday'])[2]")).getText();

        Assert.assertEquals(actualMessage, expectedMessage, "Verify the message The date of birth is not valid");
    }

    @Test//Test case2
    public void testCase02() {
         /*
    Test case #2
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        System.out.println("Number of checkBoxes = " + checkBoxes.size());
        Assert.assertEquals(checkBoxes.size(), 3);

        for (int i = 0; i < 3; i++) {
            System.out.println("Is checkbox " + checkBoxes.get(i).getText() + " displayed ? : " + checkBoxes.get(i).isDisplayed());
        }


    }

    @Test//Test case3
    public void testCase03() {
/*
Test case #3
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into firstname input box.
Step 4. Verify that warning message is displayed:
“first name must be more than 2 and less than 64characters long”
 */
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Enter only one alphabetic character into firstname input box.
        driver.findElement(By.name("firstname")).sendKeys("s");

        String expectedMessageFirstname = "first name must be more than 2 and less than 64 characters long";
        String actualMessageFirstname = driver.findElement(By.xpath("(//small[@class='help-block'])[2]")).getText();
        Assert.assertEquals(actualMessageFirstname, expectedMessageFirstname, "Verify that message is -first name must be more than 2 and less than 64 characters long-");

        //Step 4. Verify that warning message is displayed:
        //“first name must be more than 2 and less than 64 characters long”
        System.out.println("Is error mesage about firstname displayed? : " + driver.findElement(By.xpath("(//small[@class='help-block'])[2]")).isDisplayed());

    }

    @Test//Test case4
    public void testCase04() {
        /*
        Test case #4
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into lastname input box.
Step 4. Verify that warning message is displayed:
“The last name must be more than 2 and less than 64 characters long”
         */

        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Enter only one alphabetic character into lastname input box.
        driver.findElement(By.name("lastname")).sendKeys("k");
        //String expectedMessageLastname = "The last name must be more than 2 and less than 64 characters long";
        //String actualMessageLastname = driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        //Assert.assertEquals(expectedMessageLastname, actualMessageLastname);

        //Step 4. Verify that warning message is displayed:
        //“The last name must be more than 2 and less than 64 characters long”
        System.out.println("Is error mesage about Lastname displayed? : " + driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']")).isDisplayed());

    }

    @Test//Test case5
    public void testCase05() throws InterruptedException {
/*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed registration!”
Note: for using dropdown, please refer to the documentation:
https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/
Select.html or, please watch short video about dropdowns that is posted on canvas.
 */


        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Enter any valid first name.
        driver.findElement(By.name("firstname")).sendKeys("Mike");

        //Step 4. Enter any valid last name.
        driver.findElement(By.name("lastname")).sendKeys("Smith");

        //Step 5. Enter any valid user name.
        driver.findElement(By.name("username")).sendKeys("msmith");

        //Step 6. Enter any valid password.
        driver.findElement(By.name("password")).sendKeys("12345678");

        //Step 7. Enter any valid phone number.
        driver.findElement(By.name("phone")).sendKeys("571-123-1233");

        //Step 8. Select gender.
        driver.findElement(By.xpath("//input[@value='male']")).click();
        System.out.println("Is gender selected male ? : " + driver.findElement(By.xpath("//input[@value='male']")).isSelected());

        //Step 9. Enter any valid date of birth.
        driver.findElement(By.name("birthday")).sendKeys("11/11/1999");

        //Step 10. Select any department.
        //locate your dropdown just like any other webElement with unique locator
        WebElement dropdownDepartment = driver.findElement(By.xpath("//select[@name='department']"));

        //create Select object by passing that element as a constructor
        Select departmentDropdown = new Select(dropdownDepartment);

        //getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = departmentDropdown.getOptions();

        //Select Department of Engineering
        departmentDropdown.selectByIndex(1);


        //Step 11. Enter any job title.
        WebElement dropdownJobTitle = driver.findElement(By.name("job_title"));
        Select jobtitleDropdown = new Select((dropdownJobTitle));
        List<WebElement> optionsJobTitle = jobtitleDropdown.getOptions();
        jobtitleDropdown.selectByIndex(4);

        //Step 12. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox2")).click();

        //email
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");


        //Step 13. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();


        //Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//*[text()=\"You've successfully completed registration!\"]")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);


            //Note: for using dropdown, please refer to the documentation:
            //https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/
            //Select.html or, please watch short video about dropdowns that is posted on canvas.

        }

    }
