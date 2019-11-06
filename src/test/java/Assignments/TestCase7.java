package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase7 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input")).sendKeys("testers@email");
        boolean message = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).isDisplayed();
        boolean message2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]")).isDisplayed();
        if(message && message2){
            System.out.println("Test Passed");

        }else{
            System.out.println("Test Failed");
        }


    }
}
