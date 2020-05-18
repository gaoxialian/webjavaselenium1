package com.handle;

import com.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/17.
 */
public class HomeHandle {
    public HomePage homePage;
    public HomeHandle(WebDriver driver){
        homePage = new HomePage(driver);
    }

    public List<String> getCourseNames(){
        List<String> courseNames = new ArrayList<String>();
        List<WebElement> eles =  homePage.getCourseName();
        for(int i =0;i < eles.size(); i++){
            courseNames.add(eles.get(i).getText());
        }
        return courseNames;
    }

}
