package com.cybertek.tests.day1_basic_navigation;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class basic_navigation {
    public static void main(String[] args) {
        // we have to setup web driver base on the browser we are gonna use .
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");
        //get the title and print

        System.out.println(driver.getTitle());

    }
}
