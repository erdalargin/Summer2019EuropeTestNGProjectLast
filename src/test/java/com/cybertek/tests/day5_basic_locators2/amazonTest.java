package com.cybertek.tests.day5_basic_locators2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();

        String resultMessage = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();

        System.out.println(resultMessage);
        String [] str1 = resultMessage.split("of ");
        str1 = str1[1].split(" results");
        String actualresult01 = str1[0];
        int actualresult = Integer.parseInt(actualresult01);
        int expectedresult = 869;

        if(expectedresult==actualresult){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual result "+actualresult);
            System.out.println("expected result "+expectedresult);
        }



        driver.quit();

    }
}
