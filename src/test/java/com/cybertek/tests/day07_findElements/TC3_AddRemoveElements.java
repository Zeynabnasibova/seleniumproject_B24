package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC3_AddRemoveElements {

    public static void main(String[] args) {

        String url = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);


        //<button onclick="addElement()">Add Element</button>
        //--> //button[@onclick='addElement()']
        //locate and click addElement button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
      //  addElement.click();

        for(int i = 0; i < 50; i++){

            addElement.click();

        }

        //verify 50 delete buttons are on the page
        //<button class="added-manually" onclick="deleteElement()">Delete</button>
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("Count of delete Buttons = " + deleteButtons.size());
        if (deleteButtons.size() == 50) {
            System.out.println("PASS: 50 buttons added successfully");
        } else {
            System.out.println("FAIL: cannot add 50 buttons");
        }

        //click all delete buttons to remove them
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }

//ForEach method with lambda expression(->)
      //  deleteButtons.forEach(anyVarName -> anyVarName.click());

        //run findElement for delete buttons again and see if it is 0
        deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));

        //if(deleteButtons.size() == 0)
        if(deleteButtons.isEmpty()){

            System.out.println("PASS: All 50 buttons deleted successfully");
        }else{
            System.out.println("FAIL: Could not delete all 50 buttons");
        }
        driver.quit();
        driver.close();
    }
}
/**
 XPATH PRACTICES
 DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/add_remove_elements
 3. Click to “Add Element” button 50 times
 4. Verify 50 “Delete” button is displayed after clicking.
 5. Click to ALL “Delete” buttons to delete them.
 6. Verify “Delete” button is NOT displayed after clicking.
 USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 Hint: Need to use findElements method.
 */