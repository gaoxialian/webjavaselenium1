import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class LoginPage {

    public static By loginBtn = By.id("js-signin-btn");
    public static By email = By.name("email");
    public static By pwd = By.name("password");
    public static By button = By.cssSelector("[value=\"登录\"]");

}
