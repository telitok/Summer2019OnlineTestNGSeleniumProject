package tests.day8;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // to go to Radio Buttons page
        // <a href="/radio_buttons">Radio Buttons</a>
        // linkText works only with <a> elements
        // link text only in between >Text<
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test
    public void test1(){
        // find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        // let's verify that radio button is selected
        boolean isSelected = blueButton.isSelected() ;
        Assert.assertTrue(isSelected);  // will expect that isSelected true
    }
    @Test (description = "verify that red button is not selected")
    public void test2(){
        // find blue radio button
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected()); // will expect that the condition is false
    }
    @Test (description = "Verify that green button is not clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        // isEnabled will return true if button is available for interaction
        // it means you can click on it, in this case
        Assert.assertFalse(greenButton.isEnabled());
    }
    @Test
    public void test4(){
        // how to find all radio buttons
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // let's click only if button is not clicked and is available for clicking
        for(WebElement button:radioButtons){
            //if button is available for clicking and not clicked yet
            if(button.isEnabled() && !button.isSelected()){
                // then click on it
                button.click();
                // in this case, id attribute represents a name of the color
                // // also, there is not text in this element
                // that's why we print attribute value
                // <input type = "radio"  id="green"  name="color"  disabled=""> attribute: type, id, name, disabled
                System.out.println("Button clicked: "+button.getAttribute("id"));
            }else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
