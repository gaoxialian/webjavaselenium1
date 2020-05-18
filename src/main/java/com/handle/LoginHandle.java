package com.handle;

import com.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2020/5/17.
 */
public class LoginHandle {
    public LoginPage loginPage;
    private static Logger log = Logger.getLogger(LoginHandle.class);
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void clickHomeLoginBtn(){
        log.info("点击home页面的登录按钮");
        loginPage.getHomeLoginBtn().click();
    }

    public void sendEmail(String email){
        log.info("输入email：" + email);
        loginPage.getEmail().sendKeys(email);
    }

    public void sendPwd(String pwd){
        log.info("输入pwd："+pwd);
        loginPage.getPwd().sendKeys(pwd);
    }

    public void clickLoginBtn(){
        loginPage.getLoginBtn().click();
    }



}
