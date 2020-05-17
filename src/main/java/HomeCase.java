import com.utils.ProUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2020/5/17.
 */
public class HomeCase {
    private static Logger log = Logger.getLogger(LoginTest.class);
    private LoginHandle handle;
    private HomeHandle handleHome;
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        PropertyConfigurator.configure("log4j.properties");
        log.info("----beforeClass----");
        driver = new ChromeDriver();
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
