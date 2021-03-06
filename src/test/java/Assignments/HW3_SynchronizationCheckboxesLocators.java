package Assignments;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW3_SynchronizationCheckboxesLocators {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        BrowserUtils.wait(3);

    }
    @Test (description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(3);
        // web element for "Options"
        WebElement options = driver.findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(options));
        boolean option = options.isDisplayed();
        String expectedoptions = "Options";
        String actual = options.getText();
        Assert.assertEquals(expectedoptions,actual,"Text for options not same");

    }
    @Test (description = "Verify that page number is equal to '1'")
    public void testcase2(){
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(3);
        String pageNumber = driver.findElement(By.cssSelector("[type='number']")).getAttribute("value");
        System.out.println(pageNumber);
    }
    @Test(description = "Verify that view per page number is equals to '25'")
    public void testcase3(){
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(7);
        String actual = driver.findElement(By.className("btn dropdown-toggle ")).getText();
        String expected = "25";
        Assert.assertEquals(actual,expected);

        // not done
    }
    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void testcase4(){
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(3);
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody//tr"));
        int actual = list.size();
        int expected = 22;
        Assert.assertEquals(actual,expected, "numbers are not same");

    }
    @Test (description = "Verify that all calendar events were selected")
    public void testcase5(){
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(3);
        // find the clickable icon in the header and click to select all
        driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//thead//tr/th[1]/div/button/input")).click();
        // find the all clickable icons in the table
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody//tr//td//input"));
        // make sure that all calendar events are selected
        for(WebElement each : list){
            Assert.assertTrue(each.isSelected());
        }
    }
    @Test(description = "Verify that data is displayed")
    public void testcase6() {
        Actions action = new Actions(driver);
        // Web element for activities
        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(activities));
        action.moveToElement(activities).perform();
        BrowserUtils.wait(3);
        //find calendar events
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]")).click();
        BrowserUtils.wait(3);
        // find "Testers meeting"
        driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody//tr[15]//td[2]")).click();
        BrowserUtils.wait(5);
        // Create a string list which includes expected info
        List<String> info = new ArrayList<>(Arrays.asList("Title\nTesters Meeting", "Description\nThis is a a weekly testers meeting", "Start\nNov 27, 2019, 9:30 PM", "End\nNov 27, 2019, 10:30 PM", "All-day Event\nNo", "Organizer\nStephan Haley",
                                                          "Guests\nTom Smith - Required", "Recurrence\nWeekly every 1 week on Wednesday", "Call Via Hangout\nNo"));
        // Create a list of actual info
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='control-group attribute-row']"));
        // iterate through the expected and actual info and make sure that they match
        for (int i =0;i<list.size();i++) {
                    Assert.assertEquals(list.get(i).getText(),info.get(i));

            // I print out everything just to make sure :)
            System.out.println(list.get(i).getText()+"\n"+info.get(i));

                }
            }


    @AfterMethod
    public void teardown(){
          driver.quit();
    }
}
