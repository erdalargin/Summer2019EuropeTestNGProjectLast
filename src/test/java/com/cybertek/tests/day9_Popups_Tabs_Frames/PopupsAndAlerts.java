package com.cybertek.tests.day9_Popups_Tabs_Frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
    public void Test1() {   //html pop ups. can be clicked
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //Locating and clicking the destroy button
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
    }
    @Test
    public void Test2() throws InterruptedException {   //Java script pop ups, can not be clicked or inspect
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //under same family no need () for all poage
        driver.findElement(By.xpath("//button[1]")).click();
        //When we have pop ups; Alert !
        Alert alert = driver.switchTo().alert();    // we tell driver to switch the alert obj.- yes
        Thread.sleep(4000);
        //we have 4 diferent meth.s to edal wioth alert pop ups  accep dismiss send text
        alert.accept();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(4000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Mike Smith");
        alert.accept();
        Thread.sleep(5000);







    }
}
