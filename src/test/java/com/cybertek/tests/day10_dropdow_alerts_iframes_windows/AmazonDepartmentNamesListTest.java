package com.cybertek.tests.day10_dropdow_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AmazonDepartmentNamesListTest {

    String url = "https://www.amazon.com";
    WebDriver driver; //can use in every method

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void amazonDepartmentTest() throws InterruptedException {
        String expTitle = "Amazon.com. Spend less. Smile more.";
        assertEquals(driver.getTitle(), expTitle);

        //assert that "All" option is selected by default/automatically
        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectedOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "All Departments");

        List<WebElement> allDepartments = departments.getOptions();
        int countOfDepartments = allDepartments.size();
        System.out.println("countOfDepartments = " + countOfDepartments);
        assertTrue(countOfDepartments > 10, "Department names are missing");

        //loop and print all available options
        for (WebElement dept : allDepartments) {
            System.out.println(dept.getText());
        }
        System.out.println("==== USING FOREACH METHOD + LAMBDA EXPRESSION ===");
        allDepartments.forEach(dept -> System.out.println(dept.getText()));

        //select each item by order and wait 400 ms in between
        for(WebElement dept : allDepartments) {
            departments.selectByVisibleText(dept.getText());
            //Thread.sleep(400);
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(enabled = false) //skip this test
    public void testDemo() {
        System.out.println("testDemo is running");
    }

}
//before method annotation
    /*
    add new class AmazonDepartmentNamesListTest

add setUp method with @BeforeMethod annotation:
    launch selenium, maximize, set timeout, navigate to amazon

add @Test amazonDepartmentTest

assert Amazon home page is displayed
assert that "All" option is selected by default/automatically

get All available options and print out
     */