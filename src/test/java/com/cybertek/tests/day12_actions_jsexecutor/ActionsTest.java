package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(2000);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.dragAndDrop(sourceElement, targetElement).perform();


    }

    @Test
    public void DragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(1000);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        Thread.sleep(1000);
        //drag and drop witout drag and drop method

        //move mouse to the source

        actions.moveToElement(sourceElement).clickAndHold().moveToElement(targetElement).pause(1000).release().build().perform();

        System.out.println("Result   :  " + targetElement.getText());
        Assert.assertEquals("You did great!",targetElement.getText(), "Verify _targetElement.getText()_ message is displayed" );


    }
}
