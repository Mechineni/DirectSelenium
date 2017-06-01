package GenericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class ActionKeywords {
    private static WebDriver driver;
    public static void navigateTo(WebDriver driver,String url){
        driver.navigate().to(url);
    }

    public static void clickOnElement(WebDriver driver,By object) {
        driver.findElement(object).click();
    }
    public static void ClearAField(WebDriver driver,By object) {
        driver.findElement(object).clear();
    }

    public static Select selectDropDown(WebDriver driver,By object){
        Select dropdown = new Select(driver.findElement(object));//WebDriver driver,
        return dropdown;
    }
    public static WebElement sendInputData(WebDriver driver,By object){
        WebElement elementNam = driver.findElement(object);
        return elementNam;
    }
    public static Select selectDropDownFromMultipleElements(WebDriver driver,By object,int i){
        Select dropdown = new Select(driver.findElements(object).get(i));//WebDriver driver,
        return dropdown;
    }
    public static void clickOnElementFromMultipleElements(WebDriver driver,By object,int i) {
        driver.findElements(object).get(i).click();
    }

    public static List<WebElement> GetMultipleElementList(WebDriver driver,By object){
        List<WebElement> NoOfElements = driver.findElements(object);
        return NoOfElements;
    }
    public static int SizeOfTheElement(WebDriver driver,By object){
        int NoOfElements = driver.findElements(object).size();
        return NoOfElements;
    }
    public static String GetPageTitle(WebDriver driver) {
        String PageTitle=driver.getTitle();
        return PageTitle;
    }
    public static void MouseHoverActionPerform(WebDriver driver,By object1,By object2) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(object1);
        WebElement we2 = driver.findElement(object2);
        action.moveToElement(we).moveToElement(we2).click().build().perform();
    }

    public static String GetElementText(WebDriver driver,By object) {
        String ElementText=driver.findElement(object).getText();
        return ElementText;
    }
    public static void MouseHoverPerform(WebDriver driver,By object1) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(object1);
        action.moveToElement(we).build().perform();
    }
    public static WebElement GetElement(WebDriver driver,By object) {
        WebElement element = driver.findElement(object);
        return element;
    }
}
