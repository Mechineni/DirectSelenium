package PageObject.ActiveQuotePackage;

import GenericLib.AlertHandle;
import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.SizeOfTheElement;
import static GenericLib.ActionKeywords.clickOnElement;
import static GenericLib.DataDriven.*;

/**
 * Created by Mamata.Mechineni on 18-May-17.
 */
public class CatalogPage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By ItemsListActiveQuote = By.xpath("//td/input[@id='ln_sid']");
    static private By CatalogOnQuotePage = By.xpath("//td[@id='BottomRow']/a[contains(text(),'Catalog')]");
    static private By CatalogsList = By.xpath("//tbody/tr[1]/td/table/tbody/tr/td/b/li/a");
    //---Search Results page
    static private By ProductNarrowSearch = By.id("NarrowKeyword");
    static private By ProductNarrowSearchButton = By.xpath("//input[@value='Search'][@class='SubmitButton']");
    static private By ConfigureButton = By.xpath("//input[@value='Configure'][@class='SubmitButton']");
    static private By DetailsButton = By.xpath("//input[@value='Details'][@class='SubmitButton']");
    //---Product Spec Page
    static private By DoneButton = By.id("Done");
    static private By MaintenanceServiceDDw = By.id("ServiceID0");
    static private By NumberOfMonths = By.id("ServiceItemQty0");
    static private By ServiceLevelAgreement = By.id("ServiceItemID0");
    static private By AddToCartButton = By.id("ADDCART");

    public static void AddProductsToQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that new quote page opened or not?");
        if (SizeOfTheElement(driver, ItemsListActiveQuote) > 0) {
            ActualLable("Opened an active quote", "Fail");
        }else {
            ActualLable("Opened new quote", "Pass");
            clickOnElement(driver, CatalogOnQuotePage,"Catalog link on Quote Page");
            Thread.sleep(10000);
            String CatalogPageTitle = GetPageTitle(driver);
            ExpectedLable("Verify that catalogs page opened or not?");
            if (CatalogPageTitle.contentEquals("Catalogs")) {
                ActualLable("catalogs page opened successfully ", "Pass");
                boolean status = false;
                ExpectedLable("Verify that Required catalog listed or not?");
                int NoOfResult = SizeOfTheElement(driver, CatalogsList);
                for (int i = 0; i <= NoOfResult - 1; i++) {
                    int index = i + 1;
                    if (GetMultipleElementList(driver, CatalogsList).get(i).getText().contentEquals(SearchColumnText("CatalogName"))) {
                        ActualLable("Required catalog listed in assigned catalogs ", "Pass");
                        status = true;
                        GetMultipleElementList(driver, CatalogsList).get(i).click();
                        break;
                    }
                }
                if (status == false) {
                    ActualLable(" Required catalog not available in assigned catalogs ", "Fail");
                }
                if (status == true) {
                    ExpectedLable("Verify that Required catalog narrow search section opened or not?");
                    Thread.sleep(5000);
                    if (SizeOfTheElement(driver, ProductNarrowSearch) > 0) {
                        ActualLable("product narrow search section opened successfully", "Pass");
                        sendInputData(driver, ProductNarrowSearch,SearchColumnText("MfrPart"),"Product Mfr Part number");
                        clickOnElement(driver, ProductNarrowSearchButton,"Product Search Button");
                        Thread.sleep(5000);
                        AlertHandle.acceptAlert(driver);
                        ExpectedLable("Verify product search results?");
                        if (SizeOfTheElement(driver, ConfigureButton) > 0) {
                            ActualLable("product narrow search displayed requested details", "Pass");
                            clickOnElement(driver, ConfigureButton,"Configure product details Button");
                            Thread.sleep(5000);
                            AlertHandle.acceptAlert(driver);
                            clickOnElement(driver, DoneButton,"Done button on ProductDetails");
                            Thread.sleep(40000);
                            clickOnElement(driver, AddToCartButton,"Add To Cart Button");
                        }else if(SizeOfTheElement(driver, DetailsButton) > 0) {
                            ActualLable("product narrow search displayed requested details", "Pass");
                            clickOnElement(driver, DetailsButton,"Product Details Button");
                            Thread.sleep(20000);
                            AlertHandle.acceptAlert(driver);
                            Thread.sleep(5000);
                            //For UMV Calculation
                            if(TestCaseNumber=="SC_004"){
                                if(SizeOfTheElement(driver,MaintenanceServiceDDw)>0){
                                    //UMV Contract name dropdown
                                    String UMVContractNumberStringExt = UMVContractNumberString+" - Automation";
                                    selectDropDownByVisibletxt(driver,MaintenanceServiceDDw, UMVContractNumberStringExt,"UMV Contract name");
                                    //Number Of Months dropdown
                                    Thread.sleep(3000);
                                    selectDropDownByVisibletxt(driver,NumberOfMonths,SearchColumnText("UMVNumberOfMonths"),"UMV Contract period");
                                    //SLA Name Dropdown
                                    Thread.sleep(3000);
                                    selectDropDown(driver,ServiceLevelAgreement).selectByIndex(0);
                                    ReportEvent("Pass", "Select SLA from Drop down", " Successfully selected ' SLA ', i.e"+SearchColumnText("NameOfSLA"));
                                }
                            }
                            clickOnElement(driver, AddToCartButton,"Add To Cart Button");
                        }else{{ActualLable("No product search results displayed", "Fail");}}
                        Thread.sleep(5000);
                        ExpectedLable("Verify product added to quote or not?");
                        if (SizeOfTheElement(driver, ItemsListActiveQuote) > 0) {
                            ActualLable("Product added to quote successfully", "Pass");
                        }else {ActualLable("Product not added to quote", "Fail");}
                    }else {ActualLable("Error in opening product narrow search section", "Fail");}
                }
            } else {
                ActualLable("Error in opening catalog page", "Fail");
            }
        }
    }
}
