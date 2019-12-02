package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    // runs automatically before each test
    @BeforeMethod
    public void setup(){
        // some code that will be running before every test, like: test 1, test 2, test 3,...
        // we can use use method with @BeforeMethod annotation
        System.out.println("Before method!");

    }
    // runs automatically after each test
    @AfterMethod
    public void teardown(){
        System.out.println("After method!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
}
