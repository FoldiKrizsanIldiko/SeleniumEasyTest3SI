package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FirstPage {
    WebDriver driver;
    @FindBy(linkText = "Input Forms")
    WebElement inputForms;
    @FindBy(linkText = "Simple Form Demo")
    WebElement simpleFormDemo;

    @FindBy(xpath = "//div[normalize-space()='Single Input Field']")
    WebElement specElementOfSite;

    @FindBy(id = "user-message")
    WebElement singleInputField;
    @FindBy(xpath = "//button[text()=\"Show Message\"]")
    WebElement showMessageButton;
    @FindBy(id = "display")
    WebElement showedMessage;
    @FindBy(id = "sum1")
    WebElement firstNumber;
    @FindBy(id = "sum2")
    WebElement secondNumber;
    @FindBy(xpath = "//button[text()='Get Total']")
    WebElement getTotalButton;
    @FindBy(id = "displayvalue")
    WebElement sumResult;

    public FirstPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element) {
        element.click();
    }
    public void clearFields(WebElement... element){
        for (WebElement e: element){
            e.clear();
        }
    }

    public void getPage() {
        clickElement(inputForms);
        clickElement(simpleFormDemo);
    }

    public String verifySite() {
        return specElementOfSite.getText();
    }

    public String sendMessage(String message) {
        clearFields(singleInputField);
        singleInputField.sendKeys(message);
        showMessageButton.click();
        return showedMessage.getText();
    }

    public String countSum(String firstNum, String secondNum) {
        clearFields(firstNumber, secondNumber);
        firstNumber.sendKeys(firstNum);
        secondNumber.sendKeys(secondNum);
        getTotalButton.click();
        return sumResult.getText();
    }


}
