package com.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * base基类
 * Created by gaoxl on 2020/5/18.
 */
public class TestCaseBase{

    private static Logger log = Logger.getLogger(TestCaseBase.class);
    public WebDriver driver;

    public WebDriver getDriver(String brower){
        String sysPath = System.getProperty("user.dir");
        String path = sysPath + "\\drivers";
        log.info("--------打开浏览器-------：" + brower + ";路径地址："+path);
        if("chrome".equals(brower)){
            System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
            System.setProperty("webdriver.chrome.bin",path + "\\chrome.exe");
            driver = new ChromeDriver();
        } else if("ie".equals(brower)){
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer64.exe");
            driver = new InternetExplorerDriver();
        } else if ("firefox".equals(brower)){
            System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox46\\firefox.exe");
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
