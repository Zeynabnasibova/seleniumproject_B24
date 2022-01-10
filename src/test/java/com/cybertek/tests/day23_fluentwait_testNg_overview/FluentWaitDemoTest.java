package com.cybertek.tests.day23_fluentwait_testNg_overview;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitDemoTest extends TestBase {

    @Test
    public void fluentWaitTest() {
        driver.get(ConfigurationReader.getPproperty("practice.base.url"));

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement header = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                //any custom conditions based on your situation can be added here
                return driver.findElement(By.className("h1y"));
            }
        });

        System.out.println(header.getText());


    }
}