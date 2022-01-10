package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {

    public static void main(String[] args) {

        //set up the driver for the browser type using WebDriver  manager
        WebDriverManager.chromedriver().setup();

        // launch Selenium webdriver chrome browser
        WebDriver driver = new ChromeDriver();

        //maximize browser
        driver.manage().window().maximize();


        // - navigate to https://www.calculator.net/
        String url = "https://www.calculator.net/";

        driver.get(url);


        // - Click on Percentage Calculator
        driver.findElement(By.linkText("Percentage Calculator")).click();

        //Verify current title is "Percentage Calculator"
        String expectedTitle = "Percentage Calculator";

        String actualTitle = driver.getTitle();

        System.out.println("Curent title + " + driver.getTitle());

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS: Title verification successuful");
        }else{

            System.out.println("FAIL: Title verification failed");
        }

        //Enter 20%

        driver.findElement(By.name("cpar1")).sendKeys("20");

        //Enter 120000 and click enter (using Keys.ENTER)

        driver.findElement(By.id("cpar2")).sendKeys("120000");

        // - Print the result "Result: 24000"

        driver.findElement(By.name("cpar3")).sendKeys(Keys.ENTER);

        //locate the result and assign to variable then print
        String result = driver.findElement(By.className("h2result")).getText();
        System.out.println("result = " + result);

// "Result: 24000"
        if(result.endsWith("24000")){
            System.out.println("PASS: calculation is correct");
        }else{
            System.out.println("FAIL: calculation is incorrect");
        }
        //- close browser
        driver.quit();
        /*
        Add a package day04_locators_getattribute

Add a class PercentageCalculatorTest

Main method:
    - launch browser, maximize
    - navigate to https://www.calculator.net/
    - Click on Percentage Calculator
    - Verify current title is "Percentage Calculator"
    - Enter 20% of 120000 and click enter (using Keys.ENTER)
    - Print the result "Result: 24000"
    - close browser
         */


    }
}
