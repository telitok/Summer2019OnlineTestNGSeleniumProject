package tests.day7;

import Utils.BrowserFactory;
import Utils.BrowserUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CssSelectorPractice {

    // which locator to use?
    //#1 id
    // #2 css
    // #3 xpath
    // ## whatever
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        // let's find all buttons, and click on them one by one
        // why I put . instead of space? Because it's 2 class names .btn.btn-primary
        // in this case, we will find all buttons that have: class="btn btn-primary"
        // or lil=ke this [class='btn btn-primary'] , no need for .
        // . means class name
        // # means id name
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        // loop through list of buttons
        for(WebElement button : buttons){
            // and click on every button one by one
            button.click();
            BrowserUtils.wait(2);
            // get the message after clcik
            WebElement message = driver.findElement(By.cssSelector("#result"));
            // print a text of that message
            System.out.println(message.getText());
        }
        // find element with a tag name h3, that has a parent element, with class name container
        WebElement header = driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container']>p"));
        System.out.println(p.getText());

        driver.quit();



    }
}
