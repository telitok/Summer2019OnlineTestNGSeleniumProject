package tests.day5;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestForNameLocator {

    public static void main(String[] args) {
        // remember!
        // for mac users: you do not need  to use WebDriverManager for Safari
        // Safari has embedded webdriver support

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        // if you want to do in one line, without creating webelement reference variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        // enter email
        driver.findElement(By.name("email")).sendKeys("test_email@gmail.com");
        // click sign
        driver.findElement(By.name("wooden_spoon")).click();
        //pause for 3 seconds
        BrowserUtils.wait(3);
        driver.quit();
    }
}
