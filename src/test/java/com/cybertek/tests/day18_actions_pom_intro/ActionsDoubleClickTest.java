package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ActionsDoubleClickTest extends TestBase {
    /**
     * Add new class ActionsDoubleClickTest
     * @Test
     * public void doubleClickForColorChange() {
     *
     * }
     *
     * doubleclick.url=https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
     */
    @Test
    public void doubleClickForColorChange() {
        driver.get(ConfigurationReader.getPproperty("doubleclick.url"));
        //switch to iframe
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.id("demo"));

        System.out.println("text.getText() = " + text.getText());

        //double click to see color change
        //new Actions(driver).doubleClick(text).perform();
        actions.doubleClick(text).perform();

        //<p id="demo" ondblclick="myFunction()" style="color: red;">Double-click me to change my text color.</p>
        System.out.println("style of text = " + text.getAttribute("style"));

        assertTrue(text.getAttribute("style").contains("red"));
        //switch back out from frame
        driver.switchTo().defaultContent();

    }
}