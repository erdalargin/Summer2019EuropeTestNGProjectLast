package com.cybertek.tests.day8_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkBoxDemo {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        WebElement checkbox1 = driver.findElement(By.xpath("//input"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input)[2]"));
        //verify that checkbox 1 is unselected 2 is selected
        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify check box 2 is selected");

        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox 1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox 2 is selected");

    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioButton = driver.findElement(By.id("blue"));
        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        //get the value of id attribute
        System.out.println(radioButton.getAttribute("id"));
        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));
        //trying to get attribute does not exist
        //when we use non exist attribute it will return NULL to us.
        System.out.println(radioButton.getAttribute("href"));
        //attribute without value (checked)
        //checked attribute value is boolean if it is checked it will be true
        System.out.println(radioButton.getAttribute("checked"));
        //"outerHTML" returns full html of that element
        System.out.println(radioButton.getAttribute("outerHTML"));

    }

}
