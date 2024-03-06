package com.test;

import KeywordActions.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageFactory.FirstPage;

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
        nav.getPage();
        assertTrue(nav.verifySite().contains(expected), "Navigation failed :( ");
    }

    @AfterAll
    public static void tearDown(){
        Action.tearDown();
    }

}
