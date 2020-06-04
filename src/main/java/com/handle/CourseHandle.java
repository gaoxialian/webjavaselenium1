package com.handle;

import com.base.Base;
import com.base.BaseHandle;
import com.page.CoursePage;
import com.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * coursehandle
 * Created by Administrator on 2020/5/17.
 */
public class CourseHandle extends BaseHandle {

    private WebDriver driver;
    private CoursePage coursePage;
    private static Logger log = Logger.getLogger(CourseHandle.class);

    public CourseHandle(WebDriver driver){
        super(driver);
        coursePage = new CoursePage(driver);
        this.driver = driver;
    }
    public void clickAddCart(){
        coursePage.getAddCart().click();
    }

    /**
     * 获取购物车数量
     * @return
     */
    public int getCartNum(){
        int courseNum = 0;
        try {
            courseNum = Integer.parseInt(coursePage.getCartNum().getText());
        } catch (Exception e){
            courseNum = 0;
        }
        return courseNum;
    }

}
