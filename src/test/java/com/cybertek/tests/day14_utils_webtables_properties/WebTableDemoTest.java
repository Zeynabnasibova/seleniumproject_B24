package com.cybertek.tests.day14_utils_webtables_properties;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
public class WebTableDemoTest {
    WebDriver driver;// default
    String url = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void readFromTableTest(){

        //Print table data as a single String,not so common, but useful sometimes
//<table id="table1" class="tablesorter">
//    <thead>
//      <tr>
//        <th class="header"><span>Last Name</span></th>
//        <th class="header"><span>First Name</span></th>
//        <th class="header"><span>Email</span></th>
//        <th class="header"><span>Due</span></th>
//        <th class="header"><span>Web Site</span></th>
//        <th class="header"><span>Action</span></th>
//      </tr>
//    </thead>
//    <tbody>
//      <tr>
//        <td>Smith</td>
//        <td>John</td>
//        <td>jsmith@gmail.com</td>
//        <td>$50.00</td>
//        <td>http://www.jsmith.com</td>
//        <td>
//          <a href="#edit">edit</a>
//          <a class="cell" href="#delete">delete</a>
//        </td>
//      </tr>
//      <tr>
//        <td>Bach</td>
//        <td>Frank</td>
//        <td>fbach@yahoo.com</td>
//        <td>$51.00</td>
//        <td>http://www.frank.com</td>
//        <td>
//          <a href="#edit">edit</a>
//          <a class="cell" href="#delete">delete</a>
//        </td>
//      </tr>
//      <tr>
//        <td>Doe</td>
//        <td>Jason</td>
//        <td>jdoe@hotmail.com</td>
//        <td>$100.00</td>
//        <td>http://www.jdoe.com</td>
//        <td>
//          <a href="#edit">edit</a>
//          <a class="cell" href="#delete">delete</a>
//        </td>
//      </tr>
//      <tr>
//        <td>Conway</td>
//        <td>Tim</td>
//        <td>tconway@earthlink.net</td>
//        <td>$50.00</td>
//        <td>http://www.timconway.com</td>
//        <td>
//          <a href="#edit">edit</a>
//          <a class="cell" href="#delete">delete</a>
//        </td>
//      </tr>
//    </tbody>
//  </table>

        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text = " + table1.getText());

        //verify  	tconway@earthlink.net is anywhere in the table
        assertTrue(table1.getText().contains("tconway@earthlink.net"));

        System.out.println();

        //print all column names in single line
        WebElement allCollName = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("Column names : " + allCollName.getText());


        //print each column name in separate lines using a loop and findElement
        List<WebElement>colNamesList =driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));


        for(WebElement colName : colNamesList ) {
            System.out.println("colName.getText() = " + allCollName.getText());
        }

        //print first col + firs cell data
        String xpathStr = "//table[@id='table1']/tbody/tr[1]/td[1]";
        WebElement firstRowCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println("firstRowCell.getText() = " + firstRowCell.getText());

        System.out.println("col 1, row 4 = " + getCellData(1,4));
        System.out.println("col 3, row 3 = " + getCellData(3,3));

    }

    @Test
    public void getAllColumnData(){
        //print all names
        //print all emails
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        System.out.println("----All First Names");

        for(int i = 0; i < names.size(); i++) {

            System.out.println(i + 1 + " - " + names.get(i).getText() +"\n" +(i+1) + " " +  emails.get(i).getText());
        }
        System.out.println("---- All Emails --- ");

        for(WebElement e : emails){

            System.out.println(e.getText());
        }

        }
    @Test
    public void printAllTableDataTest() {

        //get rows count and assign to  rowsCount variable and print it
  int rowscount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rowsCount = " + rowscount);

        for(int rowNums = 1; rowNums <= rowscount; rowNums++ ){
            for (int c = 1; c <= 6; c++){
                String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowNums+"]/td["+c+"]")).getText();
                System.out.println("value = " + value);

            }
        }

    }

    /**
     *

     */

    @Test
    public void readNeighborCell(){
        WebElement johnEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("John's email = " + johnEmail.getText());

        WebElement johnsLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("John's lastName =  " + johnsLastName.getText());



    }

        public String getCellData(int row, int col){

        String xpathStr = "//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";

        return driver.findElement(By.xpath(xpathStr)).getText();


    }




}
