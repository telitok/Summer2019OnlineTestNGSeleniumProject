package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase6 {

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input")).sendKeys("user");
        //Receiving the error message
        String actualWarning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).getText();

        //Expected message.
        String expectedWarning = "The username must be more than 6 and less than 30 characters long";

        //comparing the expected and actual message and printing it console...
        if(expectedWarning.equals(actualWarning)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
