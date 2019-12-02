package tests.day12;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropPractice {

    @Test(description = "Drag and Drop example")
    public void test(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);
        actions.dragAndDrop(moon,earth).pause(200).build().perform();
        BrowserUtils.wait(3);

        driver.quit();

    }
}
