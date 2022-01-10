package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

/**
 * add new package day19_page_object_model
 *
 * add new class DragAndDropTest
 *
 * @Test
 * public void guru99DragAndDropTest() {
 *
 * }
 */

@Test
    public void guru99DragAndDropTest() {
    driver.get(ConfigurationReader.getPproperty("draganddrop.url"));
    //<a class="button button-orange" style="color:#FFFFFF;"> BANK </a>
    WebElement bank  = driver.findElement(By.linkText("BANK"));

    //<ol align="center" class="field14 ui-droppable ui-sortable" id="bank" style="list-style:none">
    //
    //										<li data-id="5">
    //				 BANK </li></ol>

    WebElement accountType = driver.findElement(By.id("bank"));

    actions.dragAndDrop(bank, accountType).perform();

    WebElement fiveK = driver.findElement(By.linkText("5000"));
    WebElement bankAmount = driver.findElement(By.id("amt7"));

    //actions.dragAndDropBy(fiveK, 793, 826).perform();
    actions.dragAndDrop(fiveK , bankAmount).perform();
    BrowserUtils.sleep(2);

}

    @Test
    public void cargurusPriceSliderTest() {
        driver.get(ConfigurationReader.getPproperty("cargurus.url")+"/Cars/inventorylisting/viewDetailsFilterViewInventoryListing.action?sourceContext=carGurusHomePageModel&entitySelectingHelper.selectedEntity=d177&zip=22102");

        WebElement priceSlider = driver.findElement(By.xpath("(//button[@aria-valuemin='3000'])[1]"));
//
//        actions.clickAndHold(priceSlider)
//                .sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT,
//                        Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT)
//                .release().build().perform();


        //        int x = priceSlider.getLocation().getX();
//        int y = priceSlider.getLocation().getY();
//
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//
      actions.dragAndDropBy(priceSlider, 100,0).perform();
        BrowserUtils.sleep(2);
    }


}
