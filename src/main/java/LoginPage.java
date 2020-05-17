import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;

/**
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class LoginPage extends Base {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public static By loginBtn = By.id("js-signin-btn");
    public static By email = By.name("email");
    public static By pwd = By.name("password");
    public static By button = By.cssSelector("[value=\"登录\"]");

    public WebElement getHomeLoginBtn(){
        WebElement ele = getElement(loginBtn);
        return ele;
    }

    public WebElement getEmail(){
        WebElement ele = getElement(email);
        return ele;
    }

    public WebElement getPwd(){
        WebElement ele = getElement(pwd);
        return ele;
    }

    public WebElement getLoginBtn(){
        WebElement ele = getElement(button);
        return ele;
    }


}
