package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class getRow {
    @Test
    public void getRow() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

        //print the first row information
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(secondRow.getText());

        //get all rows dynamicly
        //find number of rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        //itearte one by one
        for(int i =1;      i<=allRows.size();     i++){
            String strXpath = "//table[@id='table1']/tbody/tr[" + i +"]";

            WebElement row = driver.findElement(By.xpath(strXpath));
            System.out.println("Row " + i + " : " + row.getText());

        }

        Thread.sleep(3000);
        driver.quit();
    }
}
