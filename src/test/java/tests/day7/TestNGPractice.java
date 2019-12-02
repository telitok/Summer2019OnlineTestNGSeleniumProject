package tests.day7;


import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

    @Test
    public void test() {
        // to verify that expected and actual result is the same
        // if no - it will throw exception and stop the program
        // also, you will see in the console what was expected
        // and what was actual
        // press and hold command button and use left click to open Assert class
        // then on the right top side click on "Download resources"
        Assert.assertEquals("apple", "apple");

        /* before
        if (str.equals(str2)){
        System.out.println("Passed");
        }else{
        System.out.println("Failed");
         }
         */
    }

    @Test (description = "Verifying the title of the practice website")
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
        driver.quit();
    }
    @Test (description = "Verify that Heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // if there is no element with this locator, we will get NoSuchElement exception
        // and test will stop on the findElement line
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        // to make sure that element is visible to user
        // because element can be present but not visible
        // we need to make sure element is visible
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();
    }
}
