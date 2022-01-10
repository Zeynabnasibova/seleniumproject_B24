package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LibraryLoginPOMTest extends TestBase {

    /**
     add new class LibraryLoginPOMTest in day19 package

     library.url=https://library3.cybertekschool.com/login.html

     add new method:
     @Test
     public void invalidCredentialsTest() {
     driver.get(ConfigurationReader.getProperty("library.url"));

     }
     */
    @Test
    public void invalidCredentialsTest() {
        driver.get(ConfigurationReader.getPproperty("library.url"));
        //create object of LibraryLoginPage page object class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //access email WebElement and type the email
        loginPage.email.sendKeys("invalid_email@gmail.com");
        loginPage.password.sendKeys("randompwd12");
        loginPage.signInBtn.click();

        //WebElement errorMsg = driver.findElement(By.className("alert alert-danger")); Not Needed
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }

    @Test
    public void positiveLoginTest() {
        driver.get(ConfigurationReader.getPproperty("library.url"));

        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys(ConfigurationReader.getPproperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getPproperty("library3.student.password"));
        loginPage.signInBtn.click();

        //Book management page steps: verify is correct page, verify label is displayed

        BookManagementPage bookManagementPage = new BookManagementPage();
        assertTrue(bookManagementPage.bookMangtHeader.isDisplayed());
        bookManagementPage.isCurrentPage();



    }


}

