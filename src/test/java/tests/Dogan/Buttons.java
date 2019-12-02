package tests.Dogan;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Buttons {
    //global (instance) variable
    WebDriver driver;
    public void Button() throws InterruptedException {
        //Setting up ChromeDriver via Maven dependencies.
        WebDriverManager.chromedriver().setup();
        //Creating object of ChromeDriver
        driver = new ChromeDriver();
        //Using get method to open the given url
        driver.get("http://formy-project.herokuapp.com");
        //To give time delay for page loading or any date.
        Thread.sleep(2000);
        //Locating the target element.
        driver.findElement(By.xpath("/html/body/div/div/li[2]/a")).click();
        //Time delay for elements to load
        //Thread.sleep(3000);
        //Retrieve the page title.
        String title = driver.getTitle();
        //Printing the page title
        System.out.println(title);
    }
    @Test
    public void verifyPrimaryButton() throws InterruptedException{
        //to call the dynamic from our class
        Button();
        //verify the primary button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[1]")).click();
        Thread.sleep(2000);
        String getText = driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[1]")).getText();
        System.out.println(getText);
        String PrimaryButton = "/html/body/div/form/div[1]/div/div/button[1]";
        WebElement element = driver.findElement(By.xpath(PrimaryButton));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            System.out.println(element.getText());
        }
        driver.close();
    }
    @Test
    public void verifySuccessButton() throws InterruptedException {
        //to call the dynamic from our class
        Button();
        //verify the primary button
        Thread.sleep(2000);
        String SuccessButton = "/html/body/div/form/div[1]/div/div/button[2]";
        WebElement element = driver.findElement(By.xpath(SuccessButton));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            Thread.sleep(2000);
            System.out.println(element.getText());
        }
        driver.close();
    }
    @Test
    public void verifyInfoButton() throws InterruptedException {
        //to call the dynamic from our class
        Button();
        //verify the Info button

        String infoPath = "/html/body/div/form/div[1]/div/div/button[3]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(infoPath)));
        element.click();
        System.out.println(element.getText());
        driver.close();
    }
    @Test
    public void verifyWarningButton() throws InterruptedException {
        //to call the dynamic from our class
        Button();
        //verify the Info button

        String WarningPath = "/html/body/div/form/div[1]/div/div/button[4]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WarningPath)));
        element.click();
        System.out.println(element.getText());
        driver.close();
    }
}