package tests.day14;

import Utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void test1(){
        String expectedBrowser = "chrome";
        // we write keys in "key" as  a string
        // as return you will get value
        // key = value
        // property name = value
        // we don't change property names, we change values
        // the idea is change in the one place and affect entire framework
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);

        //read value of url property
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        // read value of username property
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        String password = ConfigurationReader.getProperty("password");
        System.out.println("Password: "+password);
    }
}
