package com.base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by gaoxl on 2020/5/25.
 */
public class BaseHandle {
    private WebDriver driver;
    public BaseHandle(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void setCookie(){
        String value = "MzYTA5MDRkYThkZmI5MTA1YjlmNjEzNmVlYjUyZTUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODk1MTcyMQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGJjZTYxYjg4ODI2YWIwMmI1Y2I2Nzc5YTE2OGI3MmY0jzvDXo87w14%3DZD";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    public void deleteCookie(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public void clickElement(WebElement ele){
        ele.click();
    }

    public String getText(WebElement ele){
        return ele.getText();
    }
}
