package com.cybertek.tests.practice_day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class URLPractice {



        public static void main(String [] args) throws InterruptedException {


            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String url = "http://google.com";
            driver.get(url);
//<input id="gbqfbb" value="I'm Feeling Lucky" aria-label="I'm Feeling Lucky" name="btnI" type="submit" data-ved="0ahUKEwiD187viqX0AhUYUd4KHQhEBl4QnRsIDg">
            WebElement btn1 = driver.findElement(By.id("gbqfbb"));
            btn1.click();
            //  Thread.sleep(1000);

            //<input id="gbqfbb" value="I'm Feeling Lucky" aria-label="I'm Feeling Lucky" name="btnI" type="submit" data-ved="0ahUKEwjarNbWi6X0AhW5yosBHf9pDWoQnRsIDg">
            System.out.println();
            String actualTxt = btn1.getAttribute("value");
            String expectedText = "I'm Feeling Lucky";

            if (actualTxt.equals(expectedText)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
                System.out.println("Expected text: " + expectedText);
                System.out.println("Actual text: " + actualTxt);
                driver.quit();
            }
        }
}
