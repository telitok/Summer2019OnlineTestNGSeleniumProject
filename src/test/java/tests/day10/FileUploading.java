package tests.day10;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploading {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @Test (description = "Verify that file was uploaded")
    public void test(){
        driver.findElement(By.linkText("File Upload")).click();
        // provide path to the file
        // right clcik on the file, press option and hold on the keyboard
        // then you'll see and option says " Copy as Pathname
        driver.findElement(By.id("file-upload")).sendKeys("/Users/tugbaelitok/Desktop/tugba.docx");
        // click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "tugba.docx";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
