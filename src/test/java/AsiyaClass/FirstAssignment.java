package AsiyaClass;

import Utils.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAssignment {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager219");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(3000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);
        driver.close();

        String expectedURL = "https://qa2.vytrack.com/user/login";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        System.out.println(expectedURL);

        if(expectedURL.equals(actualURL)) {
            System.out.println("Test pass");
        }
        else{
            System.out.println("Test fail");
            System.out.println(actualURL);
            System.out.println(expectedURL);
        }


    }
}
