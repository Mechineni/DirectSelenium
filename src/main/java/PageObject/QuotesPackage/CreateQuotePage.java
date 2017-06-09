package PageObject.QuotesPackage;

import GenericLib.AlertHandle;
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
public class CreateQuotePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    static private By QuotesHeading = By.xpath("//td[@class='ListHeader']/b[contains(text(),'QUOTING')]");
    static private By CreateQuoteLink = By.xpath("//td[@id='NavLinks']/a[contains(text(),'Create Quote')]");
    static private By BuyerNameTxtBx = By.xpath("//tr[4]/td[2]/input[@name='OrgName']");
    static private By RegionDrpd = By.xpath("//select[@name='RegionID']");
    static private By SearchBtn = By.xpath("//td/input[@name='SEARCH']");
    static private By BuyerNameLinks = By.xpath("//div[@id='srchDivId']/table[2]/tbody/tr/td/table/tbody/tr/td/a");
    static private By OrderingCountryDrpd = By.xpath("//td/select[@name='OrderingCountry']");
    static private By DeliveryCountryDrpd = By.xpath("//td/select[@name='DeliveryCountry']");
    static private By InstallCountryDrpd = By.xpath("//td/select[@name='InvoiceCountry']");
    static private By CurrencyDrpd = By.xpath("//td/select[@name='CurrencyCode']");
    static private By ExchangeRateLevelDrpd = By.xpath("//td/select[@name='LevelCode']");
    static private By ContinueBtn = By.xpath("//td/input[@name='CONTINUE']");
    static private By ActiveQuotePage = By.xpath("//td[@id='ItemHeaderNew']");

    public static boolean VerifyCreateQuotePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Create Quote page is opened or not ?");
        if(SizeOfTheElement(driver,QuotesHeading)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Quoting")){
                Status=true;
                ActualLable("successfully verified Assert for Create Quote Page ","Pass");
            }else{ActualLable(" Assert verification failed for Create Quote Page ","Fail");}
        }else{ActualLable("Create Quote page is not Loaded Properly","Fail");}
        return Status;
    }

    public static void CreateQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Creating quote from quotes main menu");
        //---Click on Create quote link from main menu options
        if (SizeOfTheElement(driver, CreateQuoteLink) > 0) {
            ReportEvent("Pass","Verify that Create Quote link available or not ?","Create Quote link available");
            clickOnElement(driver, CreateQuoteLink);
            Thread.sleep(2000);
            //---Search for the buyer to create quote
            if (SizeOfTheElement(driver, BuyerNameTxtBx) > 0) {
                ReportEvent("Pass","Verify that Create Quote page opened or not ?","Create quote page opened");
                sendInputData(driver, BuyerNameTxtBx).sendKeys(SearchColumnText("BuyerName"));
                ReportEvent("Pass","Provide the buyer name in buyer name Blank","Successfully entered Byer name, i.e :"+SearchColumnText("BuyerName"));
                selectDropDown(driver, RegionDrpd).selectByVisibleText(SearchColumnText("RegionName"));
                clickOnElement(driver, SearchBtn);
                //---Buyer name displayed on search results page
                if (SizeOfTheElement(driver, BuyerNameLinks) > 0) {
                    ReportEvent("Pass","Verify that Buyers search success or not?","Buyer names displayed on search result page");
                    boolean status = false;
                    int NoOfResult = SizeOfTheElement(driver, BuyerNameLinks);
                    for (int i = 0; i <= NoOfResult - 1; i++) {
                        int index = i + 1;
                        if (GetMultipleElementList(driver, BuyerNameLinks).get(i).getText().contentEquals(SearchColumnText("BuyerName"))) {
                            ReportEvent("Pass","Verify required Buyer Name found or not","Successfully found expected buyer name");
                            status = true;
                            //---Click on buyer name hyperlink
                            GetMultipleElementList(driver, BuyerNameLinks).get(i).click();
                            break;
                        }
                    }
                    if (status == false) {
                        ReportEvent("Fail","Verify required Buyer Name found or not","Expected buyer name not found");
                    }
                } else {
                    ReportEvent("Fail","Verify that Buyers search success or not?","Buyer names not displayed on search result page");
                }
            } else {
                ReportEvent("Fail","Verify that Create Quote page opened or not ?","Create quote page not opened");
            }
        } else {
            ReportEvent("Fail","Verify that Create Quote link available or not ?","Create Quote link not available");
        }
    }

    public static void SelectCountries (WebDriver driver) throws IOException, WriteException, BiffException, InterruptedException {
        StepLable("Select Countries on Create Quote Estimate Page");
        //---Select countries on quote estimate page
        if (SizeOfTheElement(driver, OrderingCountryDrpd) > 0) {
            ReportEvent("Pass","Verify that countries selection page opened or not?","Countries selection page opened successfully");
            selectDropDown(driver, OrderingCountryDrpd).selectByVisibleText(SearchColumnText("OrderCountry"));
            selectDropDown(driver, DeliveryCountryDrpd).selectByVisibleText(SearchColumnText("DeliveryCountry"));
            selectDropDown(driver, InstallCountryDrpd).selectByVisibleText(SearchColumnText("InstallCountry"));
            selectDropDown(driver, CurrencyDrpd).selectByVisibleText(SearchColumnText("Currency"));
            selectDropDown(driver, ExchangeRateLevelDrpd).selectByVisibleText("Spot");
            //---Click on Continue Button
            clickOnElement(driver, ContinueBtn);
            Thread.sleep(1000);
            AlertHandle.acceptAlert(driver);
            //---Verify that user navigated to active quote
            if (SizeOfTheElement(driver, ActiveQuotePage) > 0) {
                ReportEvent("Pass","Verify that active order opened or not?","Navigated to active quote successfully");
            } else {
                ReportEvent("Fail","Verify that active order opened or not?","Active quote not displayed");
            }
        } else {
            ReportEvent("Fail","Verify that countries selection page opened or not?","Countries selection page not opened successfully");
        }

    }

}
