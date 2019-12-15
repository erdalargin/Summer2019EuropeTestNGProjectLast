package com.cybertek.tests.day12_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();

    }

    @Test
    public void StaleTest(){
        driver.get("http://google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium" + Keys.ENTER);

        WebElement results = driver.findElement(By.id("resultStats"));
        Assert.assertTrue(results.isDisplayed());

        //go to google second time
        driver.navigate().back();
        input = driver.findElement(By.name("q"));
        input.sendKeys("Java"+Keys.ENTER);

    }
}
