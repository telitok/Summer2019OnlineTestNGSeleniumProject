package tests.day4;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterTextPractice2 {

    // verify that confirmation message is displayed

    //1. go to "http://practicecybertekschool.com/forgot_password"
    // enter any valid email
    // click on the retrieve password button
    // verify that "Your e-mail's been sent!" message is displayed

    public static void main(String[] args) {

        //as usually we are starting from driver setup
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        // Keys.ENTER will simulate the enter button press
        input.sendKeys("random@email.com", Keys.ENTER);
        WebElement confirmationmessage = driver.findElement(By.name("confirmation_message"));
        // to get the text from element
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationmessage.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("test failed");
        }
        driver.close();
    }
}
