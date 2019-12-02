package AsiyaClass;

import Utils.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Homework2InvalidCredentials {

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(2000);
        driver.findElement(By.name("_username")).sendKeys("storemanager219");
        driver.findElement(By.name("_password")).sendKeys("User123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);
        boolean message = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).isDisplayed();
        if(message){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();


    }
}
