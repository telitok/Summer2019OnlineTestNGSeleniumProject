package tests.day3;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;

public class NavigationPractice {

        public static void main(String[] args) {
            //create a webdriver object, to work with a browser
            WebDriver driver = BrowserFactory.getDriver("chrome");
            //to maximize browser window
            driver.manage().window().maximize();
            driver.get("http://google.com");
            //wait for 3 seconds
            //this is out custom method
            //since method is static, we use class name to call the method
            //as a parameter, we provide number of seconds(time in seconds)
            BrowserUtils.wait(3);
            //HOW TO PRINT PAGE TITLE??
            System.out.println(driver.getTitle());

            driver.navigate().to("http://amazon.com");

            //navigate back to google (previous URL)
            driver.navigate().back();

            //move forward to the amazon again
            driver.navigate().forward();

            //to refresh/reload a webpage/website
            driver.navigate().refresh();
            //shutdown browser
            driver.quit();
            // if there is only one tab open, close() will be enough
            // what will happen if I call driver again after quit()
           // driver.get("http://google.com");  ==> it gives error on th console after running it  "exit code 1"
        }
}
