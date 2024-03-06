package com.test;

import KeywordActions.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.FirstPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoInputSumTest {
    static String baseUrl = "https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html";

    @BeforeAll
    public static void setUp() {
        Action.setUp(baseUrl);
    }

    @ParameterizedTest(name = "{index} -- {0} -- {1}")
    @CsvFileSource(resources = "/TwoFieldAndOutputSources.csv", numLinesToSkip = 1)
    void SingleInput(String first, String second, String expected) {
        FirstPage firstPage = new FirstPage(Action.driver);
        assertEquals(expected, firstPage.countSum(first, second), "The sum is not what u expected");
    }

    @AfterAll
    public static void tearDown() {
        Action.tearDown();
    }
}
