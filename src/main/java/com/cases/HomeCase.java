package com.cases;

import com.base.TestCaseBase;
import com.handle.HomeHandle;
import com.handle.LoginHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

/**
 *
 * Created by Administrator on 2020/5/17.
 */
public class HomeCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(HomeCase.class);
    private LoginHandle handle;
    private HomeHandle handleHome;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String brower){
        PropertyConfigurator.configure("log4j.properties");
        log.info("----beforeClass----");
        driver = getDriver(brower);
        driver.get("https://www.imooc.com/course/list");
        driver.manage().window().maximize();
//        handle = new LoginHandle(driver);
        handleHome = new HomeHandle(driver);
    }

    @BeforeMethod
    public void beforeTest(){
        log.info("----beforeTest----");
        driver.navigate().refresh();
    }

    @Test
    public void testcase1() throws InterruptedException{
        log.info("--------------testcase1--------------");
        List<String> names = handleHome.getCourseNames();
        for(String name:names){
            log.info(name);
        }
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod(){
        log.info("----afterMethod----");
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
