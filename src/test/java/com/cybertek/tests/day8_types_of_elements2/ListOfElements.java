package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement > buttons = driver.findElements(By.tagName("button"));


        System.out.println("buttons.size() = " + buttons.size());

        // verify that we have 6 buttons
        Assert.assertEquals(buttons.size(), 6);

        for (WebElement button : buttons){

            System.out.println(button.getText() + " button.isDisplayed() = " + button.isDisplayed());
        }

        //click only second button from the list
        buttons.get(1).click();

        driver.quit();


    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement > buttons = driver.findElements(By.tagName("buttonasdadsfasdf"));

        System.out.println("buttons.size() = " + buttons.size());


    }




}
