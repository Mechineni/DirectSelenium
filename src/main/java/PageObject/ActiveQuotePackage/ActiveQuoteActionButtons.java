package PageObject.ActiveQuotePackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;

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
    //---Active Quote Action buttons
    static private By QuoteSubmitBtn = By.xpath("//input[@value='Submit'][@type='SUBMIT']");
    static private By QuoteConvertToPoBtn = By.xpath("//input[@value='Convert to PO'][@type='SUBMIT']");
    static private By QuoteSaveBtn = By.xpath("//input[@value='Save'][@type='SUBMIT']");
    static private By QuoteRevalidateBtn = By.xpath("//input[@value='Re-Validate Quote'][@type='SUBMIT']");
    static private By QuoteRefreshBtn = By.xpath("//input[@value='Refresh Price'][@type='SUBMIT']");
    static private By QuoteViewDetailsBtn = By.xpath("//input[@value='View Detail'][@type='SUBMIT']");
    static private By QuoteUpdateBtn = By.xpath("//input[@value='Update'][@type='SUBMIT']");

    static private By QuoteCancelBtn = By.xpath("//input[@value='Cancel'][@type='SUBMIT']");
    static private By QuoteCancelPopup = By.xpath("//td[@id='dialogTitle'][contains(text(),'CANCEL')]");
    static private By QuoteCancelPopupOk = By.xpath("//input[@id='0'][@value='OK'][@type='SUBMIT']");

    static private By SaveQuotePopup = By.xpath("//input[@value='Update'][@type='SUBMIT']");
    static private By SaveQuotePopupSave = By.xpath("//input[@id='0'][@value='Save'][@type='SUBMIT']");

    static private By ActiveQuotePage = By.xpath("//td[@id='ItemHeaderNew']");

    //---Approval routing page
    static private By QuoteNameTxt = By.xpath("//input[@id='qn']");
    static private By SubmitBtn = By.xpath("//input[@value='Submit']");



    public static void SubmitQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteSubmitBtn)>0) {
            ActualLable("quote is ready to submit ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteSubmitBtn,1,"Quote Submit Button");
            Thread.sleep(10000);
            ExpectedLable("Verify that User gets navigated to route document page or not?");
            String RouteDocumentPageTitle = GetPageTitle(driver);
            if (RouteDocumentPageTitle.contentEquals("Step 1: Route Document")) {
                ActualLable("Quote submit route document page opened successfully ", "Pass");
                //Random string generation//
                Random rand = new Random();
                int Refe = rand.nextInt(999)+1000;
                String  Quote_Number = "AutoQuote"+Refe;
                sendInputData(driver, QuoteNumberAssert,Quote_Number,"Quote Number");
                selectDropDown(driver,ShopperAssert).selectByVisibleText(SearchColumnText("Shopper"));
                clickOnElement(driver,SubmitRouteDocumentAssert,"SubmitRouteDocumentAssert Button");
                Thread.sleep(5000);
                ExpectedLable("Verify that User gets navigated to review and finalize page or not?");
                String ReviewAndFinalizePageTitle = GetPageTitle(driver);
                if (ReviewAndFinalizePageTitle.contentEquals("Step 2: Review and Finalize")) {
                    ActualLable("Review and finalize page opened successfully ", "Pass");
                    clickOnElementFromMultipleElements(driver,FinalizeButton,1,"Finalize Button");
                    ExpectedLable("Verify that quote submitted successfully or not?");
                    String ConfirmationPageTitle = GetPageTitle(driver);
                    if (ConfirmationPageTitle.contentEquals("Step 3: Confirmation")) {
                        ActualLable("Quote submitted successfully ", "Pass");
                    }else {ActualLable("Quote submission failed ", "Fail");}
                }else {ActualLable("Review and finalize page not opened ", "Fail");}
            } else {ActualLable(" Error in opening route document page after submit action", "Fail");}
        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void SubmitQuoteForApproval(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Submit quote for approval");
        //---Click on submit button
        clickOnElementFromMultipleElements(driver,QuoteSubmitBtn,1,"Quote Submit Button");
        Thread.sleep(10000);
        //---Verify approval routing page opened or not
        String ApprovalRoutingPageTitle = GetPageTitle(driver);
        if (ApprovalRoutingPageTitle.contentEquals("Approval Routing")) {
            ReportEvent("Pass", "Verify that User gets navigated to APPROVAL ROUTING page or not?", " APPROVAL ROUTING page opened successfully");
            sendInputData(driver, QuoteNameTxt,SearchColumnText("QuoteName"),"Quote Name");
            clickOnElement(driver,SubmitBtn,"Submit Approval Btn");
            Thread.sleep(2000);
        }else if(ApprovalRoutingPageTitle.contentEquals("Step 1: Route Document")) {
            ReportEvent("Fail", "Verify that User gets navigated to APPROVAL ROUTING page or not?", " Workflow not triggered");
        }else {
            ReportEvent("Fail", "Verify that User gets navigated to APPROVAL ROUTING page or not?", " Error in opening APPROVAL ROUTING page");
        }

        String SubmittedPageTitle = GetPageTitle(driver);
        if (SubmittedPageTitle.contentEquals("Submitted")) {
            ReportEvent("Pass", "Verify that Quote submitted for approval or not?", "Quote submitted successfully for approval");
        }else {
            ReportEvent("Fail", "Verify that Quote submitted for approval or not?", "Error in submitting Quote for approval");
        }


    }

    public static void SaveQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Save' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteSaveBtn)>0) {
            ActualLable("quote is ready to save ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteSaveBtn,1,"Save Quote Button");
            ExpectedLable("Verify that save quote popup opened or not?");
            if (SizeOfTheElement(driver, SaveQuotePopup) > 0) {
                ActualLable("Save quote popup opened", "Pass");
                clickOnElement(driver, SaveQuotePopupSave,"Save Quote on Popup");
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
        if(SizeOfTheElement(driver,QuoteUpdateBtn)>0) {
            ActualLable("quote is ready to update ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteUpdateBtn,2,"Quote Update Button");

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void ViewDetailsOnQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteViewDetailsBtn)>0) {
            ActualLable("quote is ready to view details ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteViewDetailsBtn,1,"Quote View Details Btn");
            ExpectedLable("Verify that User gets navigated to view details page or not?");
            String ViewDetailsPageTitle = GetPageTitle(driver);
            if (ViewDetailsPageTitle.contentEquals("Quote Details")) {
                ActualLable("Quote view details page opened successfully ", "Pass");
            } else {ActualLable(" Quote save error", "Fail");}
        }else {ActualLable("Issue in opening View details page", "Fail");}
    }

    public static void RefreshQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteRefreshBtn)>0) {
            ActualLable("quote is ready to Refresh ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteRefreshBtn,1,"Quote Refresh Button");

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void ConvertToPoQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteConvertToPoBtn)>0) {
            ActualLable("quote is ready to be converted to PO ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteConvertToPoBtn,1,"Quote Convert To Button");

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void RevalidateQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteRevalidateBtn)>0) {
            ActualLable("quote is ready to Revalidate ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteRevalidateBtn,1,"Quote Revalidate Button");

        }else {ActualLable("Errors on the quote","Fail"); }

    }

    public static void CancelQuote(WebDriver driver) throws IOException, WriteException, BiffException, InterruptedException {
        if (SizeOfTheElement(driver, ActiveQuotePage) > 0) {
            ReportEvent("Pass","Verify that active order opened or not?","Active quote is open");
            clickOnElement(driver, QuoteCancelBtn,"Cancel Quote Button");
            Thread.sleep(10000);
            ExpectedLable("Verify that cancel popup opened or not?");
            if (SizeOfTheElement(driver, QuoteCancelPopup) > 0) {
                ActualLable("Cancel popup opened", "Pass");
                clickOnElement(driver, QuoteCancelPopupOk,"Ok button on Quote Cancel Popup");
            }else {ActualLable("error in opening Cancel popup", "Fail");}
        } else {
            ActualLable("Opened new quote", "Pass");
        }
    }

}
