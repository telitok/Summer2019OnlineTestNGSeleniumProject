package tests.day4;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadAttributesTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        //to read value of attribute
        //name="email" name is an attribute, email it is a value of attribute
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random_email@email.com");
        // how to read entered text?
        // it is going to be inside value attribute
        System.out.println(input.getAttribute("value"));
        // if button has a type "submit"
        // we can use .submit() method instead of clcik() as well
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        // alternative to click, only if type="submit"
        retrievePasswordButton.submit();
        driver.close();


    }
}
