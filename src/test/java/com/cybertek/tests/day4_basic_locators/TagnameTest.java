package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagnameTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement multipleButton = driver.findElement(By.tagName("h3"));
        System.out.println(multipleButton.getText());
        driver.quit();
    }
}
