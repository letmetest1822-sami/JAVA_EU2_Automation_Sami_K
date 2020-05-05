package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ClickWithJS {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void clickWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        //clcking with JC Executor

        //create JS executor object

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //use executeScript
        // go to google
        //search JS click Selenium
        //goto proper page stackoverflow
        //choose an good answer with green tick certified
        //copy - arguments[0].click();- and paste to your code
        jse.executeScript("arguments[0].click();", dropdownLink);

        Thread.sleep(3000);
        driver.quit();

    }


}
