package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class EdmundsCarDetailsPage extends BasePage {

    @FindBy(xpath = "//span[@class='d-inline-block']")
    public WebElement msrpRange; //price range

    public String getMsrpRangeValue() {
        return msrpRange.getText();
    }

    @Override
    public void isCurrentPage() {
        assertTrue(driver.getTitle().contains("Prices, Reviews, and Pictures | Edmunds"));
    }
}