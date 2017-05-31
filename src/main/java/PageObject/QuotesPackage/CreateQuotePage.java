package PageObject.QuotesPackage;

import GenericLib.AlertHandle;
import GenericLib.ObjectRepository;
import PageObject.ActiveQuotePackage.ActiveQuoteActionButtons;
import PageObject.ActiveQuotePackage.CatalogPage;
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
    static private By QuotesHeadding = By.xpath("//td[@class='ListHeader']/b[contains(text(),'QUOTING')]");
    static private By CreateQuoteLink = By.xpath("//td[@id='NavLinks']/a[contains(text(),'Create Quote')]");
    static private By BuyerName = By.xpath("//tr[4]/td[2]/input[@name='OrgName']");
    static private By Region = By.xpath("//select[@name='RegionID']");
    static private By SearchButton = By.xpath("//td/input[@name='SEARCH']");
    static private By BuyerSelect = By.xpath("//div[@id='srchDivId']/table[2]/tbody/tr/td/table/tbody/tr/td/a");
    static private By OrderingCountry = By.xpath("//td/select[@name='OrderingCountry']");
    static private By DeliveryCountry = By.xpath("//td/select[@name='DeliveryCountry']");
    static private By InstallCountry = By.xpath("//td/select[@name='InvoiceCountry']");
    static private By Currency = By.xpath("//td/select[@name='CurrencyCode']");
    static private By ExchangeRateLevel = By.xpath("//td/select[@name='LevelCode']");
    static private By ContinueButton = By.xpath("//td/input[@name='CONTINUE']");
    static private By ItemsListActiveQuote = By.xpath("//td/input[@id='ln_sid']");
    static private By CancelQuote = By.xpath("//div[@id='orditems']/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td/input[7]");

    static private By CancelPopup = By.xpath("//td[@id='dialogTitle'][contains(text(),'CANCEL')]");
    static private By CancelPopupOk = By.xpath("//input[@id='0'][@value='OK'][@type='SUBMIT']");






    public static boolean VerifyCreateQuotePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status=false;
        ExpectedLable("Verify that Create Quote page is opened or not ?");
        if(SizeOfTheElement(driver,QuotesHeadding)>0) {
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Quoting")){
                Status=true;
                ActualLable("successfully verified Assert for Create Quote Page ","Pass");
            }else{ActualLable(" Assert verification failed for Create Quote Page ","Fail");}
        }else{ActualLable("Create Quote page is not Loaded Properly","Fail");}
        return Status;
    }

    public static void CreateQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that Create Quote link available or not ?");
        if (SizeOfTheElement(driver, CreateQuoteLink) > 0) {
            ActualLable("Create Quote link available ", "Pass");
            clickOnElement(driver, CreateQuoteLink);
            Thread.sleep(2000);
            ExpectedLable("Verify that Create Quote page opened or not ?");
            if (SizeOfTheElement(driver, BuyerName) > 0) {
                ActualLable("Create Quote link available ", "Pass");
                sendInputData(driver, BuyerName).sendKeys(SearchColumnText("buyerName"));
                //selectDropDown(driver,Region).selectByValue(SearchColumnText("buyerName"));
                clickOnElement(driver, SearchButton);
                ExpectedLable("Verify that Buyers search success or not?");
                if (SizeOfTheElement(driver, BuyerSelect) > 0) {
                    boolean status = false;
                    int NoOfResult = SizeOfTheElement(driver, BuyerSelect);
                    for (int i = 0; i <= NoOfResult - 1; i++) {
                        int index = i + 1;
                        if (GetMultipleElementList(driver, BuyerSelect).get(i).getText().contentEquals(SearchColumnText("buyerName"))) {
                            ActualLable("successfully searched provided buyer ", "Pass");
                            status = true;
                            GetMultipleElementList(driver, BuyerSelect).get(i).click();
                            break;
                        }
                    }
                    if (status == false) {
                        ActualLable(" Buyer search not returned required results ", "Fail");
                    }

                } else {
                    ActualLable(" Buyer search not returned required results ", "Fail");
                }
            } else {
                ActualLable("Create Quote page not opened", "Fail");
            }
        } else {
            ActualLable("Create Quote link not available ", "Fail");
        }
    }

    public static void SelectCountries (WebDriver driver) throws IOException, WriteException, BiffException, InterruptedException {

            ExpectedLable("Verify that countries selection page opened or not?");
            if (SizeOfTheElement(driver, OrderingCountry) > 0) {
                ActualLable("Countries selection page opened successfully", "Pass");
                selectDropDown(driver, OrderingCountry).selectByVisibleText(SearchColumnText("orderCountry"));
                selectDropDown(driver, DeliveryCountry).selectByVisibleText(SearchColumnText("deliveryCountry"));
                selectDropDown(driver, InstallCountry).selectByVisibleText(SearchColumnText("installCountry"));
                selectDropDown(driver, Currency).selectByVisibleText(SearchColumnText("currencyType"));
                clickOnElement(driver, ContinueButton);
                AlertHandle.acceptAlert(driver);
                ExpectedLable("Verify that if any existing active order opened?");
                if (SizeOfTheElement(driver, ItemsListActiveQuote) > 0) {
                    ActualLable("Opened an active quote", "Pass");
                    clickOnElement(driver, CancelQuote);
                    Thread.sleep(10000);
                    ExpectedLable("Verify that cancel popup opened or not?");
                    if (SizeOfTheElement(driver, CancelPopup) > 0) {
                        ActualLable("Cancel popup opened", "Pass");
                        clickOnElement(driver, CancelPopupOk);
                        CreateQuote(driver);
                        ActiveQuoteActionButtons.SubmitQuote(driver);
                    }else {ActualLable("error in opening Cancel popup", "Fail");}
                } else {
                    ActualLable("Opened new quote", "Pass");
                    CatalogPage.AddProductsToQuote(driver);
                }
            } else {
                ActualLable("Countries selection page not opened", "Fail");
            }

    }

}
