package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.ConfigurationReader;
import Utils.Driver;

import java.util.concurrent.TimeUnit;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {
    @BeforeMethod
    public void setup(){
        String url=ConfigurationReader.getProperty("url");
        Driver.get().get(url);

    }
    @AfterMethod
    public void teardown(){
        Driver.close(); }
}