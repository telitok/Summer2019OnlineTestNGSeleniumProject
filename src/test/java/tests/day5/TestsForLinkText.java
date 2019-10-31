package tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestsForLinkText {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
//      <a href="/autocomplete">Autocomplete</a>
//        Autocomplete - it's the text that you see
        // place where it will navigate you to the specific place
        // it works only if tag name is <a>
        // if you want to use a Linktext or partial linktext locator strategy
        // element must start with <a>
        // this is how we specify links in HTML
        driver.findElement(By.linkText("Autocomplete")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
