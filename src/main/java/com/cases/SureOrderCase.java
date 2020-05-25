package com.cases;

import com.base.TestCaseBase;
import com.handle.CourseHandle;
import com.handle.LoginHandle;
import com.handle.SureOrderHandle;
import com.listeners.TestNgListenerScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 *
 * Created by gaoxl on 2020/5/15.
 */
@Listeners({TestNgListenerScreen.class})
public class SureOrderCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(SureOrderCase.class);
    private SureOrderHandle handle;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String brower) throws InterruptedException {
        driver = getDriver(brower);
        driver.get("https://coding.imooc.com/class/436.html");
        Thread.sleep(3000);
        handle = new SureOrderHandle(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    /**
     * 登录成功后获取价格，和点击提交订单
     * @throws InterruptedException
     */
    @Test
    public void testcase1() throws InterruptedException{
        log.info("-------SureOrderCase-------testcase1--------------");
        handle.setCookie();
        driver.get("https://order.imooc.com/pay/confirm?goods_ids=1989");
        String title = handle.getTitle();
        boolean result = title.contains("确认订单_慕课网");
        Assert.assertTrue(result);
        handle.clickOrderSubmit();
        Thread.sleep(1000);
    }

    /**
     * 未登录逇情况下
     * @throws InterruptedException
     */
    @Test
    public void testcase2() throws InterruptedException {
        log.info("----------SureOrderCase----testcase2--------------");
        driver.get("https://order.imooc.com/pay/confirm?goods_ids=1989");
        String title = handle.getTitle();
        boolean result = title.contains("慕课网-登录");
        Assert.assertTrue(result);
        Thread.sleep(3000);
    }


    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
