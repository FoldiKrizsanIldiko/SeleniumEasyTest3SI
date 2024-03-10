package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CheckBox {
    WebDriver driver;
    @FindBy(id = "isAgeSelected")
    WebElement singleCheckBox;
    @FindBy(id = "txtAge")
    WebElement checkedConfirmed;
    @FindBy(xpath = "(//div[@class='panel-body' and preceding-sibling::div[text()='Multiple Checkbox Demo']])/div//label/input")
    List<WebElement> checkboxes;

    @FindBy(id = "check1")
    WebElement checkAllButton;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void unCheckBox(WebElement box) {
        if (box.isSelected()) {
            box.click();
        }
    }

    public String checkTheSingleBox() {
        singleCheckBox.click();
        return checkedConfirmed.getText();
    }


    public void unCheckSingleBox() {
        unCheckBox(singleCheckBox);
    }


    public String checkMultipleBox(boolean Single, String Multi) {
        unCheckBox(singleCheckBox);
        if (Single) checkTheSingleBox();
        //if String send 1 than click the box
        for (int i = 0; i < checkboxes.size(); i++) {
            unCheckBox(checkboxes.get(i));
            if (Multi.charAt(i) == '1') {
                checkboxes.get(i).click();
            }
        }
        return checkAllButton.getAttribute("value");
    }
}
