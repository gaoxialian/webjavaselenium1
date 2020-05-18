package com.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * base基类
 * Created by gaoxl on 2020/5/18.
 */
public class TestCaseBase{

    private static Logger log = Logger.getLogger(TestCaseBase.class);
    public WebDriver driver;

    public WebDriver getDriver(String brower){
        PropertyConfigurator.configure("log4j.properties");
        log.info("--------打开浏览器-------");
        if("chrome".equals(brower)){
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
