package Assignments;

import Utils.BrowserFactory;
import Utils.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class BasicNavigationHW {

    @Test (description = "Test Case 1")
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
    @Test(description = "Test case 2")
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
    @Test (description = "Test case 3")
    public void testcase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();
        Thread.sleep(2000);
        boolean message = driver.findElement(By.xpath("//*[@id=\"result\"]")).isDisplayed();
        System.out.println(message);
    }
    @Test (description = "Test case 4")
    public void testcase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input")).sendKeys("123");
        boolean message = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).isDisplayed();
        if(message){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }
    }
    @Test (description = "Test case 5")
    public void testcase5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input")).sendKeys("123");
        boolean message = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).isDisplayed();
        if(message){
            System.out.println("Test Passed");

        }else{
            System.out.println("Test Failed");
        }
    }

    @Test
    public void testcase6() throws InterruptedException {

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
    public void testcase7() throws InterruptedException {

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
    @Test
    public void testcase8() throws InterruptedException {

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
