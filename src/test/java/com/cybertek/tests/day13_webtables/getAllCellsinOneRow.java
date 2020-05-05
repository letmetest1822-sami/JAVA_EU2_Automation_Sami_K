package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class getAllCellsinOneRow {

    @Test
    public void getAllCellsinOneRow() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> allCellsinOnerow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        for (WebElement cell : allCellsinOnerow) {
            System.out.println(cell.getText());

        }

        System.out.println(driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]")));

        Thread.sleep(3000);
        driver.quit();
    }

}