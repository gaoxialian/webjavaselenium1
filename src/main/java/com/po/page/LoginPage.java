package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by gaoxl on 2020/5/14.
 */
public class LoginPage {
    // iframe
    public static By frameSwitch = By.cssSelector("[frameborder=\"0\"]");
    // email
    public static By emailInput = By.name("email");
    // password
    public static By pwdInput = By.name("password");
    // 登陆按钮
    public static By loginBtn = By.id("dologin");
    // 去注册
    public static By registerBtn = By.id("changepage");
}
