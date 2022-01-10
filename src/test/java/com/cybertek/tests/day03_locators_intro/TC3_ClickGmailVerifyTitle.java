package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://www.google.com";

        driver.get(url);
//Find Gmail link and click on it

        //driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.partialLinkText("mail")).click();


// verify title contains / starts with Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Pass: gmail title verificatio seccessful");
        }else{
            System.out.println("Fail: gmail title verification failed");
        }
        //go back
        driver.navigate().back();

        String googleExpectedTitle = "Gmail";
        String googleActualTitle = driver.getTitle();

        if(googleActualTitle.equals(googleExpectedTitle)){

            System.out.println("Pass: gmail title verificatio passed");

        }else{

            System.out.println("Fail: gmail title verification failed");
        }

        driver.quit();
    }
}
