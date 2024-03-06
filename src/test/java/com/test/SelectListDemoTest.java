package com.test;

import KeywordActions.Action;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectListDemoTest {
    private static String baseUrl="https://web.archive.org/web/20180820002117/http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

    @BeforeEach
    public void setUp(){
        Action.setUp(baseUrl);
    }

    @Test
    public void Test(){
        System.out.println("any");
    }


    @AfterEach
    public void tearDown(){
        Action.tearDown();
    }
}
