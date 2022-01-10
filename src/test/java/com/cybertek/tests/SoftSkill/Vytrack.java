package com.cybertek.tests.SoftSkill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class Vytrack {


    WebDriver driver;
    String url = "https://qa2.vytrack.com/";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );
        driver.get(url);

    }

    @Test
    public void loginTest() throws InterruptedException {

//<input type="text" id="prependedInput" class="span2" name="_username" value="" required="required" placeholder="Username or Email" autofocus="">

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user16");
        Thread.sleep(1234);

        //<input type="password" id="prependedInput2" class="span2" name="_password" required="required" placeholder="Password" autocomplete="off">
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        Thread.sleep(1234);


        WebElement login = driver.findElement(By.id("_submit"));
        login.click();
        Thread.sleep(1234);


        //<a href="/account">List</a>
        WebElement goList = driver.findElement(By.linkText("List"));
        goList.click();
        Thread.sleep(5000);
//        WebElement accountList = driver.findElement(By.xpath("//*[@id='container']/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/ul/li/a"));
//        accountList.click();
//        Thread.sleep(1234);
//
        WebElement gridButton = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        gridButton.click();
        Thread.sleep(5000);

        //4.verify title contains:
        // Expected : Grid Setting
        //<div class="column-manager-title">Grid Settings</div>

        WebElement gridSettings = driver.findElement(By.xpath("//div[@class='column-manager-title']"));
        String actualGridSetting  = gridSettings.getText();
        String expectedGridSetting = "Grid Settings";
        if(actualGridSetting.equals(expectedGridSetting)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
/*
User Story
Grid Setting button is on the right of the page

Ac (TC)
1.Open Chrome browser
2.Go to https://qa2.vytrack.com/user/login
//https://docs.google.com/spreadsheets/d/1iUbBEvm9x36BvPFY1ve8lre8iB9vgtK0mQ9WmIatjeY/edit?usp=sharing

1.User on the FLEET MANAGEMENT page
2.Click to Grid Setting button is on the right of the page
3.verify Grid Setting button


 */