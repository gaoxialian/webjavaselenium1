package com.handle;

import com.base.BaseHandle;
import com.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录handle
 * Created by Administrator on 2020/5/17.
 */
public class HomeHandle extends BaseHandle {
    public HomePage homePage;
    public HomeHandle(WebDriver driver){
        super(driver);
        homePage = new HomePage(driver);
    }

    public List<String> getCourseNames(){
        List<String> courseNames = new ArrayList<String>();
        List<WebElement> eles =  homePage.getCourseName();
        for(int i = 0;i < eles.size(); i++){
            courseNames.add(eles.get(i).getText());
        }
        return courseNames;
    }

}
