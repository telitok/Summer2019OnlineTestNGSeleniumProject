package tests.Dogan.Youtube;
import Utils.GetValueFromPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TestingYoutube {
    WebDriver driver;
    @Test
    public void Test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // navigate to website with get methods
        driver.get(GetValueFromPropertyFile.getProperty("url"));
        WebElement searchbox = driver.findElement(By.id("search"));
        searchbox.sendKeys(GetValueFromPropertyFile.getProperty("lookingFor"));
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='video-title']"));
        allLinks.get(0).click();
        Thread.sleep(2000);
        driver.close();
    }
}







