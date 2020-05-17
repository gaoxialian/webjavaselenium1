import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class HomePage extends Base {

    public HomePage(WebDriver driver){
        super(driver);
    }
    // 首页的课程一栏
    public static By courseName = By.className("course-card-name");
    // 分页
    public static By page = By.className("page");
    // 分页下的a标签元素
    public static By pageIndexs = By.tagName("a");

    public List<WebElement> getCourseName(){
        List<WebElement> ele = getElements(courseName);
        return ele;
    }

    public WebElement getPage(){
        WebElement ele = getElement(page);
        return ele;
    }

    public List<WebElement> getPageIndex(){
        List<WebElement> eles = getPage().findElements(pageIndexs);
        return eles;
    }

}
