package tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForTagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement sub_header = driver.findElement(By.tagName("h3"));
        System.out.println(sub_header.getText());
        driver.quit();
    }
}
