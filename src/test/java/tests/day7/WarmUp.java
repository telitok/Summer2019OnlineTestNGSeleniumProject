package tests.day7;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WarmUp {


    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        // how to find all links
        // every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        // size of the lst = number of links
        // findElement vs findElements
        // in case of find element, if there is no element found, you will get an exception
        //NoSuchElementException
        // finElement= 1 web element
        // findElements = 0 or more elements
        // if list is empty, that means element is not there
        // in this way, we can ensure that element does not present
        //  //a[.='Home']  - find link with text name Home
        System.out.println("Number of links: "+links.size());
        // what if I want to print text of all links, one by one
        for(WebElement each : links){
            // print the text of every link
            // if there is a text, not empty link
            if(!each.getText().isEmpty()) {
                System.out.println(each.getText());
            }
        }
        driver.quit();


    }
}
