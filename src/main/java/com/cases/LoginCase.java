package com.cases;

import com.base.TestCaseBase;
import com.handle.LoginHandle;
import com.listeners.TestNgListenerScreen;
import com.utils.ProUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 *
 * Created by gaoxl on 2020/5/15.
 */
@Listeners({TestNgListenerScreen.class})
public class LoginCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(LoginCase.class);
    private LoginHandle handle;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(String brower){
        driver = getDriver(brower);
        driver.get("https://www.imooc.com/");
        handle = new LoginHandle(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
//        driver.navigate().refresh();
    }

    @Test
    public void testcase1() throws InterruptedException{
        log.info("-------LoginCase-------testcase1--------------");
        ProUtils pro = new ProUtils("element.properties");
        String result = pro.getPro("username");
        String user = result.split(">")[0];
        String pwd = result.split(">")[1];
        handle.clickHomeLoginBtn();
        handle.sendEmail(user);
        handle.sendPwd(pwd);
        handle.clickLoginBtn();
        Thread.sleep(3000);
    }

    @Test
    public void testcase2(){
        log.info("--------------testcase2--------------");
        Assert.assertTrue(true);
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
