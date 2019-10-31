package tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForIDLocator {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.id("disappearing_button"));

        button.click();

        WebElement result = driver.findElement(By.id("result"));
        // <p id="result" style="color:green">Now it's gone!</p>
        // now it is gone  <----- text,   .getText() will return this text
        System.out.println(result.getText());

        driver.quit();
    }
}
