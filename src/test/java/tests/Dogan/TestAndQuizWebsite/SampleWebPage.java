package tests.Dogan.TestAndQuizWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleWebPage {

    //3 categories
    // variables
    //locators
    //methods

    //Test cases
    //JUnit --> @Test public void Testname(){}
    //JUnit --> Assert.AssertEqual(expected,actual)
    //Expected --> Computer gelen sonuc
    // Actual --> user'dan gelen sonuc

    WebDriver driver;

    @Test
    public void GetTitleOfPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        Thread.sleep(3000);
        WebElement inputbox=driver.findElement((By.name("firstName")));
        inputbox.sendKeys("Code Test");
        String result = inputbox.getAttribute("value");

        Assert.assertEquals(result,"salladik bisey:)");
        System.out.println(result);

        driver.close();
    }
    @Test
    public void GetColorofButton(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.testandquiz.com/selenium/testing.html");

        WebElement submitbutton = driver.findElement(By.id("idOfButton"));
        submitbutton.click();
        String color = submitbutton.getCssValue("color");
        System.out.println(color);

        String color2 = submitbutton.getCssValue("background-color");
        System.out.println(color2);

        driver.quit();
    }
    //degisiklik
    // test
}
