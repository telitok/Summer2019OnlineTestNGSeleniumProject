package Assignments;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

    @Test
    public void signup() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("full_name")).sendKeys("Tugba Elitok");
        driver.findElement(By.name("email")).sendKeys("firtina_35.5@hotmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();

        if (actual.equals(expected)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]/i")).click();
        BrowserUtils.wait(3);
        driver.quit();



    }


}
