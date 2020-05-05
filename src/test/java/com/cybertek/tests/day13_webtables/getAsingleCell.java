package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class getAsingleCell {

    @Test
    public void getAsingleCell() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

        WebElement sigleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(sigleCell.getText());

        Thread.sleep(3000);
        driver.quit();
    }

}
