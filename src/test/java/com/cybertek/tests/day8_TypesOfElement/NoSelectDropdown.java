package com.cybertek.tests.day8_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));
        //open the dropdown
        dropdownElement.click();
        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));
        System.out.println("Number of links " + listofLinks.size());

        //for the first element of the drop down menu
       // System.out.println(linksList.get(0).getText());

        for (WebElement namelist:listofLinks) {
            System.out.println(namelist.getText());
        }

        driver.findElement(By.linkText("Yahoo")).click();


    }
}
