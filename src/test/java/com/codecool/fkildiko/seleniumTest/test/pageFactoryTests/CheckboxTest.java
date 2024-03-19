package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.pageFactory.CheckBox;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckboxTest {
    static String baseUrl = "https://web.archive.org/web/20180911154259/http://www.seleniumeasy.com/test/basic-checkbox-demo.html";
    private static final WebDriver chromeDriver = new ChromeDriver();

    private static Stream<Arguments> combinationForFourCheckBox() {
        return Stream.of(
                Arguments.of("0000", "Check All"),
                Arguments.of("1000", "Check All"),
                Arguments.of("1100", "Check All"),
                Arguments.of("1110", "Check All"),
                Arguments.of("1111", "Uncheck All"),
                Arguments.of("0111", "Check All"),
                Arguments.of("0110", "Check All"),
                Arguments.of("0100", "Check All"),
                Arguments.of("0010", "Check All"),
                Arguments.of("0011", "Check All"),
                Arguments.of("0001", "Check All"),
                Arguments.of("1010", "Check All"),
                Arguments.of("1001", "Check All"),
                Arguments.of("1011", "Check All"),
                Arguments.of("1101", "Check All"),
                Arguments.of("0101", "Check All")
        );
    }

    @BeforeAll
    public static void setUp() {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
    }

    @Test
    void singleCheckboxTest() {
        String expected = "Success - Check box is checked";
        CheckBox checkBox = new CheckBox(chromeDriver);
        assertEquals(expected, checkBox.checkTheSingleBox(), "The message is not visible!!!");
        checkBox.unCheckSingleBox();
    }

    @ParameterizedTest(name = " {index} -- {0}")
    @MethodSource("combinationForFourCheckBox")
    void checkBoxesTestWithoutSingleBoxCheck(String Multi, String expected) {
        CheckBox checkBox = new CheckBox(chromeDriver);
        String result = checkBox.checkMultipleBox(false, Multi);
        assertEquals(expected, result, "Test with no checked upper box failed");
    }

    @ParameterizedTest(name = " {index} -- {0}")
    @MethodSource("combinationForFourCheckBox")
    void checkBoxesTestWithSingleBoxCheck(String Multi, String expected) {
        CheckBox checkBox = new CheckBox(chromeDriver);
        String result = checkBox.checkMultipleBox(true, Multi);
        assertEquals(expected, result, "Test with checked first box failed");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.close();
    }
}
