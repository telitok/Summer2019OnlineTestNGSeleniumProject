package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase2 {

    @Test
    public void listedexamples () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(3000);
        List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li/a"));
        int count = links.size();
        if(count==48){
            System.out.println("48 links");
        }else{
            System.out.println("Not 48");
        }
        
    }
}
