package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locate it
        WebElement RadioButtonGreen = driver.findElement(By.id("green"));

        //how to check a web element is enabled or not
        System.out.println("Is RadioButtonGreen enabled  :  " + RadioButtonGreen.isEnabled());
        Assert.assertFalse(RadioButtonGreen.isEnabled(), "Verify Green is NOT enabled");

        RadioButtonGreen.click();
    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("Mike");

    }
}
