package tests;

import Utils.BrowserUtils;
import Utils.ConfigurationReader;
import Utils.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.IOException;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {
// * ExtentReports itself does not build any reports, but allows reporters to access information, which in
// * turn build the said reports. An example of building an HTML report and adding information to ExtentX:
// * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
// * ExtentXReporter extentx = new ExtentXReporter("localhost");

    protected ExtentReports extentReports;
    //    The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
    protected ExtentHtmlReporter extentHtmlReporter;
    //    Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){
        //location of report
        //it's gonna be next to target folder, test-output folder
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
        //system information
        extentReports.setSystemInfo("Environment", "QA1");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }


    @AfterTest
    public void afterTest(){
//         Writes test information from the started reporters to their output view
        extentReports.flush();
    }


    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    //ITestResult class describes the result of a test. (in TestNG)
    @AfterMethod
    public void teardown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                //BrowserUtils.getScreenshot(result.getName()) - takes screenshot and returns location of that screenshot
                //this method throws IOException (which is checked exception)
                //any checked exception must be handled
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                //print error info
                e.printStackTrace();
            }
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped : "+result.getName());
        }
        Driver.close();
    }


}