package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

    @Test
    public void listedexamples () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(3000);
        
    }
}
