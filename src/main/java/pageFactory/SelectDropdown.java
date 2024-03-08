package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
    WebDriver driver;

    @FindBy(id = "select-demo")
    WebElement input;

    @FindBy(xpath = "//p[@class='selected-value']")
    WebElement shownText;

    private Select dropdown(){
        return new Select(input);
    }

//hány féle képpen lehet kiszedni a napokat?
    //option végigiterálni
    //sendKeys az egész neveket
    //sendkeys csak az első betű

    public SelectDropdown(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfItemsInDropdown() {
        return dropdown().getOptions().size();
    }

    public String selectFromDropdown(int i) {
        dropdown().selectByIndex(i);
        //return what did I select
        return dropdown().getOptions().get(i).getText();
    }

    public String getShownMessage() {
        return shownText.getText();
    }

    public void tipeToInputField(String day){
        input.click();
        input.sendKeys(day);
        input.sendKeys(Keys.ENTER);
    }

}
