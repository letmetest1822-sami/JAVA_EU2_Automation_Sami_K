package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

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
    public  void printTable(){

        //chrome ready
        //page ready
        //wait ready
        //coming from before method

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));

    }

    @Test
    public void getAllHeaders(){

        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of Columns = " + headers.size());


        //print each column name one by by
            int i = 1;

            for (WebElement header : headers) {
            System.out.println("header " + i + "  : " + header.getText());
            i++;
            }

        }
    @Test
    public void printTableSize(){

        //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of Columns = " + headers.size());

        //number of rows with headers
        List<WebElement> allROwsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of Rows With Header = " + allROwsWithHeader.size());



       // number of rows witout headers
        List<WebElement> allROwsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of Rows Without Header = " + allROwsWithoutHeader.size());
    }

    @Test
    public void getRow(){
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
    }

    @Test
    public void getAllCellsinOneRow(){

        List<WebElement> allCellsinOnerow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        for (WebElement cell : allCellsinOnerow) {
            System.out.println(cell.getText());

        }

        System.out.println(driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]")));
    }

    @Test
    public void getAsingleCell(){
        WebElement sigleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(sigleCell.getText());
    }

    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(singleCell.getText());


    }

    @Test
    public void PrintAllCellsByIndex(){

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
