package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitTest {
    WebDriver driver;
    @BeforeTest
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        //clicking the start button
        driver.findElement(By.tagName("button")).click();
        //find the username inputbox
        WebElement username = driver.findElement(By.id("username"));
        //HOW TO WAIT EXPLICITLY ?
        //Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);  //only driver and 10 .. we write not same as implicit one
        //call until method from wait object
        //waiting for the specific element to be visible (up to 10 sec)
        wait.until(ExpectedConditions.visibilityOf(username));
        //sending some username
        username.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        //click enable
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        //finding input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        //Wait until inputbox is enabled or clickable
        //create an object to wait
        WebDriverWait wait = new WebDriverWait(driver,13);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        //type something in the inputbox
        inputBox.sendKeys("type anything");
    }

}
