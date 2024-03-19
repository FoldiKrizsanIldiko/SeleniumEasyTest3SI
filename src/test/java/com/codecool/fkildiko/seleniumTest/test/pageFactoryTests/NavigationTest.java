package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.pageFactory.FirstPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Don't use Selenium
public class NavigationTest {

    static String baseUrl = "https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html";
    private static final WebDriver chromeDriver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
    }

    @Test
    public void Navigation() {
        String expected = "Single Input Field";
        FirstPage nav = new FirstPage(chromeDriver);
        nav.openThePage();
        assertTrue(nav.displayedPage().contains(expected), "Navigation failed :( "); //ez talán lehetne leírób
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.close();
    }

}
