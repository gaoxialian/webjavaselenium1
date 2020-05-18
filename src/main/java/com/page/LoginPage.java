package com.page;

import com.base.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

/**
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class LoginPage extends Base {
    private static Logger log = Logger.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public static By loginBtn = By.id("js-signin-btn");
    public static By email = By.name("email");
    public static By pwd = By.name("password");
    public static By button = By.cssSelector("[value=\"登录\"]");
    // 登录成功之后，在首页上查看是否登录成功
    public static By userPng = By.id("header-avator");
    public static By userInfo = By.className("text-ellipsis");

    public WebElement getHomeLoginBtn(){
        log.info("获取homepage 的登录按钮元素");
        WebElement ele = getElement(loginBtn);
        return ele;
    }

    public WebElement getEmail(){
        log.info("获取登录页面email元素");
        WebElement ele = getElement(email);
        return ele;
    }

    public WebElement getPwd(){
        log.info("获取登录页面pwd元素");
        WebElement ele = getElement(pwd);
        return ele;
    }

    public WebElement getLoginBtn(){
        log.info("获取登录按钮元素");
        WebElement ele = getElement(button);
        return ele;
    }

    public WebElement getLoginUserPng(){
        log.info("获取登录用户图标");
        WebElement ele = getElement(userPng);
        return ele;
    }

    public WebElement getUserInfo(){
        log.info("获取登录用户登录信息");
        WebElement ele = getElement(userInfo);
        return ele;
    }
}
