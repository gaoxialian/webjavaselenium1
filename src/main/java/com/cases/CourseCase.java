package com.cases;

import com.base.TestCaseBase;
import com.handle.CourseHandle;
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
public class CourseCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(CourseCase.class);
    private LoginHandle loginHandle;
    private CourseHandle handle;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(@Optional("firefox") String brower) throws InterruptedException {
        driver = getDriver(brower);
        driver.get("https://coding.imooc.com/class/436.html");
        Thread.sleep(3000);
        loginHandle = new LoginHandle(driver);
        handle = new CourseHandle(driver);
        loginHandle.login("15050193776","gao13773081116");
    }

    @BeforeMethod
    public void beforeMethod(){
//        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();
    }

    @Test
    public void testcase1() throws InterruptedException{
        log.info("-------CourseCase-------testcase1--------------");
        int beforeNum = handle.getCartNum();
        log.info("购物车中有数量before："+beforeNum);
        Thread.sleep(1000);
        handle.clickAddCart();
        Thread.sleep(1000);
        int afterNum = handle.getCartNum();
        log.info("购物车中有数量after："+afterNum);
        int result = afterNum - beforeNum;
        log.info("购物车中有数量："+result);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testcase2() throws InterruptedException {
        log.info("----------CourseCase----testcase2--------------");
        Thread.sleep(5000);
        String title = "(毕设项目)前端后端一体化Vue+Go 企业级微服务网关项目";
        String currentTitle = handle.getTitle();
        log.info(currentTitle);
        boolean flag = currentTitle.contains(title);
        Thread.sleep(5000);
        Assert.assertTrue(flag);
    }

    @Test
    public void testcase3() throws InterruptedException {
        log.info("---------add cookie------------------");
        Thread.sleep(1000);
        handle.addCookie();
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
