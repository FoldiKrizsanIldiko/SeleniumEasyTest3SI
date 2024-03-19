package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.pageFactory.SelectDropdown;
import com.codecool.fkildiko.seleniumTest.test.pageFactoryTests.Enum.NameOfDay;
import com.codecool.fkildiko.seleniumTest.test.pageFactoryTests.actionForTest.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectListDemoTest {
    private static final String baseUrl = "https://web.archive.org/web/20180820002117/http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

    //@BeforeEach this will open new browser for Each data Driven test case. It is toooooooo long

    public static Stream<Arguments> sendFirstLetterOfDayIntoInput1() {
        return Stream.of(
                Arguments.of("Su", "Sunday"), // null strings should be considered blank
                Arguments.of("M", "Monday"),
                Arguments.of("Tu", "Tuesday"),
                Arguments.of("W", "Wednesday"),
                Arguments.of("Th", "Thursday"),
                Arguments.of("F", "Friday"),
                Arguments.of("Sa", "Saturday")
        );
    }

    @BeforeAll
    public static void setUp() {
        Action.setUp(baseUrl);
    }

    @Test
    public void selectFromDropdownTwice() {
        SelectDropdown selectDropdown = new SelectDropdown(Action.getDriver());
        for (int twice = 0; twice < 2; twice++) {
            for (int i = 1; i < selectDropdown.getNumberOfItemsInDropdown(); i++) {
                String selectedDay = selectDropdown.selectFromDropdown(i);
                System.out.println(selectedDay);
                String shownMessage = selectDropdown.getShownMessage();
                assertTrue(shownMessage.contains(selectedDay));
            }
        }
    }

    @ParameterizedTest
    @EnumSource(value = NameOfDay.class)
    void sendNamesOfDayToInput(NameOfDay day) {
        SelectDropdown selectDropdown = new SelectDropdown(Action.getDriver());
        selectDropdown.tipeToInputField(day.name());
        String shownMessage = selectDropdown.getShownMessage();
        assertTrue(shownMessage.contains(day.name()));
    }

    @ParameterizedTest
    @MethodSource("sendFirstLetterOfDayIntoInput1")
    void sendFirstLetterOfDayIntoInput(String FirstLetterOfDay, String expected) {
        SelectDropdown selectDropdown = new SelectDropdown(Action.getDriver());
        selectDropdown.tipeToInputField(FirstLetterOfDay);
        String shownMessage = selectDropdown.getShownMessage();
        assertTrue(shownMessage.contains(expected));
    }

    @AfterAll
    public static void tearDown() {
        Action.tearDown();
    }
}
