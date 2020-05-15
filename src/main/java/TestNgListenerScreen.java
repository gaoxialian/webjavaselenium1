import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 监听器
 * Created by gaoxl on 2020/5/15.
 */
public class TestNgListenerScreen extends TestListenerAdapter {

    private static Logger log = org.apache.log4j.Logger.getLogger(LoginTest.class);

    @Override
    public void onTestFailure(ITestResult tr){
        log.info("-------onTestFailure-----");
//        System.out.print(tr.getInstance());
        LoginTest lt = (LoginTest)tr.getInstance();
        this.takeScreenShot(lt.driver);
        super.onTestFailure(tr);
    }

    /**
     * 自动截图
     */
    public void takeScreenShot(WebDriver driver){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String currTime = sf.format(new Date());
        // 获取当前类名
        String currClassName = this.getClass().getName();
        // 路径
        String currDir = System.getProperty("user.dir");
        String filePath = currDir + "\\screenshot\\" + currClassName + "_" + currTime + ".png";
        // 图片名称，图片路径
        File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scrFile, new File(filePath));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
