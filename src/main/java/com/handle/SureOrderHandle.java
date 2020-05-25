package com.handle;

import com.base.BaseHandle;
import com.page.LoginPage;
import com.page.SureOrderPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 *
 * Created by Administrator on 2020/5/17.
 */
public class SureOrderHandle extends BaseHandle {
    public SureOrderPage sureOrderPage;
    private static Logger log = Logger.getLogger(SureOrderHandle.class);
    public SureOrderHandle(WebDriver driver){
        super(driver);
        sureOrderPage = new SureOrderPage(driver);
    }

    public String getPayPriceTxt(){
        log.info("获取价格");
        String price = getText(sureOrderPage.getPayPrice());
        return price;
    }

    public void clickOrderSubmit(){
        clickElement(sureOrderPage.getSureOrderBtn());
    }

}
