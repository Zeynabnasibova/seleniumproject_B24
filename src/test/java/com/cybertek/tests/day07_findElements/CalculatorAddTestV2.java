package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTestV2 {

    public static void main(String[] args) {


        String appUrl = "https://www.calculator.net";
        int num1 = 7;
        int num2 = 4;
        int expectedResult = num1 + num2;

        WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

       // System.out.println("Hello " + "\"my\"" + " friends");
        System.out.println("//span[.='" + num1 +"']");
//<span onclick="r(7)" class="scinm">7</span>
        WebElement num1Elem = driver.findElement(By.xpath("//span[.='" + num1 +"']"));

        //<span onclick="r(4)" class="scinm">4</span>
        WebElement num2Elem = driver.findElement(By.xpath("//span[.='"+num2+"']"));

        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));

        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));

        num1Elem.click();
        plus.click();
        num2Elem.click();
        equals.click();

        //<div id="sciOutPut">&nbsp;11</div>
        // WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']"));//#sciOutPut
        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        System.out.println("Result = " + result);







    }
}
