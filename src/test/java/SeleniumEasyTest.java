import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumEasyTest {
    private static WebDriver driver;
    String basic="https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html";


    @BeforeAll
    // @BeforeGroups
    public static void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navigation() {
        System.out.println("The Navigation test is starting : ");
        //tedd változóba a cimet
        driver.get(basic);
        driver.findElement(By.linkText("Input Forms")).click();
        driver.findElement(By.linkText("Simple Form Demo")).click();
    }

    @Test
    public void singleFieldAndButton() {
        driver.get(basic);
        String inputText = "Some message";
        driver.findElement(By.id("user-message")).sendKeys(inputText);
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
        String inputted = driver.findElement(By.id("display")).getText();
        System.out.println("The input was : " + inputted);
        assertEquals(inputted, inputText, "Test failed");

    }

    @Test
    public void twoFieldAndOutput() {
        driver.get(basic);
        String firstNumber = "13";
        String secondNumber = "1";
        int sumOfNumbers = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        driver.findElement(By.id("sum1")).sendKeys(firstNumber);
        driver.findElement(By.id("sum2")).sendKeys(secondNumber);
        driver.findElement(By.xpath("//button[text()='Get Total']")).click();
        String totalValue = driver.findElement(By.id("displayvalue")).getText();
        int result = Integer.parseInt(totalValue);
        System.out.println("The result of 13+1 should be 14 and it is : " + totalValue);
        assertEquals(result, sumOfNumbers);
    }

    //Checkbox
    @Test
    public void checkboxFirst() {
        driver.get("https://web.archive.org/web/20180911154259/http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.id("isAgeSelected")).click();
        String checked = driver.findElement(By.id("txtAge")).getText();
        assertEquals(checked, "Success - Check box is checked");
    }

    @Test
    public void checkboxSecond() {
        driver.findElement(By.xpath("//div[@id='easycont']/div/div[2]/div[2]/div[2]/div/label/input")).click();
        driver.findElement(By.xpath("//div[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label/input")).click();
        driver.findElement(By.xpath("//div[@id='easycont']/div/div[2]/div[2]/div[2]/div[3]/label/input")).click();

        String checkOrUncheck = driver.findElement(By.id("isChkd")).getAttribute("value");
        // System.out.println(checkOrUncheck);
        driver.findElement(By.xpath("//div[@id='easycont']/div/div[2]/div[2]/div[2]/div[4]/label/input")).click();
        String checkOrUnchecksec = driver.findElement(By.id("isChkd")).getAttribute("value");

        assertEquals(checkOrUncheck, checkOrUnchecksec, "true");
    }


    @Test
    public void selectList() {
        driver.get(basic);
        driver.findElement(By.linkText("Input Forms")).click();
        driver.findElement(By.partialLinkText("Dropdown List")).click();
        WebElement selectDay = driver.findElement(By.id("select-demo"));
        Select dropdown = new Select(selectDay);
        String selected;
        int numberOfSelected = dropdown.getOptions().size();
        for (int i = 1; i < numberOfSelected; i++) {
            dropdown.selectByIndex(i);
            selected = driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
            //System.out.println(selected);
            String optionText = dropdown.getOptions().get(i).getText();
            System.out.println(optionText);
            assertTrue(selected.contains(optionText));
        }
    }

    @Test
    public void radioButtons() {
        driver.get("https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> sexLabels = driver.findElements(By.xpath("//div[@class='panel-body']/div[1]/label"));
        List<WebElement> ageGroupLabels = driver.findElements(By.xpath("//div[@class='panel-body']/div[2]/label"));
        WebElement getValuesButton = driver.findElement(By.xpath("//button[text()='Get values']"));
        int noOfAgeGroupLabels = ageGroupLabels.size();

        for (WebElement sexLabel : sexLabels) {
            sexLabel.click();
            String sex = sexLabel.getText();
            for (int j = 0; j < noOfAgeGroupLabels; j++) {
                ageGroupLabels.get(j).click();
                String ageGroup = ageGroupLabels.get(j).getText().replace("to", "-");
                getValuesButton.click();
                String output = driver.findElement(By.xpath("//div[@class='panel-body']/p[@class='groupradiobutton']")).getText();
                assertTrue(output.contains(sex) && output.contains(ageGroup));
            }
        }
    }

    @Test
    public void dataValidator() {
        String expected = "Monday";
        driver.get("https://www.timeanddate.com/date/weekday.html");
        driver.findElement(By.xpath("//span[text()='AGREE']")).click();
        driver.findElement(By.id("day")).sendKeys("14");
        driver.findElement(By.id("month")).sendKeys("01");
        driver.findElement(By.id("year")).sendKeys("2019");
        driver.findElement(By.id("show")).click();
        String dayOfWeek = driver.findElement(By.id("dayOfWeek5")).getText();
        assertEquals(dayOfWeek, expected);
    }

    @Test
    public void sortAndSearch() {
        driver.get("https://web.archive.org/web/20180920023230/http://www.seleniumeasy.com/test/table-sort-search-demo.html");
        driver.findElement(By.xpath("//*[@id='example']/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//*[@id='example']/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//select[@name='example_length']")).sendKeys("25");
        List<WebElement> dataOfListed = driver.findElements(By.xpath("//html/body/div[4]/div/div[2]/div/div/table/tbody/tr/td[@class='sorting_1']"));
        int sumOfAges = 0;
        for (WebElement age : dataOfListed) {
            sumOfAges += Integer.parseInt(age.getText());
        }
        System.out.println(sumOfAges);
        assertEquals(sumOfAges, 1164);
    }

}
