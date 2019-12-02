package tests.Dogan.Formy;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class FormyCheckBoxTestCase extends CheckBox  {
    // inheritance
    // extends keyword to connect to class each for using its methods variables ,
    // Test cases only
    //jnuit @Test
    @Test
    public void NavigateToCheckboxLink() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://formy-project.herokuapp.com/");
        Thread.sleep(3000);
        navigateToDesiredLink("Checkbox");
        closeChromeBrowser();
    }

    @Test
    public void VerifyCheckBox() throws InterruptedException {
        GoToTheFormyWebPage();
        navigateToDesiredLink("Checkbox");
        VerifyAllCheckBoxes();
    }
    @Test
    public void clickablesTest() throws InterruptedException {
        GoToTheFormyWebPage();
        navigateToDesiredLink("Checkbox");
        ClickCheckBox();
    }


}