package PageObject.BuyerDetailsPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    static private By BuyerSearchGoBtn=By.id("SUBMIT1");
    static private By BuyerNamesLink=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]/a");
    static private By BuyerEditBtn=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By BuyerAdminLink=By.xpath("//ul[@id='cssmenu1']/li[3]/a[contains(text(),'Buyer Admin')]");
    static private By BuyerLink=By.xpath("//ul[@id='cssmenu1']/li[3]/ul/li[1]/a[contains(text(),'Buyers')]");
    //OtherHyperlinks
    static private By CustomerCatalogAndPricingLink=By.xpath("//a[contains(text(),'Customer Catalogs and Pricing')]");
    static private By MaintenanceServicesSetUp=By.xpath("//a[contains(text(),'Maintenance Services Set Up')]");



    public static boolean VerifyBuyersPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        if (GetElementText(driver,BuyersPageName).contentEquals("BUYERS")) {
            String PageTitle = GetPageTitle(driver);
            System.out.print("Page tIle is :- "+PageTitle);
            if (PageTitle.contentEquals("Buyers")) {
                Status = true;
                ReportEvent("Pass","Verify Buyers page is opened or not ?","Buyers Page Opened successfully");
            } else {
                ReportEvent("Pass","Verify Buyers page is opened or not ?","Buyers Page Opened successfully");
            }
        } else {
            ReportEvent("Fail","Verify Buyer Page", "Buyers page is not loaded Properly");
        }
        return Status;
    }

    public static void BuyerSearchAndEdit(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Search for the required buyer on BUYER search page");
        //---Navigate to Buyer Admin > Buyer
        Thread.sleep(2000);
        clickOnElement(driver,BuyerAdminLink);
        clickOnElement(driver,BuyerLink);
        Thread.sleep(2000);
        //---If buyers search page is opened then search for the buyer name
        if(VerifyBuyersPageAssert(driver)==true) {
            if(SizeOfTheElement(driver,BuyerNameTxt) > 0){
                ReportEvent("Pass","Verify Buyer Name text box existance","Buyer name text box displayed on the buyers page");
                sendInputData(driver, BuyerNameTxt).sendKeys(SearchColumnText("BuyerName"));
                clickOnElement(driver,BuyerSearchGoBtn);
            }
            Thread.sleep(1000);
            //---Verify buyer name link on search results page
            if (SizeOfTheElement(driver, BuyerNamesLink) > 0) {
                ReportEvent("Pass","Verify BuyerName link on Search results page","BuyerName link found on Search results page");
                boolean status = false;
                int NoOfResult = SizeOfTheElement(driver, BuyerNamesLink);
                for (int i = 0; i <= NoOfResult-1; i++) {
                    //---Click on edit button link for expected buyer name
                    if (GetMultipleElementList(driver, BuyerNamesLink).get(i).getText().contentEquals(SearchColumnText("BuyerName"))) {
                        ReportEvent("Pass","Verify Buyer on Search results page","Buyer Name found on Search results page");
                        status = true;
                        GetMultipleElementList(driver, BuyerEditBtn).get(i).click();
                        Thread.sleep(2000);
                        String PageTitle = GetPageTitle(driver);
                        if (PageTitle.contentEquals("Update")){
                            ReportEvent("Pass","Verify Buyer details update page","Buyer details update page opened successfully");
                        }else {
                            ReportEvent("Fail","Verify Buyer details update page","Buyer details update page opened successfully");
                        }
                        break;
                    }else {
                        ReportEvent("Fail","Edit Buyer Name on search results","Not abl eto click on buyer name edit button ");
                    }
                }
            } else {
                ReportEvent("Fail","Verify Buyer Search","Buyer search not returned required results ");
            }
        }
    }

    public static boolean ClickOnCustomerCatalogAndPricingLink(WebDriver driver) throws IOException, WriteException {
        StepLable("Navigate to Customer and Catalog Pricing page");
        boolean Status = false;
        if(SizeOfTheElement(driver,CustomerCatalogAndPricingLink)>0) {
            ReportEvent("Pass", "Verify existance of Customer Catalog And Pricing Link", "Customer Catalog And Pricing Link is available on Buyer details page");
            //---Click on Customer Catalog And Pricing Link
            clickOnElement(driver, CustomerCatalogAndPricingLink);
            //---Verify that Customer Catalog and Pricing page opened
            String CustomerCatalogPageTitle = GetPageTitle(driver);
            if (CustomerCatalogPageTitle.contentEquals("Customer Catalogs and Pricing")) {
                ReportEvent("Pass", "Verify that Customer Catalog and Pricing page opened", "Customer Catalog and Pricing page opened successfully ");
                Status = true;
            }else {
                ReportEvent("Pass", "Verify that Customer Catalog and Pricing page opened", "Customer Catalog and Pricing page opened successfully ");
            }
        }
        return Status;
    }

    public static boolean ClickOnMaintenanceServicesSetUpLink(WebDriver driver) throws IOException, WriteException, InterruptedException {
        StepLable("Navigate to Maintenance Services Set Up page");
        boolean Status = false;
        if(SizeOfTheElement(driver,MaintenanceServicesSetUp)>0) {
            ReportEvent("Pass", "Verify existence of Maintenance Services Set Up Link", "Maintenance Services Set Up Link is available on Buyer details page");
            //---Click on Customer Catalog And Pricing Link
            clickOnElement(driver, MaintenanceServicesSetUp);
            Thread.sleep(2000);
            String MaintenanceServicesSetUpPageTitle = GetPageTitle(driver);
            if (MaintenanceServicesSetUpPageTitle.contentEquals("Maintenance Services Set Up")) {
                ReportEvent("Pass", "Verify that Maintenance Services Set Up page opened", "Maintenance Services Set Up page opened successfully ");
                Status = true;
            }else {
                ReportEvent("Fail", "Verify that Maintenance Services Set Up page opened", "Maintenance Services Set Up page not opened");
            }
        }else {
            ReportEvent("Fail", "Verify existence of Maintenance Services Set Up Link", "Maintenance Services Set Up link is not available on Buyer details page");
        }
        return Status;
    }

}
