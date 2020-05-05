package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverOver {



    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions ---> class that contains all the user interactions
        //how to create actions object / passing -driver- as a constructor
        Thread.sleep(3000);
        Actions actions = new Actions(driver);  // need import class

        //perform()  --> perform the actişon, complete the action
        //moveToElemetn --> move your maouse cursor to the WebElement
        actions.moveToElement(img1).perform();

        //Ver,fy link is displayed
        WebElement link1 = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link1.isDisplayed(), "Verify that -View profile- link is displayed");
/*
        //hover over img 2
        WebElement img2 = driver.findElement(By.xpath("View profile"));
       actions.moveToElement(img2).perform();

       */

        Thread.sleep(3000);
        driver.quit();
    }
}
