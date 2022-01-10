package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleUrlAndSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        String url = "https://ww.etsy.com";
        WebDriver driver = new ChromeDriver();//open empty browser
        driver.get(url);

        //read the title of the page and print out
        System.out.println("Title: " + driver.getTitle());
        //store the title into a variable
        String etssyTitle = driver.getTitle();
        System.out.println("etsyTitle = " + etssyTitle);//soutv

        //read the url of the curent page
        System.out.println("Curent url: " + driver.getCurrentUrl());

        //stotre the url into a String variable currentUrl
        String currentUrl = driver.getCurrentUrl();//conteyner
        System.out.println("currentUrl = " + currentUrl);

        //read page source and print it
        System.out.println("HTML page source: " +  driver.getPageSource());

        //store the source code into a variable then print the char count
        String html = driver.getPageSource();
        System.out.println("Count of html = " + html.length());

        //close the browser: driver.close() , driver.quit();
        driver.quit();






    }

}
