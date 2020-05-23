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
 * logincase
 * Created by gaoxl on 2020/5/15.
 */
@Listeners({TestNgListenerScreen.class})
public class LoginCase extends TestCaseBase {
    private static Logger log = Logger.getLogger(LoginCase.class);
    private LoginHandle handle;
    public WebDriver driver;

    @Parameters({"brower"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String brower){
        driver = getDriver(brower);
        driver.get("https://www.imooc.com/");
        handle = new LoginHandle(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
//        driver.navigate().refresh();
    }

    // [Hm_lpvt_f0cfcccd7b1393990c78efdeebff3968=1590111475; path=/; domain=.imooc.com,
    // imooc_uuid=a34d2405-1886-481c-b76b-833b8674dffa; expires=星期六, 22 五月 2021 09:37:52 CST; path=/;
    // domain=.imooc.com, sajssdk_2015_cross_new_user=1; expires=星期五, 22 五月 2020 11:59:59 CST; path=/; domain=.imooc.com,
    // apsid=MzYTA5MDRkYThkZmI5MTA1YjlmNjEzNmVlYjUyZTUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODk1MTcyMQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADc3MmI5ZTg3NTJhMGIwYjNjYmE0MDQyYzgwZjFjZmNi8SzHXvEsx14%3DZD; expires=星期五, 29 五月 2020 09:37:53 CST; path=/; domain=.imooc.com, IMCDNS=0; expires=星期六, 23 五月 2020 09:37:54 CST; path=/; domain=.imooc.com, imooc_isnew=1; expires=星期六, 22 五月 2021 09:37:52 CST; path=/; domain=.imooc.com, loginstate=1; expires=星期五, 29 五月 2020 09:37:53 CST; path=/; domain=.imooc.com, Hm_lvt_f0cfcccd7b1393990c78efdeebff3968=1590111472; expires=星期六, 22 五月 2021 09:37:55 CST; path=/; domain=.imooc.com, sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%228951721%22%2C%22first_id%22%3A%221723a0787f8802-0e3e08b6d2dd1c-b791b36-2073600-1723a0787f9b68%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%221723a0787f8802-0e3e08b6d2dd1c-b791b36-2073600-1723a0787f9b68%22%7D; expires=星期二, 04 四月 2220 09:37:54 CST; path=/; domain=.imooc.com, cvde=5ec72cf010acf-3; path=/; domain=.imooc.com, imooc_isnew_ct=1590111472; expires=星期六, 22 五月 2021 09:37:52 CST; path=/; domain=.imooc.com]
    @Test
    public void testcase1() throws InterruptedException{
        log.info("-------LoginCase-------testcase1--------------");
        ProUtils pro = new ProUtils("element.properties");
        String result = pro.getPro("username");
        String user = result.split(">")[0];
        String pwd = result.split(">")[1];
        handle.login("15050193775","gao13773081116");
        Assert.assertEquals("慕姐7020064", handle.getUserText());
        log.info("------cookie-------:"+driver.manage().getCookies());
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
