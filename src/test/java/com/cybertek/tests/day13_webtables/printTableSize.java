package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class printTableSize {

    @Test
    public void printTableSize() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of Columns = " + headers.size());

        //number of rows with headers
        List<WebElement> allROwsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of Rows With Header = " + allROwsWithHeader.size());



        // number of rows witout headers
        List<WebElement> allROwsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of Rows Without Header = " + allROwsWithoutHeader.size());

        Thread.sleep(3000);
        driver.quit();
    }
}
