package Assignments;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class HW4_VytrackCalendarEvents {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement tobeselected;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement loaderMask= null;

        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @Test (description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1(){
        // for the hover over action
        Actions action = new Actions(driver);
        WebElement threedots = driver.findElement(By.xpath("//tr[15]//td[9]"));
        action.moveToElement(threedots).perform();
        BrowserUtils.wait(2);
        // put View, Delete, Edit in an ArrayList
        List<WebElement> list = driver.findElements(By.xpath("//tr[15]//td[9]//div//div//ul//li//ul//li"));
        // verify that those three items are displayed
        for (WebElement each : list) {
            Assert.assertTrue(each.isDisplayed());
        }

    }
    @Test (description = "Verify that “Title” column still displayed")
    public void test2(){
        WebElement gridsettings= driver.findElement(By.cssSelector("[title='Grid Settings']"));
        gridsettings.click();
       List<WebElement> list = driver.findElements(By.xpath("//table[@class='grid table-hover table table-condensed']//tbody//tr"));
        for (int i=2;i<=list.size();i++){
            WebElement each = driver.findElement(By.xpath("//table[@class='grid table-hover table table-condensed']//tbody//tr["+i+"]//td[1]"));
            each.click();
        }
        BrowserUtils.wait(2);
        WebElement onlytitle = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//thead//th[2]//a//span[1]"));
        System.out.println(onlytitle.getText());
        System.out.println(onlytitle.isDisplayed());
    }
    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3(){
        // find Create Calendar Event element and click on it.
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // Find the arrow to expand the menu and click on it
        driver.findElement(By.cssSelector("[class='btn-success btn dropdown-toggle']")).click();
       List<WebElement> list = driver.findElements(By.xpath("//*[@class='btn-group pull-right open']//ul//li"));
       for(WebElement each : list){
           System.out.println(each.getText());
           Assert.assertTrue(each.isDisplayed());

       }

    }
    @Test (description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find and click on cancel button
        driver.findElement(By.xpath("//*[@class='pull-left btn-group icons-holder']//a")).click();
        BrowserUtils.wait(3);
        // make sure "All Calendar Events" title is displayed as expected
        String headline = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(headline,"All Calendar Events");
        System.out.println(driver.findElement(By.className("oro-subtitle")).isDisplayed());

    }
    @Test (description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // locate the start time input box and click
       WebElement start= driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        start.click();
        BrowserUtils.wait(2);
        // pick a random time, so the end time will be start time+1 hour, in this case I picked 9:00 PM
       driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper']/ul/li[43]")).click();
       BrowserUtils.wait(3);
       // Click at a random spot to allow the end time to be updated so our locator can get the correct end time
        // In this case, I clicked on the whole End time row
       driver.findElement(By.cssSelector("[class='control-group end control-group-datetime']")).click();
       BrowserUtils.wait(2);
       // get the text of endtime box and see if it is 1 hor more than the picked-start time
       String actualEnd = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).getAttribute("value");
      Assert.assertEquals(actualEnd,"10:00 PM");
        System.out.println(actualEnd);
    }

    @Test( description = "Verify that end time is equals to “10:00 PM")
    public void test6(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // click on the start time
        driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']")).click();
        // find 9 pm and click on it
        WebElement start = driver.findElement(By.xpath("//*[@class='ui-timepicker-wrapper']//ul//li[43]"));
        start.click();
        BrowserUtils.wait(3);
        // Click at a random spot to allow the end time to be updated so our locator can get the correct end time
        // In this case, I clicked on the whole End time row
        driver.findElement(By.cssSelector("[class='control-group end control-group-datetime']")).click();
        BrowserUtils.wait(2);
        // get the text of endtime box and see if it is 10:00 PM
        String actualEnd = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).getAttribute("value");
        Assert.assertEquals(actualEnd,"10:00 PM");
        System.out.println(actualEnd);
        }

    @Test(description = "Verify that start and end date input boxes are displayed")
    public void test7(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find and click on the all day checkbox
        WebElement alldaycheckbox = driver.findElement(By.cssSelector("[name='oro_calendar_event_form[allDay]']"));
        alldaycheckbox.click();
        // verify that all day checkbox is selected
        System.out.println(alldaycheckbox.isSelected());
        BrowserUtils.wait(2);
        // verify that start time is not displayed
        System.out.println(!driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']")).isDisplayed());
        // verify that end time is not displayed
        System.out.println(!driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).isDisplayed());
        // verify that start date is displayed
        System.out.println(driver.findElement(By.cssSelector("[class='input-small datepicker-input start hasDatepicker']")).isDisplayed());
        // verify that end date is displayed
        System.out.println(driver.findElement(By.cssSelector("[class='input-small datepicker-input end hasDatepicker']")).isDisplayed());

    }
    @Test(description = "Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down")
    public void test8(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find "Repeat" option
        WebElement Repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        // click repeat option
        Repeat.click();
        // verify that repeat option is selected
        System.out.println(Repeat.isSelected());
        // make sure that "Daily" is selected by default
        System.out.println(driver.findElement(By.xpath("//*[@data-name='recurrence-repeats']//option[1]")).isSelected());

        List<WebElement> repeatsmenu = driver.findElements(By.xpath("//*[@data-name='recurrence-repeats']//option"));
        List<String> menu = new ArrayList<>(Arrays.asList("Daily", "Weekly","Monthly", "Yearly"));
        for(int i=0;i<=repeatsmenu.size()-1;i++){
            String actual = driver.findElements(By.xpath("//*[@data-name='recurrence-repeats']//option")).get(i).getText();
            System.out.println(actual);
            Assert.assertEquals(actual,menu.get(i),"not same");
        }
    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day”")
    public void test9(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find "Repeat" option
        WebElement Repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        // click repeat option to select
        Repeat.click();
        // verify that repeat option is selected
       Assert.assertTrue(Repeat.isSelected());
       // create a web element for "Repeat Every"
       WebElement repeatevery=driver.findElement(By.xpath("//label[@class='fields-row']//input[@checked='checked']"));
       // verify that “Repeat Every” radio button is selected
       Assert.assertTrue(repeatevery.isSelected());
       // create a webelement for "never" option
       WebElement never = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']//div[6]//div[1]//div[2]//div[1]//label//input"));
       // Verify that “Never” radio button is selected as an “Ends” option
       Assert.assertTrue(never.isSelected());
       // create a web element for "Summary:" part
       String summary = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[1]//label")).getText();
       // create a web element for "Daily every 1 day" part
       String dailypart = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span")).getText();
       // concatenate summary and dailypart to get ""Summary: Daily every 1 day"
       String actual = summary+" "+dailypart;
        String expected ="Summary: Daily every 1 day";
        // Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
       Assert.assertEquals(actual,expected);
    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”")
    public void test10(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find "Repeat" option
        WebElement Repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        // click repeat option to select
        Repeat.click();
        // verify that repeat checkbox is selected
        Assert.assertTrue(Repeat.isSelected());
        // find Ends option and After element and click
        WebElement after = driver.findElement(By.xpath("//div[@data-name='control-sections']//div[2]//label[@class='fields-row']//input[1]"));
        after.click();
        // verify that After is selected
        Assert.assertTrue(after.isSelected());
        driver.findElement(By.xpath("//label[@data-role='control-section-switcher']//input[2][@type='text']")).sendKeys("10");
        // click on the Summary info part to update the line after entering 10
        driver.findElement(By.cssSelector("[class='control-group recurrence-summary alert-info']")).click();
        // create a web element for "Summary:" part
        String summary = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[1]//label")).getText();
        // create a web element for "Daily every 1 day" part
        String dailypart1 = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span")).getText();
        // create a web element for end after 10 occurrences
        String dailypart2 = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span[2]")).getText();
        // concatenate summary, dailypart1, and dailypart2 to get "Summary: Daily every 1 day, end after 10 occurrences"
        String actual = summary+" "+dailypart1+dailypart2;
        String expected ="Summary: Daily every 1 day, end after 10 occurrences";
        // Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”
        Assert.assertEquals(actual,expected);
    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”")
    public void test11(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find "Repeat" option
        WebElement Repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        // click repeat option to select
        Repeat.click();
        // verify that repeat checkbox is selected
        Assert.assertTrue(Repeat.isSelected());
        // select "By" option
        driver.findElement(By.xpath("//div[@data-name='control-sections']//div[3]//label//input")).click();
        // find the date box and enter the date
        driver.findElement(By.xpath("//div[@data-name='control-sections']//div[3]//span//div//input[2]")).sendKeys("Nov 18, 2021");
        // create a web element for "Summary:" part
        String summary = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[1]//label")).getText();
        // create a web element for "Daily every 1 day" part
        String dailypart1 = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span[1]")).getText();
        // create a web element for "end by Nov 18, 2021" part
        String dailypart2 = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span[2]")).getText();
        // concatenate summary, dailypart1, and dailypart2 to get "Summary: Daily every 1 day, end by Nov 18, 2021"
        String actual = summary+" "+dailypart1+dailypart2;
        String expected ="Summary: Daily every 1 day, end by Nov 18, 2021";
        // Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
        Assert.assertEquals(actual,expected);
    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”")
    public void test12(){
        // click on "Create Calendar Event" button
        driver.findElement(By.xpath("//*[@class='btn-group']//a[@href='/calendar/event/create']")).click();
        BrowserUtils.wait(3);
        // find "Repeat" option
        WebElement Repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        // click repeat option to select
        Repeat.click();
        // verify that repeat checkbox is selected
        Assert.assertTrue(Repeat.isSelected());
        // Select "Weekly" on the Repeats dropdown menu
        Select RepeatsDropdown = new Select(driver.findElement(By.className("recurrence-repeats__select")));
        //                                   This is the locator for Repeats dropdown menu to select "Weekly"
        RepeatsDropdown.selectByVisibleText("Weekly");
        BrowserUtils.wait(3);
        //Select Monday
        WebElement Monday = driver.findElement(By.xpath("//div[@class='multi-checkbox-control']//label[2]//input"));
        Monday.click();
        // Select Friday
        WebElement Friday = driver.findElement(By.xpath("//div[@class='multi-checkbox-control']//label[6]//input"));
        Friday.click();
        BrowserUtils.wait(3);
        // Verify that Monday and Friday options are selected
        Assert.assertTrue(Monday.isSelected());
        Assert.assertTrue(Friday.isSelected());
        BrowserUtils.wait(3);
        // create a web element for "Summary:" part
        String summary = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[1]//label")).getText();
        // create a web element for "Weekly every 1 week on Monday, Friday" part
        String dailypart = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']//div[2]//div//span")).getText();
        // concatenate summary and dailypart to get ""Summary: Daily every 1 day"
        String actual = summary+" "+dailypart;
        String expected ="Summary: Weekly every 1 week on Monday, Friday";
        // Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”
        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    public void teardown(){

        driver.quit();
    }

}
