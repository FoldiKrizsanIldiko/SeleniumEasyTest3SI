package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButton {
    WebDriver driver;
    ////div[@class='panel-body']/div[1]/label
    @FindBy(xpath = "//div[contains(h4,'Sex')]/label")
    List<WebElement> sexLabels;

    @FindBy(xpath = "//div[contains(h4, 'Age Group : ')]/label")
   List<WebElement>  ageLabels;

    @FindBy(xpath = "//button[text()='Get values']")
      WebElement getValuesButton;

    @FindBy(xpath = "//div[@class='panel-body']/p[@class='groupradiobutton']")
    WebElement displayedMessage;
    public RadioButton(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void getSexLabels(){
        for(WebElement label:sexLabels){
            System.out.println(label.getText());
        }

        for(WebElement label:ageLabels){
            System.out.println(label.getText());
        }
    }

    public int getNumberOfSexs(){
        return sexLabels.size();
    }
    public int getNumberOfAgeGroups(){
        return ageLabels.size();
    }

    public String selectSex(int i){
        sexLabels.get(i).click();
        return sexLabels.get(i).getText();
    }
    public String selectAgeGroup(int j){
        ageLabels.get(j).click();
        return ageLabels.get(j).getText();
    }
    public void submitChoices(){
        getValuesButton.click();
    }
    public String getDisplayedMessage(){
        return displayedMessage.getText();
    }

}
