package PageObject.QuotesPackage;

import GenericLib.AlertHandle;
import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;
import static GenericLib.DataDriven.SearchColumnText;

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
    static private By CatalogOnQuotePage = By.xpath("//td[@id='BottomRow']/a[contains(text(),'Catalog')]");
    static private By CatalogsList = By.xpath("//tbody/tr[1]/td/table/tbody/tr/td/b/li/a");
    static private By ProductNarrowSearch = By.id("NarrowKeyword");
    static private By ProductNarrowSearchButton = By.xpath("//input[@value='Search'][@class='SubmitButton']");
    static private By ConfigureButton = By.xpath("//input[@value='Configure'][@class='SubmitButton']");
    static private By DetailsButton = By.xpath("//input[@value='Details'][@class='SubmitButton']");
    static private By DoneButton = By.id("Done");
    static private By AddToCartButton = By.id("ADDCART");
    static private By CancelPopup = By.xpath("//td[@id='dialogTitle'][contains(text(),'CANCEL')]");
    static private By CancelPopupOk = By.xpath("//input[@id='0'][@value='OK'][@type='SUBMIT']");
    static private By QuoteSubmitButton = By.xpath("//input[@value='Submit'][@type='SUBMIT']");
    static private By QuoteConvertToPoButton = By.xpath("//input[@value='Convert to PO'][@type='SUBMIT']");
    static private By QuoteSaveButton = By.xpath("//input[@value='Save'][@type='SUBMIT']");
    static private By QuoteRevalidateButton = By.xpath("//input[@value='Re-Validate Quote'][@type='SUBMIT']");
    static private By QuoteRefreshButton = By.xpath("//input[@value='Refresh Price'][@type='SUBMIT']");
    static private By QuoteViewDetailsButton = By.xpath("//input[@value='View Detail'][@type='SUBMIT']");
    static private By QuoteUpdateButton = By.xpath("//input[@value='Update'][@type='SUBMIT']");
    static private By SaveQuotePopup = By.xpath("//input[@value='Update'][@type='SUBMIT']");
    static private By SaveQuotePopupSave = By.xpath("//input[@id='0'][@value='Save'][@type='SUBMIT']");
    static private By QuoteNumberAssert = By.xpath("//input[@name='txtQNAME'][@type='TEXT']");
    static private By ShopperAssert = By.xpath("//select[@name='cbToRole2']");
    static private By SubmitRouteDocumentAssert = By.xpath("//input[@id='SUBMIT1'][@type='SUBMIT']");
    static private By FinalizeButton = By.xpath("//input[@id='SUBMIT1'][@type='SUBMIT']");



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
                    if (status == true) {
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
                                    SubmitQuote(driver);
                                }else {ActualLable("error in opening Cancel popup", "Fail");}
                            } else {
                                ActualLable("Opened new quote", "Pass");
                                AddProductsToQuote(driver);
                            }
                        } else {
                            ActualLable("Countries selection page not opened", "Fail");
                        }
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

    public static void AddProductsToQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that new quote page opened or not?");
        if (SizeOfTheElement(driver, ItemsListActiveQuote) > 0) {
            ActualLable("Opened an active quote", "Fail");
        }else {
            ActualLable("Opened new quote", "Pass");
            clickOnElement(driver, CatalogOnQuotePage);
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
                    if (GetMultipleElementList(driver, CatalogsList).get(i).getText().contentEquals(SearchColumnText("catalogName"))) {
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
                        sendInputData(driver, ProductNarrowSearch).sendKeys(SearchColumnText("mfrPart"));
                        clickOnElement(driver, ProductNarrowSearchButton);
                        Thread.sleep(5000);
                        AlertHandle.acceptAlert(driver);
                        ExpectedLable("Verify product search results?");
                        if (SizeOfTheElement(driver, ConfigureButton) > 0) {
                            ActualLable("product narrow search displayed requested details", "Pass");
                            clickOnElement(driver, ConfigureButton);
                            Thread.sleep(5000);
                            AlertHandle.acceptAlert(driver);
                            clickOnElement(driver, DoneButton);
                            Thread.sleep(40000);
                            clickOnElement(driver, AddToCartButton);
                        }else if(SizeOfTheElement(driver, DetailsButton) > 0) {
                            ActualLable("product narrow search displayed requested details", "Pass");
                            clickOnElement(driver, DetailsButton);
                            Thread.sleep(20000);
                            AlertHandle.acceptAlert(driver);
                            Thread.sleep(5000);
                            clickOnElement(driver, AddToCartButton);
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

    public static void SubmitQuote(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        ExpectedLable("Verify that 'Submit' button on Quote page is enabled or not ?");
        if(SizeOfTheElement(driver,QuoteSubmitButton)>0) {
            ActualLable("quote is ready to submit ","Pass");
            clickOnElementFromMultipleElements(driver,QuoteSubmitButton,1);
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
                ExpectedLable("Verify that User gets navigated to review and finalize page or not?");
                String ReviewAndFinalizePageTitle = GetPageTitle(driver);
                if (ReviewAndFinalizePageTitle.contentEquals("Step 2: Review and Finalize")) {
                    ActualLable("Review and finalize page opened successfully ", "Pass");
                    clickOnElement(driver,FinalizeButton);
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
