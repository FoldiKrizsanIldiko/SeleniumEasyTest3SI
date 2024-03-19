package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests.actionForTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Action {


    //get a driver and get first page
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void  setUp(String baseUrl) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    public static void tearDown(){
        driver.close();
    }
}
