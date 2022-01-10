package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {

    public static void main(String[] args) throws InterruptedException {

String appUrl = "https://www.calculator.net";
int num1 = 5;
int num2 = 3;
int expectedResult = 8;

        WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        /**
         4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
         objects
         */

        //<span onclick="r(5)" class="scinm">5</span>
        // CSS --> span[onclick='r(5)']
        WebElement num1Element = driver.findElement(By.cssSelector("span[onclick='r(5)']"));

        //<span onclick="r(3)" class="scinm">3</span>
        WebElement num2Element  = driver.findElement(By.cssSelector("span[onclick='r(3)']"));

        //<span onclick="r('+')" class="sciop">+</span>
        WebElement addElement = driver.findElement(By.xpath("//span[.='+']"));

        //<span onclick="r('=')" class="scieq">=</span>
        WebElement equalElement = driver.findElement(By.xpath("//span[text()='=']"));

        //5+3=
        num1Element.click();
        Thread.sleep(1234);
        addElement.click();
        Thread.sleep(1234);
        num2Element.click();
        Thread.sleep(1234);
        equalElement.click();
        Thread.sleep(1234);

// 6) Locate result area and store into webElement object
//<div id="sciOutPut">&nbsp;8</div>
        WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']"));//#sciOutPut

        System.out.println(num1 + " + " + num2 + " = " + result.getText());

        String resultValue = result.getText();
        // get rid//remove of right/ left spaces
        resultValue = resultValue.trim();
        //convert from String to int
        int actualResult = Integer.parseInt(resultValue);

        if(actualResult == expectedResult){

            System.out.println("Pass: calculation match");

        }else {

            System.out.println("Fail:calculation mismatch ");
        }

        driver.quit();
        //driver.close();

    }

}


/**
 CALCULATOR AUTOMATION TASK:
 Try to use CSS or Xpath for this task.
 You are writing an automation test to verify if the calculator is working as expected.
 1) Add a class CalculatorAddTest
 2) Declare variables String appUrl = “https://www.calculator.net”
 int num1 = 5, num2 = 3
 int expectedResult = 8
 3) Launch selenium, maximize and navigate to the url

 4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
 objects
 5) Click the elements in right order as you would do normally,
 Add Thread.sleep(1234) in between steps to slow it down a little - not needed if you
 have a cheap computer like mine :)
 6) Locate result area and store into webElement object
 7) Read the text of the result element, remove any unneeded characters and convert
 into int. int expectedResult = Integer.parseInt(result);
 8) Using if statement compare actualResult and the expectedResult . print pass or fail
 accordingly.
 9) Quit selenium and go home

 */