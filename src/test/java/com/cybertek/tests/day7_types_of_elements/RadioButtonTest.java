package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioBtnTest1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButtonBlue = driver.findElement(By.id("blue"));
        WebElement radioButtonRed = driver.findElement(By.id("red"));

        //how to check is radio button selected

        System.out.println("radioButtonBlue.isSelected() = " + radioButtonBlue.isSelected());
        System.out.println("radioButtonRed.isSelected() = " + radioButtonRed.isSelected());

        //how to select blue
        //we use the click

        radioButtonRed.click();

    //TASK verify blue is  not selected and red is selected
        Assert.assertFalse(radioButtonBlue.isSelected(), "Verify that blue is not checked");
        Assert.assertTrue(radioButtonRed.isSelected(),"Verify that red is checked");


        //TASK verify blue is selected and red is not selected
        Assert.assertTrue(radioButtonBlue.isSelected(), "Verify that blue is checked");
        Assert.assertFalse(radioButtonRed.isSelected(),"Verify that red is not checked");

        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);


        driver.quit();




    }

}
