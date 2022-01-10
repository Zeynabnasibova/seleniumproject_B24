package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ActionsDemoTest extends TestBase {
    /*
    add new class ActionsDemoTest

hover.url=http://practice.cybertekschool.com/hovers
     */
@Test
    public void  hoverElementTest() {
    driver.get(ConfigurationReader.getPproperty("hover.url"));
    //<img src="/img/avatar-blank.jpg" alt="User Avatar">
    WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));

    //create Actions class object to be able to hover image
    Actions actions = new Actions(driver);

    //hover over img1
    actions.moveToElement(img1).perform();
    BrowserUtils.sleep(1);

    WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
    actions.moveToElement(img2).perform();

    WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
    actions.moveToElement(img3).perform();
}
//replace above steps with the loop
    @Test
public void hoverOverGroupElements() {
        driver.get(ConfigurationReader.getPproperty("hover.url"));
        List<WebElement> image = driver.findElements(By.tagName("img"));
        for (WebElement img : image) {
            BrowserUtils.sleep(1);
            actions.moveToElement(img).perform();

        }
    }
    @Test
        public void googleFeelingLuckyBtnHoverTest() {

driver.get(ConfigurationReader.getPproperty("google.url"));
//locate 2 buttons
        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc']"));

}
}
