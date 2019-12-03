package com.cybertek.tests.day7_testNg.day7_Types_of_Element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioButtons(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        System.out.println("Is blue selected : "+blueRadioButton.isSelected());
        System.out.println("Is red selected : "+redRadioButton.isSelected());


        //verify that blue radio button selected:
        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue button is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "Verify that red radio button not selected");
        //redRadioButton.click();
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue button is not selected");
        Assert.assertTrue(redRadioButton.isSelected(),"verify that red button is selected");


        driver.quit();


    }
}
