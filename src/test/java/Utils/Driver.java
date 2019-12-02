package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    private static WebDriver driver;

    // you cannot do like this, if constructor is private Driver obj = new Driver()
    private Driver(){

    }
    // if switch statment complains on string parameter
    // change Java compliler 7 plus, better if it is 8
    public static WebDriver get(){
        // if webdriver object was not created yet
        if(driver==null){
            // create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    // if browser type is wrong stop test and throw exception
                    // no browser will be open
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        return driver;
    }
    public static void close(){
        // if driver still exists
        if(driver != null) {
            // close all browsers
            driver.quit();
            // destroy driver object, ready for gc
            driver = null;
        }
    }
}
