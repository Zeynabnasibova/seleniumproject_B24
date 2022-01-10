package com.cybertek.tests.day16_download_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDownloadTest  extends TestBase {

@Test
    public void fileDownloadTest() throws IOException {
//navigate to download page. Reading url from properties file
    driver.get(ConfigurationReader.getPproperty("dowonload.url"));
    //locate and click on some-file.txt to download
//<a href="download/some-file.txt">some-file.txt</a>
    WebElement someFileDowonload = driver.findElement(By.linkText("some-file.txt"));
    someFileDowonload.click();


    BrowserUtils.sleep(2);

//verify that file is download:

    String filePath = System.getProperty("user.home") + "/Downloads/some-file.txt";
    System.out.println("filePath = " + filePath);

    File file = new File( filePath );
    System.out.println("File exist = " + file.exists());

    Assert.assertTrue(file.exists(), "File download");


    // Creating an object of BufferedReader class
    BufferedReader br = new BufferedReader(new FileReader(file));

    // Declaring a string variable
    String st;
    // Consition holds true till
    // there is character in a string
    while ((st = br.readLine()) != null)

        // Print the string
        System.out.println(st);
    //delete after verification complete
    file.delete();
}

}
