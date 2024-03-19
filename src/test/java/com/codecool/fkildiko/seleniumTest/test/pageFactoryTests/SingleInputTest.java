package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.pageFactory.FirstPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleInputTest {
    static String baseUrl = "https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html";
    private static final WebDriver chromeDriver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
    }

    @ParameterizedTest(name = "{index} -- {0}")
    @CsvFileSource(resources = "/SingleInputSources.csv", numLinesToSkip = 1)
    void SingleInput(String input) {
        FirstPage firstPage = new FirstPage(chromeDriver);
        assertEquals(firstPage.typeInMessageAndCheckDisplay(input), input, "The message is not what you expected");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.close();
    }
}
