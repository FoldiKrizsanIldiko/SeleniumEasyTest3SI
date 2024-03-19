package com.codecool.fkildiko.seleniumTest.test.pageFactoryTests;

import com.codecool.fkildiko.seleniumTest.test.pageFactoryTests.actionForTest.Action;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.codecool.fkildiko.seleniumTest.pageFactory.DataValidator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataValidatorTest {
    private static final String baseUrl = "https://www.timeanddate.com/date/weekday.html";
 private static DataValidator dataValidator;
    private static Stream<Arguments> dataForTest() {
        //read data from excel file
        System.out.println(System.getProperty("user.dir"));
        String excelFullPath =  "src\\test\\java\\com\\codecool\\fkildiko\\seleniumTest\\test\\pageFactoryTests\\testResurces\\DataForTest.xlsx";
        String sheetName = "Munkalap2";
        Stream<Arguments> returnStream = Stream.empty();
        DataFormatter myDataFormatter = new DataFormatter();

        try (Workbook excelFile = WorkbookFactory.create(new File(excelFullPath), null, true)) {
            Sheet excelSheet1 = excelFile.getSheet(sheetName);

            for (Row row : excelSheet1) {
                //skip the header
                if (row.getRowNum() == 0) {
                    continue;
                }
                ArrayList<Object> rowArrayList = new ArrayList<>();
                //every cell write a list
                for (Cell cell : row) {
                    rowArrayList.add(myDataFormatter.formatCellValue(cell));
                }
                Arguments arguments = Arguments.of(rowArrayList.toArray());
                returnStream = Stream.concat(returnStream, Stream.of(arguments));
            }
            return returnStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnStream;

    }

    @BeforeAll
    public static void serUp() {
        Action.setUp(baseUrl);
        dataValidator = new DataValidator(Action.getDriver());
        dataValidator.skipThePopUp();
    }

    @Test
    public void isGivenDataExpectedDay() {
        String year = "2019";
        String month = "01";
        String day = "14";
        String expected = "Monday";
        String result = dataValidator.sendDataAndGetTheDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    public void isChosenFromTableDataIsDay() {
        String year = "2019";
        String month = "01";
        String day = "14";
        String expected = "Monday";
        String result = dataValidator.chooseDataFromTable(day, month, year);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name="{index} -- {0}-{1}-{2}")
    @MethodSource("dataForTest")
    void isDataSaturday(String d,String m, String y, String expected){
        System.out.println(d+"   "+m+"    "+y);
        String result = dataValidator.sendDataAndGetTheDay(d, m, y);
        String message= "The given day is not Saturday, but " + result;
        assertEquals(expected, result, message);
    }

    @AfterAll
    public static void tearDown() {
        Action.tearDown();
    }

}
