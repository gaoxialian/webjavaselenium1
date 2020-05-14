package com.test;

import com.po.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by gaoxl on 2020/5/14.
 */
public class LoginTest {

    /**
     *
     * @param driver
     * @param email
     * @param pwd
     */
    public static void  loginPo(WebDriver driver, String email, String pwd){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://mail.163.com/");
        driver.switchTo().frame(driver.findElement(LoginPage.frameSwitch));
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginBtn).click();
    }
    public static void main(String[] args){
//        LoginTest login = new LoginTest();
//        login.loginPo("111","222");
    }
}
