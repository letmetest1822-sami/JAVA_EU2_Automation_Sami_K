package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement button2 = driver.findElement(By.xpath("//button[.='Button 1']"));
        button2.click();

        WebElement button3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        button3.click();

        WebElement button4 = driver.findElement(By.xpath("//button[contains(text(),'')]"));
        button4.click();

        WebElement button5 = driver.findElement(By.xpath("//button[ends-with(@id,'')]"));
        button5.click();

        WebElement button6 = driver.findElement(By.xpath("//button[contains(@id,'_button')][1]")); // there are two, choose [1]
        button6.click();


        WebElement button71 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //find button element which has onclick attrbite and its value is button1()
        button71.click();

        WebElement button72 = driver.findElement(By.xpath("//*[@onclick='button1()']"));
        //find any element which has onclick attribute and its value button1()
        button72.click();

        WebElement button73 = driver.findElement(By.xpath("//button[@*='button1()']"));
        //find button element which has any attribute value is button1()
        button73.click();

        WebElement button74 = driver.findElement(By.xpath("//*[@*='button1()']"));
        //find any element which has any attribute value is button1()
        button74.click();

        WebElement button9 = driver.findElement(By.xpath("//div[@id='content']/div[1]/p"));
        button9.click();


        // after opening the page wait 3 seconds for next order
        Thread.sleep(5000);

        ///close all the current tabs
        driver.quit();






        WebElement button8 = driver.findElement(By.xpath("//div[@id='content']/div[1]/p"));
        button8.click();







    }
}
