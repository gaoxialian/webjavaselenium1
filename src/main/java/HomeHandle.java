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

    /**
     * 获取case名称
     * @return
     */
    public List<String> getCourseNamesValue(){
        List<String> courseNames = new ArrayList<String>();
        List<WebElement> eles =  getCourseNames();
        for(int i =0;i < eles.size(); i++){
            courseNames.add(eles.get(i).getText());
        }
        return courseNames;
    }

    public List<WebElement> getCourseNames(){
        List<WebElement> eles =  homePage.getCourseName();
        return eles;
    }

    /**
     * 获取page list
     * 页面上
     */
    public List<Integer> getPageList(){
        List<Integer> pageList = new ArrayList<Integer>();
        List<WebElement> eles =  homePage.getPageIndex();
        for (WebElement ele:eles) {
            String text = ele.getText();
            if(homePage.isNum(text)){
                pageList.add(Integer.parseInt(text));
            }
        }
        return pageList;
    }

}
