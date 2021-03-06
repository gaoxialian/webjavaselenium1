package com.cases;

import com.base.TestCaseBase;
import com.handle.HomeHandle;
import com.handle.LoginHandle;
import com.listeners.TestNgListenerScreen;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.List;

/**
 *
 * Created by Administrator on 2020/5/17.
 */
@Listeners({TestNgListenerScreen.class})
public class HomeCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(HomeCase.class);
    private LoginHandle handle;
    private HomeHandle handleHome;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String brower) {
        log.info("----beforeClass----");
        driver = getDriver(brower);
        log.info("driver:"+driver);
        driver.get("https://www.imooc.com/course/list");
        driver.manage().window().maximize();
//        handle = new LoginHandle(driver);
        handleHome = new HomeHandle(driver);
    }

    @BeforeMethod
    public void beforeTest() {
        log.info("----beforeTest----");
        driver.navigate().refresh();
    }

    @Test
    public void testcase1() throws InterruptedException {
        log.info("--------------testcase1--------------");
        List<String> names = handleHome.getCourseNames();
        for (String name : names) {
            log.info(name);
        }
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void afterMethod() {
        log.info("----afterMethod----");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
