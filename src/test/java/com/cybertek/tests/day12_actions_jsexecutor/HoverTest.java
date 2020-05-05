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

import java.util.List;

public class HoverTest {

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

    /*
    * hover over each image in the web site
    * verify each name : user text is displayed
     */

    @Test
    public void test0() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.='name:user1']"));

        Assert.assertTrue(text1.isDisplayed(),"Verify user1 is displayed");


    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        for (int i = 1; i <=3; i++) {

            //creating dynamic xpath for images
            String imgXpath = "(//img)[" + i + "]";
            System.out.println(imgXpath);
            WebElement img = driver.findElement(By.xpath(imgXpath));

            Actions actions = new Actions(driver);

            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user" + i + "']";
            System.out.println(textXpath);
            WebElement text = driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(text.isDisplayed(), "Verify user" + i + " is displayed");

        }
    }



    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> users = driver.findElements(By.xpath("//img"));

        Thread.sleep(3000);
        Actions actions = new Actions(driver);

        String message;
        for (int i = 1; i <=users.size() ; i++) {
            actions.moveToElement(users.get(i)).perform();
            //message = users.get(i).getText();
           // System.out.println(message);

            String textXpath = "//h5[.='name: user" + i + "']";
            System.out.println(textXpath);
            WebElement text = driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(text.isDisplayed(), "Verify user" + i + " is displayed");
        }

    }


}
