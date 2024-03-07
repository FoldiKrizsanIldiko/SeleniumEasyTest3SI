package com.test;

import KeywordActions.Action;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageFactory.RadioButton;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioButtonsTest {
    private static final String baseUrl = "https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-radiobutton-demo.html";

    @BeforeAll
    public static void setUp(){
        Action.setUp(baseUrl);
    }

    @Test
    public void combinationsOfSexAndAgeGroup(){
        RadioButton radioButton=new RadioButton(Action.driver);
       int NumS= radioButton.getNumberOfSexs();
       int NumAgeOG= radioButton.getNumberOfAgeGroups();
        for(int i=0;i<NumS;i++){
           String sex= radioButton.selectSex(i);
           for(int j=0;j<NumAgeOG;j++){
                String ageG= radioButton.selectAgeGroup(j).replace("to", "-");
                radioButton.submitChoices();
                String message=radioButton.getDisplayedMessage();
                assertTrue(message.contains(sex) && message.contains(ageG));
           }
        }
    }

    @AfterAll
    public static void terDown(){
        Action.tearDown();
    }
}
