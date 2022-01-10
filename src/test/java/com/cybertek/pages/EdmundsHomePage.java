package com.cybertek.pages;
import static org.testng.Assert.*;

public class EdmundsHomePage extends BasePage {

    /**
     * Automatically added by compiler.
     *  no-args default constructor
     *  super() call to parent class no-args constructor
     public EdmundsHomePage() {
     super();
     }
     */
    @Override
    public void isCurrentPage() {
        assertEquals(driver.getTitle(), "New Cars, Used Cars, Car Reviews and Pricing | Edmunds");
    }
}