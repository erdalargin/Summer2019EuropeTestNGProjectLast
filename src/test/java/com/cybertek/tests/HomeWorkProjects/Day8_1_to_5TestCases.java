package com.cybertek.tests.HomeWorkProjects;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day8_1_to_5TestCases {
    WebDriver driver ;
    @BeforeMethod
    public void chromeSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registration.click();
        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("wrong_dob");
        WebElement warning = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']"));
        String warningText = warning.getText();
        String expectedText="The date of birth is not valid";
        Assert.assertEquals(warningText,expectedText,"verify that wrong date of birth");
    }
    @Test
    public void test2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registration.click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));

        String s1=checkboxes.get(0).getAttribute("value");
        String s2=checkboxes.get(1).getAttribute("value");
        String s3=checkboxes.get(2).getAttribute("value");

        Assert.assertEquals(s1,"cplusplus","verify that cplusplus is there");
        Assert.assertEquals(s2,"java","Verify that Java is there");
        Assert.assertEquals(s3,"javascript","verify that javascript is there");

    }
    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registration.click();
        WebElement name = driver.findElement(By.name("firstname"));
        name.sendKeys("s");
        WebElement msg1=driver.findElement(By.xpath("//*[@data-bv-result='INVALID']"));
        String actualMsg = msg1.getText();
        String expected = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMsg,expected,"verify that warning message displayed correctly");

    }
    @Test
    public void test4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registration.click();
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("s");
        WebElement msg2 = driver.findElement(By.xpath("//*[@data-bv-validator='stringLength'and @data-bv-for='lastname']"));
        String actual = msg2.getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual, expected, "Verify that correct warning message is displayed");
    }
    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registration.click();
        WebElement fname = driver.findElement(By.name("firstname"));
        fname.sendKeys("john");
        WebElement lname = driver.findElement(By.name("lastname"));
        lname.sendKeys("conner");
        WebElement usname=driver.findElement(By.name("username"));
        usname.sendKeys("jconner");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("jconer@yahoo.com");

        WebElement password =driver.findElement(By.name("password"));
        password.sendKeys("Sup3rH@rdPassw0rd");

        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("713-693-8798");

        driver.findElement(By.xpath("//*[@value='male']")).click();

        driver.findElement(By.name("birthday")).sendKeys("02/16/2001");

        WebElement depart = driver.findElement(By.xpath("//select[@name='department']"));
        Select dep = new Select(depart);
        dep.selectByValue("AO");
        System.out.println("department = " + dep.getFirstSelectedOption());
        WebElement jobTitle = driver.findElement(By.name("job_title"));
        Select jtitle = new Select(jobTitle);
        jtitle.selectByVisibleText("Manager");
        //webelement creation no needed sth
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        WebElement confirmation = driver.findElement(By.xpath("//div/p"));
        String s1=confirmation.getText();
        String s2 = "You've successfully completed registration!";
        Assert.assertEquals(s1,s2,"verify that you got correct submission answer");

    }


}
