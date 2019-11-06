package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase8 {

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input")).sendKeys("5711234354");
        boolean message = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]")).isDisplayed();
        if(message){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }
}
