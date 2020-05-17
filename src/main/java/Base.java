import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * 基类
 * Created by gaoxl on 2020/5/15.
 */
public class Base {

    WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(By key){
        WebElement ele = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(key));
        return ele;
    }

    public List<WebElement> getElements(By key){
        List<WebElement> ele = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
        return ele;
    }

}
