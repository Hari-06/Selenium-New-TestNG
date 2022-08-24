package com.testCase;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Map;

public class BaseTest {


    protected BaseTest() {
    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get("Browser"));
    }


    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
