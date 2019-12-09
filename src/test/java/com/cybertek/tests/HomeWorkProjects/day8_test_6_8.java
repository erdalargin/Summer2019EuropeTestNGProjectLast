package com.cybertek.tests.HomeWorkProjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day8_test_6_8 {
    WebDriver driver;
    @BeforeMethod
    public void chromeSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }
    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");
        WebElement email = driver.findElement(By.id("email"));
        String emailAdd= email.getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement list = driver.findElement(By.xpath("//*[text()='Sign Up For Mailing List']"));
        list.click();

        WebElement name=driver.findElement(By.name("full_name"));
        name.sendKeys("john conner");
        WebElement Email=driver.findElement(By.cssSelector("[type='email']"));
        Email.sendKeys(emailAdd);
        WebElement submit=driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        WebElement msg2=driver.findElement(By.cssSelector(".subheader"));
        Assert.assertEquals(msg2.getText(),"Thank you for signing up. Click the button below to return to the home page.","Verify that confirmation message displayed as expected");
        driver.navigate().to("https://www.tempmailaddress.com/");

        WebElement message2=driver.findElement(By.xpath("//*[text()='do-not-reply@practice.cybertekschool.com']"));
        message2.getText();
        //Assert.assertEquals(message2.getText(),"do-not-reply@practice.cybertekschool.com","Verify that you got the email"););
        System.out.println("message2 = " + message2);
        //stucked here not able to locate the email come from cybertekschool

    }
    @Test
    public void test7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/upload");
        String filepath="C:/Users/MURAT/IdeaProjects/Summer2019EuropeTestNGProject/src/test/resources/testfile.txt";
        driver.findElement(By.name("file")).sendKeys(filepath);
        driver.findElement(By.id("file-submit")).click();
        String actual= driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual,"testfile.txt","verify that file name is correct");
    }
    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=/autocomplete]")).click();
        WebElement country=driver.findElement(By.id("myCountry"));
        country.sendKeys("United States of America");
        WebElement sub=driver.findElement(By.cssSelector("[onclick='log()']"));
        sub.click();
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You selected: United States of America","Verify that you got correctr message");

    }





}
