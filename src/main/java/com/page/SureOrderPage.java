package com.page;

import com.base.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * loginpage
 * page
 * Created by gaoxl on 2020/5/15.
 */
public class SureOrderPage extends Base {
    private static Logger log = Logger.getLogger(SureOrderPage.class);
    public SureOrderPage(WebDriver driver){
        super(driver);
    }

    public static By PaySubmit = By.className("js-pay-submit");
    public static By PayPrice = By.id("js-pay-price");

    public WebElement getSureOrderBtn(){
        log.info("获取SureOrderPage 的确认订单按钮元素");
        WebElement ele = getElement(PaySubmit);
        return ele;
    }

    public WebElement getPayPrice(){
        log.info("获取SureOrderPage 的价格元素");
        WebElement ele = getElement(PayPrice);
        return ele;
    }

}
