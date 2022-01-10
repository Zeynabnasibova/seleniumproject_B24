package com.cybertek.tests.day22_explicitwait_review;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {
    @BeforeMethod
    public void gotoHomePage() {
        driver.get(ConfigurationReader.getPproperty("chercher.url"));
    }

    @Test
    public void waitForAlertTest() {
        WebElement openAlertBtn = driver.findElement(By.id("alert"));
        openAlertBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());

        //org.openqa.selenium.NoAlertPresentException: no such alert
        //driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void waitForButtonEnabledTest() {
        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("cher cher button enabled = " + button.isEnabled()); //false

        //click on Enable button
        WebElement enableBtn = driver.findElement(By.id("enable-button"));
        enableBtn.click();

        //wait until the button is enabled
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("cher cher button enabled = " + button.isEnabled());
    }

    @Test
    public void waitForCheckBoxIsCheckedTest() {
        WebElement checkbox = driver.findElement(By.id("ch"));
        System.out.println("checkbox is checked = " + checkbox.isSelected());

        WebElement enableCheckBoxBtn = driver.findElement(By.id("checkbox"));
        enableCheckBoxBtn.click();

        //wait until checkbox is selected
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));

        System.out.println("checkbox is checked = " + checkbox.isSelected());
    }

}