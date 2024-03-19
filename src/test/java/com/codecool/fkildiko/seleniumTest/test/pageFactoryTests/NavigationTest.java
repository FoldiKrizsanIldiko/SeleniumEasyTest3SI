package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.test.pageFactoryTests.actionForTest.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codecool.fkildiko.seleniumTest.pageFactory.FirstPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Don't use Selenium
public class NavigationTest {

    static String baseUrl = "https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html";

    @BeforeAll
    public static void setUp() {
       Action.setUp(baseUrl);
    }

    @Test
    public void Navigation(){
        String expected="Single Input Field";
        FirstPage nav = new FirstPage(Action.driver);
        nav.openThePage();
        assertTrue(nav.displayedPage().contains(expected), "Navigation failed :( "); //ez talán lehetne leírób
    }

    @AfterAll
    public static void tearDown(){
        Action.tearDown();
    }

}
