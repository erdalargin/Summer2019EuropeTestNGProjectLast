package com.cybertek.tests.day9_Popups_Tabs_Frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeTest
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void switchWindowTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        //click the clickhere link
        driver.findElement(By.linkText("Click Here")).click();

    }

    @Test
    public void morethen2Window(){
        String targetWindowTitle = "New Window";
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles= driver.getWindowHandles();       //all windows are kept here;
        //will check one by one
        for (String handle:windowHandles) {
            driver.switchTo().window(handle);
            //will compare
            if(driver.getTitle().equals(targetWindowTitle)){
                break;
        }

        }
        System.out.println("After loop Title = " + driver.getTitle());


    }
}
