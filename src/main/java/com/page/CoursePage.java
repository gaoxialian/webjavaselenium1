package com.page;

import com.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class CoursePage extends Base {
    public CoursePage(WebDriver driver){
        super(driver);
    }

    // 加购物车
    public static By addCart = By.cssSelector(".course-infos-top .js-addcart");
    // 购物车数量
    public static By cartNum = By.className("js-cart-num");

    public WebElement getAddCart(){
        WebElement ele = getElement(addCart);
        return ele;
    }

    public WebElement getCartNum(){
        WebElement ele = getElement(cartNum);
        return ele;
    }



}
