package PageObject.BuyerDetailsPackage;

import GenericLib.ObjectRepository;
import PageObject.RegionPackage.RegionUpdatePage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;
import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.SearchColumnText;

/**
 * Created by t.mirasipally on 21-Feb-17.
 */
public class CustomerCatalogAndPricingPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    //Assign catalog section
    static private By BuyerDetailsUpdateAssert=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By AvailableCatalogsLbx=By.xpath("//tr/td[1]/select/option");
    static private By AssignedCatalogsLbx=By.xpath("//tr[5]/td[3]/select/option");
    static private By AssignBtn=By.xpath("//input[@name='ASSIGN'][@type='SUBMIT']");
    static private By UnAssignBtn=By.xpath("//input[@name='UNASSIGN'][@type='SUBMIT']");

    static private By UpdateCatalogAndPricing=By.xpath("//input[@name='UPDATE'][@type='SUBMIT']");
    static private By ZeroPrizeLineItems =By.xpath("//input[@name='ZeroPrice'][@type='CHECKBOX']");
    static private By ZeroPrizeLineItemsTextBox =By.xpath("//input[@name='ZeroPriceValue'][@type='TEXT']");
    static private By ExpediteByCustomer =By.xpath("//input[@name='BCExp'][@type='CHECKBOX']");

    //---Sell Price Scheme Section
    static private By CatalogUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[2]/select/parent::td/preceding-sibling::td");
    static private By PriceTypeUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[2]/select");
    static private By PriceValueUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[3]/input");
    static private By ExpediteOptionUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[4]/input");
    static private By ExpediteValueUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[5]/input");
    static private By RoundPriceUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[6]/select");
    static private By ExchangeRateSourceUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[8]/select");
    static private By ProductRuleUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[9]/a[contains(text(),'Product')]");
    static private By FamilyRuleUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[9]/a[contains(text(),'Family')]");
    static private By DiscountCodeRuleUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[9]/a[contains(text(),'Discount Code')]");
    static private By ManufacturerRuleUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[9]/a[contains(text(),'Manufacturer')]");
    static private By CategoryRuleUnderPriceScheme=By.xpath("//b[contains(text(),'PRICE SCHEME')]/parent::td/parent::tr/following-sibling::tr/td[9]/a[contains(text(),'Category')]");
    //--- Our Cost section
    static private By CatalogUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[1]/input/parent::td");
    static private By CostTypeUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[2]/select");
    static private By DiscountValueUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[3]/input");
    static private By ExpediteValueUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[4]/input");
    static private By ExchangeRateUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[6]/select");
    static private By ProductRuleUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[7]/a[contains(text(),'Product')]");
    static private By FamilyRuleUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[7]/a[contains(text(),'Family')]");
    static private By DiscountTypeRuleUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[7]/a[contains(text(),'Discount Code')]");
    static private By ManufacturerRuleUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[7]/a[contains(text(),'Manufacturer')]");
    static private By CategoryRuleUnderOurCost=By.xpath("//b[contains(text(),'OUR COST')]/parent::td/parent::tr/following-sibling::tr/td/table/tbody/tr/td[7]/a[contains(text(),'Category')]");
    //---Cost factor page
    static private By CostFactorsLink=By.xpath("//a[contains(text(),'COST FACTORS')]");
    static private By RegionCostFactorsLink=By.xpath("//a[contains(text(),'Cost Factors')]");
    static private By CatNameOnCostFactorsPage=By.xpath("//td[2][@class='ListAltRow1']/input/parent::td");
    static private By RegionConfigurationCheckBox=By.id("UseRegion");
    static private By UpdateCostFactorsButton=By.xpath("//input[@type='submit'][@value='Update']");
    static private By ProductRuleUnderCostFactors=By.xpath("//a[contains(text(),'Product')]");
    static private By FamilyRuleUnderCostFactors=By.xpath("//a[contains(text(),'Family')]");
    static private By NCMRuleUnderCostFactors=By.xpath("//a[contains(text(),'NCM')]");
    static private By ManufacturerRuleUnderCostFactors=By.xpath("//a[contains(text(),'Category')]");
    static private By CategoryRuleUnderCostFactors=By.xpath("//a[contains(text(),'Manufacturer')]");



    public static void AssignCatalogsToBuyer(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Assign Catalog for the buyer under Customer and Catalog Pricing page");
            //--- Get the Catalog Name from test data sheet
            String CatalogName = SearchColumnText("CatalogName1");
            By AvailableCatalog = By.xpath("//tr/td[1]/select/option[contains(text(),'" + CatalogName + "')]");
            By AssignedCatalog = By.xpath("//tr[5]/td[3]/select/option[contains(text(),'" + CatalogName + "')]");
            boolean Status = false;
            if (SizeOfTheElement(driver, AssignedCatalogsLbx) > 0) {
                //---Unassign the required catalog from assigned catalogs list
                if (SizeOfTheElement(driver, AssignedCatalog) > 0) {
                    String ExpCatName = GetElementText(driver, AssignedCatalog);
                    if (ExpCatName.contentEquals(CatalogName)) {
                        ReportEvent("Pass", "Verify that required catalog available or not?", "Required catalog '"+CatalogName+"' is already assigned ");
                        clickElement(driver, AssignedCatalog);
                        clickElement(driver, UnAssignBtn);
                        Thread.sleep(2000);
                        ExpCatName = GetElementText(driver, AvailableCatalog);
                        if (ExpCatName.contentEquals(CatalogName)) {
                            ReportEvent("Pass", "Removing Catalog From assigned Catalog", "Successfully Removed Assigned Catalog");
                        }
                    }
                }
                //--- Now Assign the required catalog to the assigned catalog list
                String ExpectedCateName = GetElementText(driver, AvailableCatalog);
                if (ExpectedCateName.contentEquals(CatalogName)) {
                    clickElement(driver, AvailableCatalog);
                    clickElement(driver, AssignBtn);
                    String ExpCatName = GetElementText(driver, AssignedCatalog);
                    if (ExpCatName.contentEquals(CatalogName)) {
                        ReportEvent("Pass", "Verify that catalog '" + CatalogName + "'  is assigned", "Mentioned Catalog '" + CatalogName + "' is assigned to buyer successfully");
                        Status = true;
                    }
                    Thread.sleep(5000);
                } else {
                    ReportEvent("Fail","Verify the existance of mentioned Catalog", "mentioned Catalog '"+CatalogName+"' not found");
                }

            } else {
                ReportEvent("Fail", "Verify Catalog list box existence", "catalog block is not available");
            }
    }


    public static void SetValuesToPriceScheme(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Set values to catalog for the Price scheme (Sell Price) ");
        if (SizeOfTheElement(driver, CatalogUnderPriceScheme) > 0) {
            int NoOfAvaiCat = SizeOfTheElement(driver, CatalogUnderPriceScheme);
            int indexOfCatelog = 0;
            boolean statusOfCatalog = false;
            //---Verify that required catalog is displayed under price scheme section
            String CatalogName = SearchColumnText("CatalogName1");
            for (int i = 0; i <= NoOfAvaiCat - 1; i++) {
                String ExpectedCatName = GetMultipleElementList(driver, CatalogUnderPriceScheme).get(i).getText();
                if (ExpectedCatName.contentEquals(CatalogName)) {
                    statusOfCatalog = true;
                    indexOfCatelog = i;
                    ReportEvent("Pass", "Verify Catalog name is available under Price Scheme ", CatalogName + " Catalog is available under Price Scheme");
                    break;
                }
            }
            if (statusOfCatalog == false) {ReportEvent("Fail", "Verify Catalog name is available under Price Scheme ", CatalogName + " Catalog is not available under Price Scheme");}
            //--- If catalog found then set sell price rules under price scheme
            if (statusOfCatalog == true) {
                //---setting SELL price type and price value
                if (SizeOfTheElement(driver, PriceTypeUnderPriceScheme) > 0) {
                    selectDropDownFromMultipleElements(driver, PriceTypeUnderPriceScheme, indexOfCatelog).selectByVisibleText(SearchColumnText("PriceType"));
                    ReportEvent("Pass", "Select Sell Price type as ' " + SearchColumnText("PriceType") + " ' given in the test data ", "Price type is selected as given test data");
                }
                if (SizeOfTheElement(driver, PriceValueUnderPriceScheme) > 0) {
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("PriceSchemaValue"));
                    ReportEvent("Pass", "Set Sell Price discount value as given in the test data ", "Price discount value is set as ' " + SearchColumnText("PriceSchemaValue") + " ' given in test data");
                }
                //---Checking ' Expedite value ' is provided or not if yes provide % of expedite value
                if (SizeOfTheElement(driver, ExpediteOptionUnderPriceScheme) > 0) {
                    if (SearchColumnText("ExpediteOption").contentEquals("Yes")) {
                        clickOnElement(driver, ExpediteOptionUnderPriceScheme,"Expedite Option Under PriceScheme");
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).clear();
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("ExpediteValue"));
                        ReportEvent("Pass", "Expedite Option is checked and value is set", "Expedite option is checked and value is set as ' " + SearchColumnText("ExpediteValue"));
                    } else {
                        ReportEvent("Pass", "Expedite Option is Given as NO in test data", "Expedite option is given as ' " + SearchColumnText("ExpediteOption"));
                    }
                }
                //--- Set Round Price option as per value given in the test data
                if (SizeOfTheElement(driver, RoundPriceUnderPriceScheme) > 0) {
                    selectDropDownFromMultipleElements(driver, RoundPriceUnderPriceScheme, indexOfCatelog).selectByVisibleText(SearchColumnText("RoundPrice"));
                    ReportEvent("Pass", "Select Round price option as given in the test data ", "Round price option is selected as ' " + SearchColumnText("RoundPrice") + " ' given test data");
                }
                //---Verify if any rules set at product or family discount type or mfr or category
               /* String[] RulesTexts = {"Product Rule Under Price Scheme", "Family Rule Under Price Scheme", "Discount Type Rule Under Price Scheme", "Manufacturer Rule Under Price Scheme", "Category Rule Under Price Scheme"};
                By[] RulesXpaths = {ProductRuleUnderPriceScheme, FamilyRuleUnderPriceScheme, DiscountCodeRuleUnderPriceScheme, ManufacturerRuleUnderPriceScheme, CategoryRuleUnderPriceScheme};
                String[] ourCostProductRule = {"Product Rule", "Family Rule", "Discount Code Rule", "Manufacture Rule", "Category Rule"};
                for (int i = 0; i <= 4; i++) {
                    String ExpectedStatusOfRule = SearchColumnText(ourCostProductRule[i]);
                    ExpectedLable("Check that ' " + RulesTexts[i] + " ' is applied or not ?");
                    if (ExpectedStatusOfRule.contentEquals("Yes")) {
                        if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                            ActualLable("' " + RulesTexts[i] + " ' is applied", "Pass");
                            clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog);
                        } else {
                            ActualLable("" + RulesTexts[i] + " link is not available ", "Fail");
                        }
                    } else {
                        ActualLable(" Our Cost ' " + RulesTexts[i] + " ' is not applied", "Pass");
                    }
                }*/
            }
        }
    }

    public static void SetZeroPriceAndExpediteBYCustomerOption (WebDriver driver) throws WriteException, IOException, BiffException {
        String ZeroPriceLineItems = SearchColumnText("ZeroPriceOption");
        String enableExpediteOption = SearchColumnText("CustomerExpediteOption");
        String[] ExtraOptions = {ZeroPriceLineItems, enableExpediteOption};
        By[] ExtraOptionsXpath = {ZeroPrizeLineItems, ExpediteByCustomer};
        String[] ExtraOptionsSt = {"Zero Price LineItems check box", "enable Expedite Option check box"};
        String[] ExtraOptionsText = {"Zero Price Line Items", "enable Expedite Option"};
        for (int i = 0; i <= 1; i++) {
            ExpectedLable("Check that ' "+ExtraOptionsText[i]+" ' settings check box need to select or not ?");
            if (ExtraOptions[i].contentEquals("No")) {
                ActualLable("No need to select ' "+ExtraOptionsText[i]+" ' settings check box as per TestData  ", "Pass");
                ExpectedLable("Check that ' "+ExtraOptionsText[i]+" ' settings check box is selected or not ?");
                if (GetElement(driver, ExtraOptionsXpath[i]).isSelected()) {
                    ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is already selected", "Pass");
                    clickOnElement(driver, ExtraOptionsXpath[i],ExtraOptionsSt[i]);
                } else {
                    ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is not selected", "Pass");
                }
            }else if(ExtraOptions[i].contentEquals("Yes")){
                ActualLable(" '"+ExtraOptionsText[i]+"' settings check box need to be selected as per test data ", "Pass");
                ExpectedLable("Check that '"+ExtraOptionsText[i]+"' settings check box is selected or not ?");
                if (GetElement(driver, ExtraOptionsXpath[i]).isSelected()) {
                    ActualLable("'"+ExtraOptionsText[i]+"' settings check box is already selected", "Pass");
                } else {
                    ActualLable("'"+ExtraOptionsText[i]+"' settings check box is not selected", "Pass");
                    clickOnElement(driver, ExtraOptionsXpath[i],ExtraOptionsSt[i]);
                }
                if (i == 0) {
                    GetElement(driver, ZeroPrizeLineItemsTextBox).clear();
                    sendInputData(driver, ZeroPrizeLineItemsTextBox,SearchColumnText("ZeroPriceOptionValue"),ExtraOptionsSt[i]);
                }
            }
        }
    }

    public static void SetValuesToOurCost(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Set values to catalog for the ' Our Cost ' section");
        if (SizeOfTheElement(driver, CatalogUnderOurCost) > 0) {
            int NoOfAvaiCat = SizeOfTheElement(driver, CatalogUnderOurCost);
            int indexOfCatelog = 0;
            boolean statusOfCatalog = false;
            ExpectedLable("Verify Catalog name is available under Our Cost Scheme ");
            String CatName = SearchColumnText("CatalogName1");
            for (int i = 0; i <= NoOfAvaiCat - 1; i++) {
                String ExpectedCatName=GetMultipleElementList(driver, CatalogUnderOurCost).get(i).getText();
                if (ExpectedCatName.contentEquals(CatName)) {
                    statusOfCatalog = true;
                    indexOfCatelog = i;
                    ActualLable(CatName+" Catalog is available under Our Cost Scheme", "Pass");
                    break;
                }
            }if(statusOfCatalog == false){ActualLable(CatName+" Catalog is not available under Our Cost Scheme", "Fail");}
            if(statusOfCatalog == true){
                //setting price type and price value
                ExpectedLable("Select Our Cost type as ' "+SearchColumnText("OurCostType")+" ' given in the test data ");
                if(SizeOfTheElement(driver, CostTypeUnderOurCost) > 0){
                    selectDropDownFromMultipleElements(driver,CostTypeUnderOurCost,indexOfCatelog).selectByVisibleText(SearchColumnText("OurCostType"));
                    ActualLable("Our Cost type is provided as given test data", "Pass");}
                ExpectedLable("Set Our Cost discount value as ' "+SearchColumnText("OurCostDiscount")+" ' given in the test data ");
                if(SizeOfTheElement(driver, DiscountValueUnderOurCost) > 0){
                    GetMultipleElementList(driver, DiscountValueUnderOurCost).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, DiscountValueUnderOurCost).get(indexOfCatelog).sendKeys(SearchColumnText("OurCostDiscount"));
                    ActualLable("Our Cost discount value is provided as given test data", "Pass");}
                //Checking ' Expedite value ' is provided or not if yes provide % of expedite value
                ExpectedLable("Our Cost expedite value as given in Test data");
                if(SizeOfTheElement(driver, ExpediteValueUnderOurCost) > 0){
                    GetMultipleElementList(driver, ExpediteValueUnderOurCost).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, ExpediteValueUnderOurCost).get(indexOfCatelog).sendKeys(SearchColumnText("OurCostExpediteValue"));
                    ActualLable("Our Cost Expedite value is given as ' "+SearchColumnText("OurCostExpediteValue")+"'", "Pass");
                }

                /*String[]  RulesTexts = {"Product Rule Under Our Cost", "Family Rule Under Our Cost","Discount Type Rule Under Our Cost","Manufacturer Rule Under Our Cost","Category Rule Under Our Cost"};
                By[] RulesXpaths = {ProductRuleUnderOurCost, FamilyRuleUnderOurCost,DiscountTypeRuleUnderOurCost,ManufacturerRuleUnderOurCost,CategoryRuleUnderOurCost};
                String[]  OurCostProductRule = {"ourCostProductRule","ourCostFamilyRule","ourCostDiscountCodeRule","ourCostManufactureRule","ourCostCategoryRule"};
                for (int i = 0; i <= 4; i++) {
                    String ExpectedStatusOfRule =SearchColumnText(OurCostProductRule[i]);
                    ExpectedLable("Check that ' "+RulesTexts[i]+" ' is applied or not ?");
                    if (ExpectedStatusOfRule.contentEquals("Yes")) {
                        if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                            ActualLable("' "+RulesTexts[i]+" ' is applied", "Pass");
                            clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog);
                        } else {   ActualLable(""+RulesTexts[i]+" link is not available ", "Fail");     }
                    } else {  ActualLable(" ' "+RulesTexts[i]+" ' is not applied", "Pass");   }
                }*/
            }
        }else{ReportEvent("Fail","Verify Catalog existence in our cost section", "Catalogs not found in our cost section");}
    }
    public static boolean UpdateCustomerCatalogsAndPricing(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException{
        boolean updateDetails =false;
        //AssignCatalogsToBuyer(driver);
        //SetValuesToPriceScheme(driver);
        //SetValuesToOurCost(driver);
        //---Click on Update button on customer catalog page
        if(SizeOfTheElement(driver,UpdateCatalogAndPricing)>0){
            clickOnElement(driver,UpdateCatalogAndPricing,"Update Catalog And Pricing button");
            updateDetails=true;
            ReportEvent("Pass","Click on Update button to save Customer catalog and pricing details"," Successfully clicked on update button for Customer catalog and pricing page");
            //SetCostFactors(driver);
        }else {  ReportEvent("Fail","Verify Update button existance"," Update button is not available on Customer catalog and pricing page");    }
        return updateDetails;
    }
    public static void SetCostFactors(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException{
        StepLable("Set values under Cost Factors Section");
        if (SizeOfTheElement(driver, CostFactorsLink) > 0) {
            ReportEvent("Pass","Verify existance of Cost Factors link","Cost Factors Link found on the page");
            clickOnElement(driver, CostFactorsLink,"Cost Factors Link");
            Thread.sleep(1000);
        }else{
            ReportEvent("Fail","Verify existance of Cost Factors link","Cost Factors link is not available on page");
            return;
        }
        //---Verify that Cost factors page is opened.
        String PageTitle = GetPageTitle(driver);
        if(PageTitle.contentEquals("Cost Factors")){
            ReportEvent("Pass","Verify that Cost Factors page is opened","Cost factors page opened successfully");
            boolean RegionSelectStatus = false;
            String RegionConfig = SearchColumnText("UseRegionConfigOption");
            //---Use region configuration option selection as per test data
            if (RegionConfig.contentEquals("No")){
                ReportEvent("Pass","Verify the 'Use regional setting option'","Use regional setting options is '"+RegionConfig+"' as per test data.");
                if(GetElement(driver,RegionConfigurationCheckBox).isSelected()){
                    clickOnElement(driver,RegionConfigurationCheckBox,"Region Configuration CheckBox");
                    //---Click on update button on cost factors page
                    clickOnElement(driver,UpdateCostFactorsButton,"Update Cost factors Button");
                }else{
                    ReportEvent("Pass","Verify use regional setting check box","Regional settings check box is already unchecked");
                }

            }else if(RegionConfig.contentEquals("Yes")){
                if(GetElement(driver,RegionConfigurationCheckBox).isSelected()){
                    ReportEvent("Pass","Verify use regional setting check box","Regional settings check box is already checked");
                }else{
                    //---Select use region config checkbox (checked)
                    clickOnElement(driver,RegionConfigurationCheckBox,"Region Configuration CheckBox");
                    clickOnElement(driver,UpdateCostFactorsButton,"Update Cost factors Button");
                    ActualLable("Successfully clicked on update button","Pass");
                    Thread.sleep(1000);
                    //---Navigate to region page and search for the region and click edit button
                    RegionUpdatePage.RegionSearchAndEdit(driver);
                    //---Click on Cost factors link on Region update page
                    if (SizeOfTheElement(driver, RegionCostFactorsLink) > 0) {
                        ReportEvent("Pass","Verify existence of Cost Factors link on Region update page","Cost Factors Link found on Region update page");
                        clickOnElement(driver, RegionCostFactorsLink,"Region Cost Factors Link");
                        Thread.sleep(1000);

                    }
                }
            }
            //---Update cost factors and surcharge on Cost factors Page (Both region and buyer level)
            if (SizeOfTheElement(driver, CatNameOnCostFactorsPage) > 0) {
                int NoOfAvaiCat = SizeOfTheElement(driver, CatNameOnCostFactorsPage);
                    int indexOfCatelog = 0;
                    boolean statusOfCatalog = false;
                    //---Verify that catlog name is available on Cost Factors Page
                    String CatName = SearchColumnText("CostFactorsCatalogName");
                    for (int i = 0; i <= NoOfAvaiCat - 1; i++) {
                        String ExpectedCatName = GetMultipleElementList(driver, CatNameOnCostFactorsPage).get(i).getText();
                        if (ExpectedCatName.contentEquals(CatName)) {
                            statusOfCatalog = true;
                            indexOfCatelog = i;
                            ReportEvent("Pass","Verify Catalog name is available under Cost Factors page","Catalog '"+CatName+"' is available on cost factors page");
                            break;
                        }
                    }
                    //---Print report if catalog name not found
                    if (statusOfCatalog == false) {
                        ReportEvent("Pass", "Verify Catalog name is available under Cost Factors page", "Catalog '" + CatName + "' is available on cost factors page");
                    }
                    //---Set cost factors values
                    if(statusOfCatalog == true){

                        String[] CostFactors ={"Cost Factor1","Cost Factor2","Cost Factor3","Cost Factor4","Cost Factor5","Surcharge"};
                        String[] CostFactorsValueList ={"CostFactorValue1","CostFactorValue2","CostFactorValue3","CostFactorValue4","CostFactorValue5","CostFactorSurcharge"};
                        for(int i=3;i<=8;i++) {
                            By CostFactorsTxtBox = By.xpath("//td["+i+"][@class='ListAltRow1']/input/parent::td/input");
                            String CostFactorValue = SearchColumnText(CostFactorsValueList[i-3]);

                            if(GetMultipleElementList(driver, CostFactorsTxtBox).get(indexOfCatelog).isEnabled()){
                                //ReportEvent("Pass","Verify Cost Factor text box","'"+CostFactors[i-3]+"' text box is enabled");
                                GetMultipleElementList(driver, CostFactorsTxtBox).get(indexOfCatelog).clear();
                                GetMultipleElementList(driver, CostFactorsTxtBox).get(indexOfCatelog).sendKeys(CostFactorValue);
                                ReportEvent("Pass","Set '"+CostFactors[i-3]+"' value from test data","'"+CostFactors[i-3]+"' value is set as '"+CostFactorValue+"' on cost factors page");
                            }else{ReportEvent("Fail","Set '"+CostFactors[i-3]+"' from test data","'"+CostFactors[i-3]+"' value is not set as '"+CostFactorValue+"' on cost factors page");}
                        }

                        //---Exception level rules setting Product or NCM or Family or MFR or Category
                        String[]  RulesTexts = {"Product Rule Under Cost Factors", "Family Rule Under Cost Factors","Discount Type Rule Under Cost Factors","Manufacturer Rule Under Cost Factors","Category Rule Under Cost Factors"};
                        By[] RulesXpaths = {ProductRuleUnderCostFactors, FamilyRuleUnderCostFactors,NCMRuleUnderCostFactors,ManufacturerRuleUnderCostFactors,CategoryRuleUnderCostFactors};
                        String[]  OurCostProductRule = {"CostFactorsProductRule","CostFactorsFamilyRule","CostFactorsDiscountCodeRule","CostFactorsManufactureRule","CostFactorsCategoryRule"};
                        for (int i = 0; i <= 4; i++) {
                            String ExpectedStatusOfRule =SearchColumnText(OurCostProductRule[i]);
                            ExpectedLable("Check that ' "+RulesTexts[i]+" ' is applied or not ?");
                            if (ExpectedStatusOfRule.contentEquals("Yes")) {
                                if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                                    ActualLable("' "+RulesTexts[i]+" ' is applied", "Pass");
                                    clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog,RulesTexts[i]);
                                } else {   ActualLable(""+RulesTexts[i]+" link is not available ", "Fail");     }
                            } else {  ActualLable(" ' "+RulesTexts[i]+" ' is not applied", "Pass");   }
                        }
                        clickOnElement(driver,UpdateCostFactorsButton,"Update Cost Factors Button");
                    }
            }else{ReportEvent("Fail","Verify Catalog existence on Cost Factors page", "Catalog not found on cost factor page");}
        }else{ReportEvent("Fail","Verify that Cost Factors page is opened","Cost factors page not opened");;}
    }
}


