package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PrintCellByCalling2ParameterMethod {

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
    public void PrintAsingleCellByMethod() throws InterruptedException {

        Random rn = new Random();
        int columnNum = rn.nextInt((6)+1); //Create a column number randomly between 1-6
        int rowNum = rn.nextInt((4)+1); //Create a row number randomly between 1-4
/*
        int columnNum = 3;   //you can use variable to indicate the column no.
        int rowNum = 2;     //you can use variable to indicate the row no.
*/
        System.out.println("Automation will display the cell in COLUMN : " + columnNum+ " ROW : " + rowNum);

        String CellData = callAcell(columnNum,rowNum).getText();
        //this part could be directly in soutv without declaring CellData variable : Lazy way

        System.out.println("The  cell  contains data  : "  + CellData);
    }

    //create a method  having two parameters representing the column and row numbers to call a single cell
    private WebElement callAcell(int i, int j){
        //define the xPath of a cell in a dynamic way
        String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

        //define a WebElement representing the cell in given column and row
        WebElement singleCell = driver.findElement(By.xpath(cellXpath));

        //return the WebElement representing the cell in given column and row
        return singleCell;
    }
}
