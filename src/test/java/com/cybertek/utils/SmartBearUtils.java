package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearUtils {

 public static void loginToSmartBear(WebDriver driver){
//"http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
//
//5
     //<input name="ctl00$MainContent$username" type="text" id="ctl00_MainContent_username" class="txt" style="width:142px">
     WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
     //<input name="ctl00$MainContent$password" type="password" id="ctl00_MainContent_password" class="txt" style="width:142px">
     WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
     //<input type="submit" name="ctl00$MainContent$login_button" value="Login" id="ctl00_MainContent_login_button" class="button">
     WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));

     userName.sendKeys("Tester");
     password.sendKeys("test");
     loginBtn.click();

     Assert.assertEquals(driver.getTitle(),"Web Orders","Failed to login to smartbear app");
 }
 public  static void addProduct(WebDriver driver){

     /**
      * TODO: add selenium steps for adding the a new order
      */




 }


}
