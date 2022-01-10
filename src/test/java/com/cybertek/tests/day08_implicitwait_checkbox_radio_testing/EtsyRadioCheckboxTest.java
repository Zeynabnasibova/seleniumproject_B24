package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckboxTest {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.etsy.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //Search for wooden spoon
        //<input id="global-enhancements-search-query" data-id="search-query" data-search-input="" type="text" name="search_query" class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7
        //                        " placeholder="Search for anything" value="" autocomplete="off" autocorrect="off" autocapitalize="off">
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        //click on All filters
        //<button id="search-filter-button" class="wt-btn wt-btn--small wt-btn--secondary wt-display-flex-xs wt-align-items-center" aria-controls="search-filters-overlay">
        //        <span class="etsy-icon wt-icon--smaller-xs"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true" focusable="false"><path d="M5,7.6h5.7c0.4,1.2,1.5,2,2.8,2s2.4-0.8,2.8-2H19c0.6,0,1-0.4,1-1s-0.4-1-1-1h-2.7c-0.4-1.2-1.5-2-2.8-2s-2.4,0.8-2.8,2H5 c-0.6,0-1,0.4-1,1S4.4,7.6,5,7.6z M13.5,5.6c0.6,0,1,0.4,1,1s-0.4,1-1,1s-1-0.4-1-1S12.9,5.6,13.5,5.6z"></path><path d="M19,11.1h-7.7c-0.4-1.2-1.5-2-2.8-2s-2.4,0.8-2.8,2H5c-0.6,0-1,0.4-1,1c0,0.6,0.4,1,1,1h0.7c0.4,1.2,1.5,2,2.8,2 s2.4-0.8,2.8-2H19c0.6,0,1-0.4,1-1C20,11.5,19.6,11.1,19,11.1z M8.5,13.1c-0.6,0-1-0.4-1-1c0-0.6,0.4-1,1-1s1,0.4,1,1 C9.5,12.7,9.1,13.1,8.5,13.1z"></path><path d="M19,16.6h-1.2c-0.4-1.2-1.5-2-2.8-2s-2.4,0.8-2.8,2H5c-0.6,0-1,0.4-1,1s0.4,1,1,1h7.2c0.4,1.2,1.5,2,2.8,2s2.4-0.8,2.8-2 H19c0.6,0,1-0.4,1-1S19.6,16.6,19,16.6z M15,18.6c-0.6,0-1-0.4-1-1s0.4-1,1-1s1,0.4,1,1S15.6,18.6,15,18.6z"></path></svg></span>
        //        <span class="wt-hide-xs wt-show-md filter-expander">All Filters</span>
        //    </button>
        WebElement allFilters = driver.findElement(By.id("search-filter-button"));
        allFilters.click();

        //select Free shipping, on sale, under $25 > click on Apply
        //<label for="special-offers-free-shipping" class="wt-checkbox__label wt-display-inline">
        //            FREE shipping
        //        </label>

        WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();

        //<label for="edd-4-radio-input" class="wt-radio__label wt-display-inline">
        //        By Nov 18
        //    </label>
        WebElement onSale = driver.findElement(By.xpath("//label[@for='edd-4-radio-input']"));
        onSale.click();

        //<label for="price-input-1" class="wt-radio__label wt-display-inline">
        //        Under $25
        //    </label>
        WebElement under$25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under$25.click();

        //<button class="wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3" type="submit" form="search-filter-form" aria-label="Apply" data-wt-overlay-close="">
        //        Apply
        //    </button>

        WebElement apply = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        apply.click();

        Thread.sleep(2000);

        WebElement resultsCount = driver.findElement(By.xpath("(//span[contains(text(),'results')])"));
        System.out.println("Results = " + resultsCount.getText());

        driver.quit();



    }
}
/*
Launch Browser and goto etsy homepage
search for wooden spoon
click on filters
Select free shipping, on sale
select under $25
Click on apply filters
Print count of results

You do not have permission to send messages in this channel.

 */