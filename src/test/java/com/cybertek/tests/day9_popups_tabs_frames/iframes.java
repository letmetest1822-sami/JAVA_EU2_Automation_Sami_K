package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    //Will be used for future classes
    //Start here

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

    // Untill here

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");


        /*
        Thread.sleep(3000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");  // will not run
*/
        //how to switch to iframe by using name or id attribute

        //1.Switch USING BY NAME OR ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear content of iframe
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();
        //write a message in it
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");
        Thread.sleep(2000);
        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(2000);


        //2.Using INDEX
        driver.switchTo().frame(0);
        //clear content of iframe before sendkeys
        driver.findElement(By.id("tinymce")).clear();
        //write a message in it
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with INDEX");

        //second way to go to the first frame(main html)
        driver.switchTo().parentFrame();
        Thread.sleep(2000);

        //3.USING WEB ELEMENT
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith WITH WEB ELEMENT");

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 children left middle right
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to parent --frame top
        driver.switchTo().parentFrame();

        //switch to right frame
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //to switch main html we can use default content
        driver.switchTo().defaultContent();

        //switch to bottom
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
