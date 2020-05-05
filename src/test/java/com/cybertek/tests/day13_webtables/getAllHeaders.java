package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class getAllHeaders {

        @Test
        public void getAllHeaders() throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/tables");

            //how many columns we have
            List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
            System.out.println("Number of Columns = " + headers.size());


            //print each column name one by by
            int i = 1;

            for (WebElement header : headers) {
                System.out.println("header " + i + "  : " + header.getText());
                i++;
            }

            Thread.sleep(3000);
            driver.quit();
        }
}
