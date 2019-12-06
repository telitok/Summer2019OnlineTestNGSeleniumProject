package SuperHero.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ApplyingIterationMethods {


    public WebDriver driver;
    public String URL = "https://glitchitsystem.com/superhero/index.html";


    public void LoginWithCredential() throws InterruptedException {
        WebElement email = driver.findElement(By.id("loginEmail"));
        email.sendKeys("justtesting@gmail.com");
        WebElement password = driver.findElement(By.id("loginPassword"));
        password.sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
        Thread.sleep(3000);
    }

    public List<String> SuperHeroNames() {
        List<String> names = new ArrayList<>();
        names.add("Wolverine");
        names.add("Iron Man");
        names.add("Deadpool");
        names.add("Thor");
        names.add("Spider-man");
        return names;
    }
    @BeforeMethod
    public void SetUp2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test (description = "Verify the names on the SuperHero Roster")
    public void test() throws InterruptedException {
        LoginWithCredential();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='hero-list']//li"));
        for (int i =0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            Assert.assertEquals(list.get(i).getText(),SuperHeroNames().get(i));
        }

    }

    @Test(description = "", priority = 0)
    public void NavigationLinks() throws InterruptedException {
        LoginWithCredential();

        List<WebElement> list = driver.findElements(By.xpath("//form[@id='vote-form']//div"));

        List<String> voteform = new ArrayList<>();

       for (WebElement each : list){
           voteform.add(each.getText());
       }
        System.out.println(voteform);

       Assert.assertEquals(list.get(0).getText(),voteform.get(0));
    }

    @Test(description = "", priority = 1)
    public void NavigationDesiredLink() throws InterruptedException {

    }

    @AfterMethod
    public void teardown2() {
        driver.quit();
    }


}