package PageObject.ActiveQuotePackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.ActionKeywords.clickOnElementFromMultipleElements;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;
import static GenericLib.DataDriven.SearchColumnText;

/**
 * Created by Mamata.Mechineni on 31-May-17.
 */
public class ActiveQuoteActionButtons {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By QuoteNumberAssert = By.xpath("//input[@name='txtQNAME'][@type='TEXT']");
    static private By ShopperAssert = By.xpath("//select[@name='cbToRole2']");
    static private By SubmitRouteDocumentAssert = By.xpath("//input[@id='SUBMIT1'][@type='SUBMIT']");
    static private By FinalizeButton = By.xpath("//input[@id='SUBMIT5'][@type='SUBMIT']");
    //Active Quote Action buttons
    static private By QuoteSubmitButton = By.xpath("//input[@value='Submit'][@type='SUBMIT']");
    static private By QuoteConvertToPoButton = By.xpath("//input[@value='Convert to PO'][@type='SUBMIT']");
    static private By QuoteSaveButton = By.xpath("//input[@value='Save'][@type='SUBMIT']");
    static private By QuoteRevalidateButton = By.xpath("//input[@value='Re-Validate Quote'][@type='SUBMIT']");
    static private By QuoteRefreshButton = By.xpath("//input[@value='Refresh Price'][@type='SUBMIT']");
    static private By QuoteViewDetailsButton = By.xpath("//input[@value='View Detail'][@type='SUBMIT']");
    static private By QuoteUpdateButton = By.xpath("//input[@value='Update'][@type='SUBMIT']");

    static private By SaveQuotePopup = By.xpath("//input[@value='Update'][@type='SUBMIT']");
    static private By SaveQuotePopupSave = By.xpath("//input[@id='0'][@value='Save'][@type='SUBMIT']");

    public static void SubmitQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteSubmitButton)>0) {
            ActualLable("quote is ready to submit ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteSubmitButton,1);
            Thread.sleep(10000);
            ExpectedLable("Verify that User gets navigated to route document page or not?");
            String RouteDocumentPageTitle = GetPageTitle(driver);
            if (RouteDocumentPageTitle.contentEquals("Step 1: Route Document")) {
                ActualLable("Quote submit route document page opened successfully ", "Pass");
                //Random string generation//
                Random rand = new Random();
                int Refe = rand.nextInt(999)+1000;
                String  Quote_Number = "AutoQuote"+Refe;
                sendInputData(driver, QuoteNumberAssert).sendKeys(Quote_Number);
                selectDropDown(driver,ShopperAssert).selectByVisibleText(SearchColumnText("Shopper"));
                clickOnElement(driver,SubmitRouteDocumentAssert);
                Thread.sleep(5000);
                ExpectedLable("Verify that User gets navigated to review and finalize page or not?");
                String ReviewAndFinalizePageTitle = GetPageTitle(driver);
                if (ReviewAndFinalizePageTitle.contentEquals("Step 2: Review and Finalize")) {
                    ActualLable("Review and finalize page opened successfully ", "Pass");
                    clickOnElementFromMultipleElements(driver,FinalizeButton,1);
                    ExpectedLable("Verify that quote submitted successfully or not?");
                    String ConfirmationPageTitle = GetPageTitle(driver);
                    if (ConfirmationPageTitle.contentEquals("Step 3: Confirmation")) {
                        ActualLable("Quote submitted successfully ", "Pass");
                    }else {ActualLable("Quote submission failed ", "Fail");}
                }else {ActualLable("Review and finalize page not opened ", "Fail");}
            } else {ActualLable(" Error in opening route document page after submit action", "Fail");}
        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void SaveQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Save' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteSaveButton)>0) {
            ActualLable("quote is ready to save ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteSaveButton,1);
            ExpectedLable("Verify that save quote popup opened or not?");
            if (SizeOfTheElement(driver, SaveQuotePopup) > 0) {
                ActualLable("Save quote popup opened", "Pass");
                clickOnElement(driver, SaveQuotePopupSave);
                ExpectedLable("Verify that User gets navigated to home page after quote getting saved?");
                String HomePageTitle = GetPageTitle(driver);
                if (HomePageTitle.contentEquals("Home")) {
                    ActualLable("user get navigated to qupote page, quote saved successfully ", "Pass");
                } else {ActualLable(" Quote save error", "Fail");}
            }else {ActualLable("error in opening Cancel popup", "Fail");}
        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void UpdateQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteUpdateButton)>0) {
            ActualLable("quote is ready to update ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteUpdateButton,2);

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void ViewDetailsOnQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteViewDetailsButton)>0) {
            ActualLable("quote is ready to view details ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteViewDetailsButton,1);
            ExpectedLable("Verify that User gets navigated to view details page or not?");
            String ViewDetailsPageTitle = GetPageTitle(driver);
            if (ViewDetailsPageTitle.contentEquals("Quote Details")) {
                ActualLable("Quote view details page opened successfully ", "Pass");
            } else {ActualLable(" Quote save error", "Fail");}
        }else {ActualLable("Issue in opening View details page", "Fail");}
    }

    public static void RefreshQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteRefreshButton)>0) {
            ActualLable("quote is ready to Refresh ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteRefreshButton,1);

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void ConvertToPoQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteConvertToPoButton)>0) {
            ActualLable("quote is ready to be converted to PO ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteConvertToPoButton,1);

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void RevalidateQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteRevalidateButton)>0) {
            ActualLable("quote is ready to Revalidate ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteRevalidateButton,1);

        }else {ActualLable("Errors on the quote","Fail"); }

    }

}
