package tests.day14;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import Assignments.TestBase;
import Utils.BrowserUtils;
import Utils.ConfigurationReader;
import Utils.Driver;
public class LoginTest extends TestBase {
    @Ignore
    @Test
    public void test1(){
        //read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() --> will return webdriver object
        //and then we can call webdriver methods like get(), findElement()....
//        WebDriver driver = Driver.get();
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();
    }
    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}