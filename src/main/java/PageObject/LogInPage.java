package PageObject;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;


/**
 * Created by t.mirasipally on 13-Feb-17.
 */
public class LogInPage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By LoginIdField = By.id("Login");
    static private By EmailIdField = By.id("UserName");
    static private By PasswordField = By.id("Password");
    static private By LogInButton = By.xpath("//input[@value='Login'][@type='SUBMIT']");

    public static boolean VerifyLogInPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Direct Home page is opened or not ?");
        if(SizeOfTheElement(driver,LoginIdField)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("User Authentication")){
                Status=true;
                ActualLable("successfully verified Assert for Direct Home Page ","Pass");
            }else{ActualLable(" Assert verification failed for Direct Home Page ","Fail");}
        }else{ActualLable("Direct Home page is not Loaded Properly","Fail");}
        return Status;
    }


    public static void LogInFunctionality(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Log in to the application");
        obje.repository(driver);
        if(VerifyLogInPageAssert(driver)==true) {
            sendInputData(driver,EmailIdField,SearchColumnText("UserName"),"'User Name' field");
            sendInputData(driver,PasswordField,SearchColumnText("PassWord"),"PassWord field");
            Thread.sleep(1000);
            clickOnElement(driver,LogInButton,"LogIn Button");
        }else{ActualLable("Failed to load Landing page","Fail");}
    }


}
