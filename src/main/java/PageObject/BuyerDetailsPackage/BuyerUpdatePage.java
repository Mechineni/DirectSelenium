package PageObject.BuyerDetailsPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class BuyerUpdatePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By BuyersPageName=By.xpath("//tr/td[@class='ListHeader']/b");
    static private By BuyerNameTxt=By.id("qbn");
    static private By BuyerNamesLink=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]/a");
    static private By BuyerEditBtn=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By BuyerAdminLink=By.xpath("//ul[@id='cssmenu1']/li[3]/a[contains(text(),'Buyer Admin')]");
    static private By BuyerLink=By.xpath("//ul[@id='cssmenu1']/li[3]/ul/li[1]/a[contains(text(),'Buyers')]");


    public static boolean VerifyBuyersPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        if (GetElementText(driver,BuyersPageName).contentEquals("BUYERS")) {
            String PageTitle = GetPageTitle(driver);
            System.out.print("Page tIle is :- "+PageTitle);
            if (PageTitle.contentEquals("Buyers")) {
                Status = true;
                ReportEvent("Pass","Verify Buyers page is opened or not ?","Buyers Page Opened successfully");
            } else {
                System.out.print("Page tIle is :- "+PageTitle);
                ReportEvent("Pass","Verify Buyers page is opened or not ?","Buyers Page Opened successfully");
                System.out.print("Page tIle is after:- "+PageTitle);
            }
        } else {

            ReportEvent("Fail","Verify Buyer Page", "Buyers page is not loaded Properly");
        }
        return Status;
    }

    public static void BuyerSearch(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Search for the required buyer on BUYER search page");
        //---Navigate to Buyer Admin > Buyer
        Thread.sleep(2000);
        clickOnElement(driver,BuyerAdminLink);
        clickOnElement(driver,BuyerLink);
        Thread.sleep(2000);
        //---If buyers search page is opened then search for the buyer name
        if(VerifyBuyersPageAssert(driver)==true) {
            if(SizeOfTheElement(driver,BuyerNameTxt) > 0){
                sendInputData(driver, BuyerNameTxt).sendKeys(SearchColumnText("BuyerName"));
                ReportEvent("Pass","Verify Buyer Name text box existance","Buyer name text box displayed on the buyers page");
                sendInputData(driver, BuyerNameTxt).sendKeys(SearchColumnText("BuyerName"));
            }
            driver.findElement(By.id("SUBMIT1")).click();
            ExpectedLable("Verify that Buyers search success or not?");
            if (SizeOfTheElement(driver, BuyerNamesLink) > 0) {
                ReportEvent("Pass","BuyerNAme link on Search reulsts page","BuyerName link found on Search results page");
                boolean status = false;
                int NoOfResult = SizeOfTheElement(driver, BuyerNamesLink);
                for (int i = 0; i <= NoOfResult-1; i++) {
                    int index=i+1;
                    if (GetMultipleElementList(driver, BuyerNamesLink).get(i).getText().contentEquals(SearchColumnText("buyerName"))) {
                        ActualLable("successfully searched provided buyer ", "Pass");
                        status = true;
                        GetMultipleElementList(driver, BuyerEditBtn).get(i).click();
                        Thread.sleep(2000);
                        ExpectedLable("Verify that Buyer details update page opened successfully or not?");
                        String PageTitle = GetPageTitle(driver);
                        if (PageTitle.contentEquals("Update")){ ActualLable("Buyer details update page opened successfully ","Pass");
                        }else { ActualLable(" Assert verification failed for Buyers details update Page ", "Fail");
                        }
                        break;
                    }
                }
                if (status == false) {  ActualLable(" Buyer search not returned required results ", "Fail");  }
            } else {   ActualLable(" Buyer search not returned required results ", "Fail");  }
        }
    }



}
