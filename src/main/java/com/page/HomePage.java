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
public class HomePage extends Base {
    public HomePage(WebDriver driver){
        super(driver);
    }

    public static By courseName = By.className("course-card-name");

    public List<WebElement> getCourseName(){
        List<WebElement> ele = getElements(courseName);
        return ele;
    }

}
