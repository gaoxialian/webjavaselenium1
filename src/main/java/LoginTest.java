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


/**
 *
 * Created by gaoxl on 2020/5/15.
 */
@Listeners({TestNgListenerScreen.class})
public class LoginTest {
    private static Logger log = Logger.getLogger(LoginTest.class);
    private LoginHandle handle;
    public WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        PropertyConfigurator.configure("log4j.properties");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        driver.manage().window().maximize();
        handle = new LoginHandle(driver);
    }

    @BeforeTest
    public void beforeTest(){
//        driver.navigate().refresh();
    }

    @Test
    public void testcase1() throws InterruptedException{
        log.info("--------------testcase1--------------");
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

    public WebElement getElement(By key){
        WebElement ele = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(key));
        return ele;
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
