package SuperHero.HomePage;

import SuperHero.LoginPage.Login;
import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NavigationLinks{

    public WebDriver driver;
    public String URL = "https://glitchitsystem.com/superhero/index.html";

    @BeforeMethod
    public void SetUp2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
 }
@Test(description = "Verify the home page links")
    public void NavigationLinks() throws InterruptedException {
   // Login login = new Login();  // to log into the webpage
    //LoginToHomePage();
    WebElement email = driver.findElement(By.id("loginEmail"));
    email.sendKeys("justtesting@gmail.com");
    WebElement password = driver.findElement(By.id("loginPassword"));
    password.sendKeys("123456");
    driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
    BrowserUtils.wait(3);
    List<WebElement> list = driver.findElements(By.xpath("//ul[@class='navbar-nav mr-auto']//li/a"));
    for (WebElement each : list) {
        System.out.println(each.getText());
        try{
            WebDriverWait wait = new WebDriverWait(driver, 6);
            Assert.assertTrue(each.isEnabled());
            wait.until(ExpectedConditions.elementToBeClickable(each));
            System.out.println("This link is clickable");
        } catch (Exception e){
            System.out.println("This link is not clickable");
        }
    }
}
    @AfterMethod
    public void teardown2(){
        driver.quit();
    }
}
