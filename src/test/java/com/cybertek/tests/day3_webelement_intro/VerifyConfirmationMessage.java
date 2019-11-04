package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        //open browser chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //navigate website
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter email
        WebElement emailInput = driver.findElement(By.name("email"));

        String expectedEmail = "test01@gmail.com";
        //send any email address
        emailInput.sendKeys(expectedEmail);

        //verify that email is displayed in the input box
        //getting text fro webElements
        //getAttribute() gets value of attribute

        String actualEmail =  emailInput.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        WebElement RetrievePasswordButton = driver.findElement(By.id("form_submit"));
        RetrievePasswordButton.click();

         //* verify that confirmation message says 'Your e-mail's been sent!'
        String expectedMessage = "Your e-mail's been sent!";
        WebElement messageElement =driver.findElement(By.name("confirmation_message"));
        String actualMessage = messageElement.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = "+expectedMessage);
            System.out.println("actualMessage = "+ actualMessage);

        }
        
        
        driver.quit();

    }
}
