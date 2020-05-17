import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2020/5/17.
 */
public class LoginHandle {
    public LoginPage loginPage;
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void clickHomeLoginBtn(){
        loginPage.getHomeLoginBtn().click();
    }

    public void sendEmail(String email){
        loginPage.getEmail().sendKeys(email);
    }

    public void sendPwd(String pwd){
        loginPage.getPwd().sendKeys(pwd);
    }

    public void clickLoginBtn(){
        loginPage.getLoginBtn().click();
    }



}
