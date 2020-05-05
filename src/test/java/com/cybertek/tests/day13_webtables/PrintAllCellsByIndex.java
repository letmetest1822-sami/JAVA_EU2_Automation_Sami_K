package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrintAllCellsByIndex {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void PrintAllCellsByIndex() throws InterruptedException {

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

//        "//table[@id='table1']/tbody/tr[1]/td[1]"
//        "//table[@id='table1']/tbody/tr[1]/td[2]"
//        "//table[@id='table1']/tbody/tr[4]/td[6]"
        //iterate through each row on the table
        for (int i = 1; i <=rowNumber ; i++) {
            System.out.println();
            //iterate through each cell for each row
            for (int j = 1; j <=colNumber ; j++) {
                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                //System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.print(cell.getText() + " | ");
            }
        }
    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }


}
