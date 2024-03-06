package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectDropdown {
    WebDriver driver;

//hány féle képpen lehet kiszedni a napokat?
    //option végigiterálni
    //sendKeys az egész neveket
    //sendkeys csak az első betű

    public SelectDropdown(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
