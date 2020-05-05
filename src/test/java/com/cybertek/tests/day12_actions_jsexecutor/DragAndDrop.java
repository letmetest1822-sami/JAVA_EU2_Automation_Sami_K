package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test

    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();


        Actions actions = new Actions(driver);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(2000);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.dragAndDrop(sourceElement, targetElement).perform();


        Thread.sleep(3000);
        driver.quit();
    }
}
