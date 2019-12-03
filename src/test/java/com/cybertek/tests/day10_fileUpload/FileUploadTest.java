package com.cybertek.tests.day10_fileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FileUploadTest {
    WebDriver driver;
    @BeforeTest
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        //driver.quit();
    }
    @Test
    public void test1(){

       driver.get("http://practice.cybertekschool.com/upload");
       driver.findElement(By.name("file")).sendKeys("C:/Users/MURAT/Desktop/file.txt");
       driver.findElement(By.id("file-submit")).click();
       //verify that file is uploaded
        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals("file.txt","file.txt","verify the file name" );

    }
    @Test       // we make it dynamic in intellij folder system
    public void test2(){
    System.out.println(System.getProperty("user.dir"));

    String projectPath=System.getProperty("user.dir");
    String relativePath="src/test/resources/testfile.txt";

    String filePath = projectPath+"/"+relativePath;

        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.name("file")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        //verify that file is uploaded
        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals("file.txt","file.txt","verify the file name" );
    }
}
