package Assignments;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkForTestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void TestCase1() {

        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("input[placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");
        String actual = driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(actual, expected, "This is not correct");


    }

    @Test
    public void TestCase2() {
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        BrowserUtils.wait(2);
        List<WebElement> languages = driver.findElements(By.cssSelector("[class='form-check-label']"));
        for (WebElement each : languages) {
            each.isDisplayed();
            String lang = each.getText();
            System.out.println(lang);

        }
    }
    @Test
    public void TestCase3 (){
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("T");
        String actual = driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
        String expected = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected,"Failed");
    }
    @Test
    public void TestCase4(){
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("E");
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected,"Failed");
        System.out.println(actual);
    }
    @Test
    public void TestCase5(){
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Tooba");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Elitoch");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("telitoch");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("tooba@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("Tooba123");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("355-244-4567");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("02/11/1987");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name='department']")).click();
        driver.findElement(By.cssSelector("[value='DE']")).click();
        driver.findElement(By.cssSelector("[name='job_title']")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[10]/div/select/option[5]")).click();
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.xpath("//*[@class='alert alert-success']/p")).getText();
        String expected = "You've successfully completed registration!";
        Assert.assertEquals(actual,expected,"failed");
        System.out.println(actual);

    }
    @Test
    public void TestCase6(){
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(2);
        String email = driver.findElement(By.className("animace")).getText();
        driver.navigate().back();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[href='/sign_up']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("full_name")).sendKeys("Tooba");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='wooden_spoon']")).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.name("signup_message")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual, expected, "Not same message");
        driver.get(("https://www.tempmailaddress.com/"));
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id='schranka']/tr[1]")).click();
        BrowserUtils.wait(2);
        String actualsender = driver.findElement(By.id("odesilatel")).getText();
        String expectedsender = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualsender,expectedsender,"Sender is not same");
        String actualmessage = driver.findElement(By.id("predmet")).getText();
        String expectedmessage = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualmessage,expectedmessage,"Message is not same");

    }
    @Test
    public void TestCase7(){
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
    @Test
    public void TestCase8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("[id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@id=\"myCountryautocomplete-list\"]/div")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[type='button']")).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.cssSelector("[id='result']")).getText();
        String expected = "You selected: United States of America";
        Assert.assertEquals(actual,expected,"Wrong message");
    }
}
