package com.cybertek.tests.SoftSkill;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lulia {

    /*
    User should be able to click Export Grid dropdown
     */

    String url = "https://qa2.vytrack.com/";
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test(priority = 1)
    public void ExGrid() throws InterruptedException {
        WebElement User = driver.findElement(By.id("prependedInput"));
        User.sendKeys("user16" + Keys.ENTER);
        WebElement Password = driver.findElement(By.id("prependedInput2"));
        Password.sendKeys("UserUser123" + Keys.ENTER);
        WebElement FleetField = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"));
        FleetField.click();

        Actions action = new Actions(driver);
        WebElement vehicle = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span"));
        action.moveToElement(vehicle).perform();
        vehicle.click();
        Thread.sleep(5000);

        WebElement ExportGrid = driver.findElement(By.xpath("//a[@href='#']/i[@class='fa-upload']"));
        Thread.sleep(5000);
        ExportGrid.click();

        Thread.sleep(5000);
        Assert.assertTrue(ExportGrid.isEnabled());

        //<a href="#" class="action
        //         btn
        //
        //        mode-text-only
        //         dropdown-toggle
        //    " title="With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported." data-toggle="dropdown">
        //
        //
        //        <i class="fa-upload"></i>
        //        Export Grid
        //
        //
        //    <i class="caret"></i>
        //</a>=

    }
}