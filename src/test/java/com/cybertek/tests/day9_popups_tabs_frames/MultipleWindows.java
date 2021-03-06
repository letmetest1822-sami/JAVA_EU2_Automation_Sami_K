package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    //Will be used for future classes
    //Start here

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    // Untill here

    @Test
    public void switchWindowsTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");


        //get title
        System.out.println("Title before new window : " + driver.getTitle());

        //click click here link
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();

        //1.get title
        Thread.sleep(2000);
        System.out.println("Title after  new window : " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //2.we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles);

        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(2000);
        System.out.println("Title after  switching to new window : " + driver.getTitle());


    }

    @Test
    public void moreThan2Windows() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Title before new window : " + driver.getTitle());

        //click click here link
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();

        //1.get title
        Thread.sleep(2000);
        System.out.println("Title after  new window : " + driver.getTitle());

        //open new Tab


        Set<String> windowsHandles = driver.getWindowHandles();
        //loop through each window one by one
        for (String handle : windowsHandles) {

            driver.switchTo().window(handle);
            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("Title After Change = " + driver.getTitle());


        Thread.sleep(2000);


    }
}
