package com.cybertek.tests.day13_properties_driver_testbase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class SingletonTest {
    WebDriver driver;


    @Test
    public void test2(){

        //this is how we create webdriver object from now on
        //type of the driver will come from configuration.properties file
        driver = Driver.get();

        //we are getting url from configuration.properties file
        driver.get(ConfigurationReader.get("url"));

        driver.navigate().refresh();
    }



    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("http://amazon.com");

        //if we are using Driver close, we use closeDriver method to close the driver.
        Driver.closeDriver();
    }
}
