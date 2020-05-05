package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Chaining {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void DragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(1000);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        Thread.sleep(1000);
        //drag and drop witout drag and drop method

        //move mouse to the source

        actions.moveToElement(sourceElement).clickAndHold().moveToElement(targetElement).pause(1000).release().build().perform();

        System.out.println("Result   :  " + targetElement.getText());
        Assert.assertEquals("You did great!",targetElement.getText(), "Verify _targetElement.getText()_ message is displayed" );

        Thread.sleep(3000);
        driver.quit();

    }


}
