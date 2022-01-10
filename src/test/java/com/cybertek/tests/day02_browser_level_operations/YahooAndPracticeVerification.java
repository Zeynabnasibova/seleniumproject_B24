package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooAndPracticeVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        String url = "https://ww.yahoo.com";
        WebDriver driver = new ChromeDriver();//open empty browser
        driver.get(url);

        String expectedTitle  = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS: title verification successful");
        }else{
            System.out.println("FAIL: title verification failed");
        }

       // if(driver.getTitle().equals("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"));

        driver.get("https://www.yahoo.com/");


        driver.quit();
    }

}
