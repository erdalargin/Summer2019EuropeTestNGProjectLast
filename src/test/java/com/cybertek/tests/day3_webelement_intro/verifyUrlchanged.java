package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Verify URL changed
 * open browser
 * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
 * enter any email
 * click on Retrieve password
 * verify that url changed to http://practice.cybertekschool.com/email_sent
 */
public class verifyUrlchanged {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to web page
        driver.get(" http://practice.cybertekschool.com/forgot_password");

        //type any (valid) email
        WebElement emailInput = driver.findElement(By.name("email"));
        //sendKeys()---> send keyboard actions to web element / enters given text
        emailInput.sendKeys("email@gmail.com");
        //locate the password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        //verify url changed to .... url :
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();
        // verify that url is changed
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual URL"+actualUrl);
            System.out.println("expected URL"+expectedUrl);
        }
        //close browser
        driver.quit();

    }
}
