package com.codecool.fkildiko.seleniumTest.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DataValidator {
    public WebDriver driver;
    private String dayToTable;
    @FindBy(xpath = "//span[text()='AGREE']")
    WebElement popupAgree;

    @FindBy(id = "day")
    WebElement day;
    @FindBy(id = "month")
    WebElement month;
    @FindBy(id = "year")
    WebElement year;
    @FindBy(id = "show")
    WebElement showButton;
    @FindBy(id = "dayOfWeek5")
    WebElement dayOfDate;

    @FindBy(xpath = "//div[@id='po1']/div/table/tbody/tr/td//ul/li")
    List<WebElement> daysFromTable;

    @FindBy(xpath = "//div[@id='po1']/div/ul/li//a")
    List<WebElement> dataFromTable;


    public DataValidator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void skipThePopUp() {

        if (popupAgree.isDisplayed()) popupAgree.click();
    }

    public String sendDataAndGetTheDay(String d, String m, String y) {
        day.clear();
        day.sendKeys(d);
        month.clear();
        month.sendKeys(m);
        year.clear();
        year.sendKeys(y);
        showButton.click();
        return dayOfDate.getText();
    }

    public String chooseDataFromTable(String d, String m, String y) {
        day.click();
        daysFromTable.stream().filter(elem -> Objects.equals(elem.getText(), d)).findFirst().ifPresent(element -> {
            element.click();
            System.out.println("Found d");
        });//.ifPresent(WebElement::click);
        month.click();
        dataFromTable.stream().filter(elem -> elem.getText().contains(m)).findFirst().ifPresent(element -> {
            element.click();
            System.out.println("Found m");
        });//.ifPresent(WebElement::click);
        year.click();
        dataFromTable.stream().filter(elem -> Objects.equals(elem.getText(), y)).findFirst().ifPresentOrElse(element -> {
            element.click();
            System.out.println("found y");
        }, () -> {
            year.sendKeys(y);
            System.out.println("There is no specified year in the table; I have entered it into the input.");
        });//.ifPresent(WebElement::click);
        showButton.click();
        return dayOfDate.getText();
    }

}
