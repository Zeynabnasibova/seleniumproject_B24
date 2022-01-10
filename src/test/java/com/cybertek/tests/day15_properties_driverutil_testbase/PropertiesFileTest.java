package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.utils.ConfigurationReader;
import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileTest {
    @Test
    public void readValuesFromPropertiesFile() throws Exception {
        //Properties class
        Properties props = new Properties();

        //open file using FileInputStream
        FileInputStream fis = new FileInputStream("configuration.properties");

        //load file content into FileInputStream object
        props.load(fis);

        System.out.println(props.getProperty("browser"));
        System.out.println(props.getProperty("webtableUrl"));
        System.out.println(props.getProperty("env"));
    }

    @Test
    public void configurationReaderUnitTest(){

        System.out.println(ConfigurationReader.getPproperty("browser"));
        String url = ConfigurationReader.getPproperty("webtableUrl");
        System.out.println("url = " + url);

        Assert.assertEquals(ConfigurationReader.getPproperty("browser"), "chrome");
        Assert.assertEquals(ConfigurationReader.getPproperty("env") , "qa");

        Assert.assertEquals(ConfigurationReader.getPproperty("hello"), null);
    }
}
