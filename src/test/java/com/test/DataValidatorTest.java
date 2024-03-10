package com.test;

import com.test.actionForTest.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageFactory.DataValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataValidatorTest {
    private static final String baseUrl = "https://www.timeanddate.com/date/weekday.html";

    @BeforeAll
    public static void serUp() {
        Action.setUp(baseUrl);
    }

    @Test
    public void isGivenDataExpectedDay() {
        DataValidator dataValidator = new DataValidator(Action.driver);
        String year = "2019";
        String month = "01";
        String day = "14";
        String expected = "Monday";
        dataValidator.skipThePopUp();
        String result = dataValidator.sendDataAndGetTheDay(day, month, year);
        assertEquals(expected, result);
    }
    @Test
    public void isChosenFromTableDataIsDay(){
        DataValidator dataValidator = new DataValidator(Action.driver);
        String year = "2019";
        String month = "01";
        String day = "14";
        String expected = "Monday";
        dataValidator.skipThePopUp();
        String result = dataValidator.chooseDataFromTable(day, month, year);
        assertEquals(expected, result);
    }

    @AfterAll
    public static void tearDown() {
        Action.tearDown();
    }

}
