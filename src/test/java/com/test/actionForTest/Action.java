package com.test.actionForTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Action {
    //get a driver and get first page
    public static WebDriver driver;

    public static WebDriver  setUp(String baseUrl) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }
    public static void tearDown(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
    }
}
