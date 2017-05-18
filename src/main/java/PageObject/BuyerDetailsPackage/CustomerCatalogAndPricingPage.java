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
 * Created by t.mirasipally on 21-Feb-17.
 */
public class CustomerCatalogAndPricingPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By BuyerDetailsUpdateAssert=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By CustomerCatalogAndPricingLink=By.xpath("//a[contains(text(),'Customer Catalogs and Pricing')]");
    static private By AvailableCatalogs=By.xpath("//tr/td[1]/select/option");
    static private By AssignedCatalogs=By.xpath("//tr[5]/td[3]/select/option");
    static private By AssignLink=By.xpath("//input[@name='ASSIGN'][@type='SUBMIT']");
    static private By UnAssignLink=By.xpath("//input[@name='UNASSIGN'][@type='SUBMIT']");
    static private By UpdateCatalogAndPricing=By.xpath("//input[@name='UPDATE'][@type='SUBMIT']");
    static private By CostFactorsLink=By.xpath("//a[contains(text(),'COST FACTORS')]");
    static private By ZeroPrizeLineItems =By.xpath("//input[@name='ZeroPrice'][@type='CHECKBOX']");
    static private By ZeroPrizeLineItemsTextBox =By.xpath("//input[@name='ZeroPriceValue'][@type='TEXT']");
    static private By ExpediteByCustomer =By.xpath("//input[@name='BCExp'][@type='CHECKBOX']");


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

    static private By CatalogInCostFactors=By.xpath("//td[2][@class='ListAltRow1']/input/parent::td");
    static private By RegionConfigurationCheckBox=By.id("UseRegion");
    static private By UpdateCostFactorsButton=By.xpath("//input[@type='submit'][@value='Update']");
    static private By ProductRuleUnderCostFactors=By.xpath("//a[contains(text(),'Product')]");
    static private By FamilyRuleUnderCostFactors=By.xpath("//a[contains(text(),'Family')]");
    static private By NCMRuleUnderCostFactors=By.xpath("//a[contains(text(),'NCM')]");
    static private By ManufacturerRuleUnderCostFactors=By.xpath("//a[contains(text(),'Category')]");
    static private By CategoryRuleUnderCostFactors=By.xpath("//a[contains(text(),'Manufacturer')]");


    public static void AssignCatalogsToBuyer(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Verifying Catalog details for the buyer");
        ExpectedLable("Verify that Customer Catalog And Pricing Link is available on Buyer details page or not ?");
        if(SizeOfTheElement(driver,CustomerCatalogAndPricingLink)>0) {
            ActualLable("Customer Catalog And Pricing Link is available on Buyer details page", "Pass");
            ExpectedLable("Click on Customer Catalog And Pricing Link on Buyer details page");
            clickOnElement(driver, CustomerCatalogAndPricingLink);
            ActualLable("Successfully clicked on Customer Catalog And Pricing Link on Buyer details page", "Pass");
            ExpectedLable("Verify that Customer Catalog and Pricing page opened successfully or not?");
            String CustomerCatalogPageTitle = GetPageTitle(driver);
            if (CustomerCatalogPageTitle.contentEquals("Customer Catalogs and Pricing")) {
                ActualLable("Customer Catalog and Pricing page opened successfully ", "Pass");
                ExpectedLable("Verify that required catalog available or not?");
                String catalogName1=SearchColumnText("catalogName1");
                By AvailableCatalog=By.xpath("//tr/td[1]/select/option[contains(text(),'"+catalogName1+"')]");
                By AssignedCatalog=By.xpath("//tr[5]/td[3]/select/option[contains(text(),'"+catalogName1+"')]");
                if (SizeOfTheElement(driver, AssignedCatalogs) > 0) {
                    boolean status = false;
                    if (SizeOfTheElement(driver, AssignedCatalog) > 0) {
                        String ExpCatName = GetElementText(driver, AssignedCatalog);
                        if (ExpCatName.contentEquals(catalogName1)) {
                            ActualLable("Required catalog is already assigned ", "Pass");
                            status = true;
                            ExpectedLable("Removing Catalog From assigned Catalog");
                            clickOnElement(driver, AssignedCatalog);
                            Thread.sleep(1000);
                            clickOnElement(driver, UnAssignLink);
                            ActualLable("Successfully Removed Assigned Catelog", "Pass");
                            status = false;
                        }
                    }
                    if(status==false){
                        ActualLable("Catalog is not assigned, Now add catalog to the buyer", "Pass");
                        ExpectedLable("Now try to assign Assign the Catalog to buyer");
                        String ExpectedCateName =GetElementText(driver,AvailableCatalog);
                        if (ExpectedCateName.contentEquals(catalogName1)) {
                            clickOnElement(driver, AvailableCatalog);
                            clickOnElement(driver, AssignLink);
                            status=true;
                            ActualLable("mentioned Catalog is assigned to buyer successfully", "Pass");
                            Thread.sleep(5000);
                        }else{ActualLable("mentioned Catalog not found ", "Fail"); }
                    }
                } else {  ActualLable(" catalog block is not available", "Fail");    }
            } else { ActualLable(" Assert verification failed for Customer Catalog and Pricing Page ", "Fail");    }
        }
    }
    public static void SetValuesToPriceScheme(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Set values to catalog for the Price scheme");
        if (SizeOfTheElement(driver, CatalogUnderPriceScheme) > 0) {
            int NoOfAvaiCat = SizeOfTheElement(driver, CatalogUnderPriceScheme);
            int indexOfCatelog = 0;
            boolean statusOfCatalog = false;
            ExpectedLable("Verify Catalog name is available under Price Scheme ");
            String CatName = SearchColumnText("catalogName1");
            for (int i = 0; i <= NoOfAvaiCat - 1; i++) {
                String ExpectedCatName = GetMultipleElementList(driver, CatalogUnderPriceScheme).get(i).getText();
                if (ExpectedCatName.contentEquals(CatName)) {
                    statusOfCatalog = true;
                    indexOfCatelog = i;
                    ActualLable(CatName + " Catalog is available under Price Scheme", "Pass");
                    break;
                }
            }
            if (statusOfCatalog == false) {   ActualLable(CatName + " Catalog is not available under Price Scheme", "Fail"); }
            if (statusOfCatalog == true) {
                //setting price type and price value
                ExpectedLable("Select Price type as ' " + SearchColumnText("priceType") + " ' given in the test data ");
                if (SizeOfTheElement(driver, PriceTypeUnderPriceScheme) > 0) {
                    selectDropDownFromMultipleElements(driver, PriceTypeUnderPriceScheme, indexOfCatelog).selectByVisibleText(SearchColumnText("priceType"));
                    ActualLable("Price type is provided as given test data", "Pass");
                }
                ExpectedLable("Set Price discount value as ' " + SearchColumnText("priceSchemaValue") + " ' given in the test data ");
                if (SizeOfTheElement(driver, PriceValueUnderPriceScheme) > 0) {
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("priceSchemaValue"));
                    ActualLable("Price discount value is provided as given test data", "Pass");
                }
                //Checking ' Expedite value ' is provided or not if yes provide % of expedite value
                ExpectedLable("Check that ' Expedite value ' is provided or not if yes provide % of expedite value");
                if (SizeOfTheElement(driver, ExpediteOptionUnderPriceScheme) > 0) {
                    if (SearchColumnText("expediteValue").contentEquals("Yes")) {
                        clickOnElement(driver, ExpediteOptionUnderPriceScheme);
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).clear();
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("expediteValue"));
                        ActualLable("Expedite value is given as ' " + SearchColumnText("expediteValue"), "Pass");
                    } else {  ActualLable("Expedite value is not selected ", "Pass"); }
                }

                ExpectedLable("Select Round price type as ' " + SearchColumnText("Round Price") + " ' given in the test data ");
                if (SizeOfTheElement(driver, RoundPriceUnderPriceScheme) > 0) {
                    selectDropDownFromMultipleElements(driver, RoundPriceUnderPriceScheme, indexOfCatelog).selectByVisibleText(SearchColumnText("Round Price"));
                    ActualLable("Round price type is provided as given test data", "Pass");
                }
                String[]  RulesTexts = {"Product Rule Under Price Scheme", "Family Rule Under Price Scheme","Discount Type Rule Under Price Scheme","Manufacturer Rule Under Price Scheme","Category Rule Under Price Scheme"};
                By[] RulesXpaths = {ProductRuleUnderPriceScheme, FamilyRuleUnderPriceScheme,DiscountCodeRuleUnderPriceScheme,ManufacturerRuleUnderPriceScheme,CategoryRuleUnderPriceScheme};
                String[]  ourCostProductRule = {"Product Rule","Family Rule","Discount Code Rule","Manufacture Rule","Category Rule"};
                for (int i = 0; i <= 4; i++) {
                    String ExpectedStatusOfRule =SearchColumnText(ourCostProductRule[i]);
                    ExpectedLable("Check that ' "+RulesTexts[i]+" ' is applied or not ?");
                    if (ExpectedStatusOfRule.contentEquals("Yes")) {
                        if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                            ActualLable("' "+RulesTexts[i]+" ' is applied", "Pass");
                            clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog);
                        } else {   ActualLable(""+RulesTexts[i]+" link is not available ", "Fail");     }
                    } else {  ActualLable(" Our Cost ' "+RulesTexts[i]+" ' is not applied", "Pass");   }
                }
            }
            String ZeroPriceLineItems = SearchColumnText("zeroPriceOption");
            String enableExpediteOption = SearchColumnText("enableExpediteOption");
            String[] ExtraOptions = {ZeroPriceLineItems, enableExpediteOption};
            By[] ExtraOptionsXpath = {ZeroPrizeLineItems, ExpediteByCustomer};
            String[] ExtraOptionsText = {"Zero Price Line Items", "enable Expedite Option"};
            for (int i = 0; i <= 1; i++) {
                ExpectedLable("Check that ' "+ExtraOptionsText[i]+" ' settings check box need to select or not ?");
                if (ExtraOptions[i].contentEquals("No")) {
                    ActualLable("No need to select ' "+ExtraOptionsText[i]+" ' settings check box as per TestData  ", "Pass");
                    ExpectedLable("Check that ' "+ExtraOptionsText[i]+" ' settings check box is selected or not ?");
                    if (GetElement(driver, ExtraOptionsXpath[i]).isSelected()) {
                        ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is already selected", "Pass");
                        ExpectedLable("Now un select the check box for ' "+ExtraOptionsText[i]+" '");
                        clickOnElement(driver, ExtraOptionsXpath[i]);
                        ActualLable("Successfully un selected the check box for ' "+ExtraOptionsText[i]+" '", "Pass");
                    } else {
                        ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is not selected", "Pass");
                    }
                }else if(ExtraOptions[i].contentEquals("Yes")){
                    ActualLable(" ' "+ExtraOptionsText[i]+" ' settings check box need to select as per test data ", "Pass");
                    ExpectedLable("Check that ' "+ExtraOptionsText[i]+" ' settings check box is selected or not ?");
                    if (GetElement(driver, ExtraOptionsXpath[i]).isSelected()) {
                        ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is already selected", "Pass");
                    } else {
                        ActualLable("' "+ExtraOptionsText[i]+" ' settings check box is not selected", "Pass");
                        ExpectedLable("Now select the check box for ' "+ExtraOptionsText[i]+" '");
                        clickOnElement(driver, ExtraOptionsXpath[i]);
                        ActualLable("Successfully selected the check box for ' "+ExtraOptionsText[i]+" '", "Pass");
                    }
                    if (i == 0) {
                        ExpectedLable("Enter Value in  ' "+ExtraOptionsText[i]+" ' blank");
                        GetElement(driver, ZeroPrizeLineItemsTextBox).clear();
                        sendInputData(driver, ZeroPrizeLineItemsTextBox).sendKeys(SearchColumnText("zeroPriceOptionValue"));
                        ActualLable("Successfully entered value in to  ' "+ExtraOptionsText[i]+" ' blank", "Pass");
                    }
                }
            }
        }
    }
    public static void SetValuesToOurCost(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Set values to catalog for the ' Our Cost '");
        if (SizeOfTheElement(driver, CatalogUnderOurCost) > 0) {
            int NoOfAvaiCat = SizeOfTheElement(driver, CatalogUnderOurCost);
            int indexOfCatelog = 0;
            boolean statusOfCatalog = false;
            ExpectedLable("Verify Catalog name is available under Our Cost Scheme ");
            String CatName = SearchColumnText("catalogName1");
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
                ExpectedLable("Select Our Cost type as ' "+SearchColumnText("ourCostType")+" ' given in the test data ");
                if(SizeOfTheElement(driver, CostTypeUnderOurCost) > 0){
                    selectDropDownFromMultipleElements(driver,CostTypeUnderOurCost,indexOfCatelog).selectByVisibleText(SearchColumnText("ourCostType"));
                    ActualLable("Our Cost type is provided as given test data", "Pass");}
                ExpectedLable("Set Our Cost discount value as ' "+SearchColumnText("ourCostDiscount")+" ' given in the test data ");
                if(SizeOfTheElement(driver, DiscountValueUnderOurCost) > 0){
                    GetMultipleElementList(driver, DiscountValueUnderOurCost).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, DiscountValueUnderOurCost).get(indexOfCatelog).sendKeys(SearchColumnText("ourCostDiscount"));
                    ActualLable("Our Cost discount value is provided as given test data", "Pass");}
                //Checking ' Expedite value ' is provided or not if yes provide % of expedite value
                ExpectedLable(" provide % of Our Cost expedite value as given in Test data");
                if(SizeOfTheElement(driver, ExpediteValueUnderOurCost) > 0){
                    GetMultipleElementList(driver, ExpediteValueUnderOurCost).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, ExpediteValueUnderOurCost).get(indexOfCatelog).sendKeys(SearchColumnText("ourCostExpediteValue"));
                    ActualLable("Our Cost Expedite value is given as ' "+SearchColumnText("ourCostExpediteValue"), "Pass");
                }
                String[]  RulesTexts = {"Product Rule Under Our Cost", "Family Rule Under Our Cost","Discount Type Rule Under Our Cost","Manufacturer Rule Under Our Cost","Category Rule Under Our Cost"};
                By[] RulesXpaths = {ProductRuleUnderOurCost, FamilyRuleUnderOurCost,DiscountTypeRuleUnderOurCost,ManufacturerRuleUnderOurCost,CategoryRuleUnderOurCost};
                String[]  ourCostProductRule = {"ourCostProductRule","ourCostFamilyRule","ourCostDiscountCodeRule","ourCostManufactureRule","ourCostCategoryRule"};
                for (int i = 0; i <= 4; i++) {
                    String ExpectedStatusOfRule =SearchColumnText(ourCostProductRule[i]);
                    ExpectedLable("Check that ' "+RulesTexts[i]+" ' is applied or not ?");
                    if (ExpectedStatusOfRule.contentEquals("Yes")) {
                        if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                            ActualLable("' "+RulesTexts[i]+" ' is applied", "Pass");
                            clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog);
                        } else {   ActualLable(""+RulesTexts[i]+" link is not available ", "Fail");     }
                    } else {  ActualLable(" ' "+RulesTexts[i]+" ' is not applied", "Pass");   }
                }
            }
        }else{ActualLable("Catalogs not found in Out cast section", "Fail");}
    }
    public static boolean UpdateCustomerCatalogsAndPricing(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException{
        boolean updateDetails =false;
        AssignCatalogsToBuyer(driver);
        SetValuesToPriceScheme(driver);
        SetValuesToOurCost(driver);
        ExpectedLable("Click on Update button to save Customer catalog and pricing details");
        if(SizeOfTheElement(driver,UpdateCatalogAndPricing)>0){
            clickOnElement(driver,UpdateCatalogAndPricing);
            updateDetails=true;
            ActualLable(" Successfully clicked on update button for Customer catalog and pricing page", "Pass");
            SetCostFactors(driver);
        }else {  ActualLable(" Update button is not available on Customer catalog and pricing page", "Fail");    }
        return updateDetails;
    }
    public static void SetCostFactors(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException{
        StepLable("Set values to Cost Factores ");
        ExpectedLable("Click on Cost Factors link and check Assert for Cost Factors page");
        if (SizeOfTheElement(driver, CostFactorsLink) > 0) {
            clickOnElement(driver, CostFactorsLink);
            Thread.sleep(1000);
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Cost Factors")){
                ActualLable("successfully clicked on Cost Factors and verified Assert for Cost Factors Page ","Pass");
                boolean RegionSelectStatus = false;
                if (SizeOfTheElement(driver, CatalogInCostFactors) > 0) {
                    int NoOfAvaiCat = SizeOfTheElement(driver, CatalogInCostFactors);
                    String RegionConfig = SearchColumnText("useRegionConfigOption");
                    ExpectedLable("Verify ' Region Configuration ' settings for ' cost factors ' need to select or not ?");
                    if(RegionConfig.contentEquals("No")){
                        ActualLable("No need of ' Region Configuration ' settings for ' cost factors ' ","Pass");
                        ExpectedLable("Check that ' Region Configuration ' settings check box is selected or not ?");
                        if(GetElement(driver,RegionConfigurationCheckBox).isSelected()){
                            ActualLable("' Region Configuration ' settings check box is selected","Pass");
                            ExpectedLable("Now un select the check box for ' Region Configuration '");
                            clickOnElement(driver,RegionConfigurationCheckBox);
                            ActualLable("Successfully un selected the check box for ' Region Configuration '","Pass");
                            ExpectedLable("Now Click on Update ");
                            clickOnElement(driver,UpdateCostFactorsButton);
                            ActualLable("Successfully clicked on update button","Pass");
                            Thread.sleep(1000);
                            RegionSelectStatus=true;
                        }else{
                            ActualLable("' Region Configuration ' settings check box is not selected","Pass");
                            RegionSelectStatus=true;
                        }
                    }else{ActualLable(" ' Region Configuration ' settings for ' cost factors ' need to select","Pass");
                        ExpectedLable("Check that ' Region Configuration ' settings check box is selected or not ?");
                        if(GetElement(driver,RegionConfigurationCheckBox).isSelected()){
                            ActualLable("' Region Configuration ' settings check box is already selected","Pass");
                            RegionSelectStatus=false;
                        }else{
                            ActualLable("' Region Configuration ' settings check box is not selected","Pass");
                            ExpectedLable("Now select the check box for ' Region Configuration '");
                            clickOnElement(driver,RegionConfigurationCheckBox);
                            ActualLable("Successfully selected the check box for ' Region Configuration '","Pass");
                            ExpectedLable("Now Click on Update ");
                            clickOnElement(driver,UpdateCostFactorsButton);
                            ActualLable("Successfully clicked on update button","Pass");
                            Thread.sleep(1000);
                            RegionSelectStatus=false;
                        }
                    }
                    if(RegionSelectStatus==true){
                        int indexOfCatelog = 0;
                        boolean statusOfCatalog = false;
                        ExpectedLable("Verify Catalog name is available under Our Cost Scheme ");
                        String CatName = SearchColumnText("catalogName");
                        for (int i = 0; i <= NoOfAvaiCat - 1; i++) {
                            String ExpectedCatName = GetMultipleElementList(driver, CatalogInCostFactors).get(i).getText();
                            if (ExpectedCatName.contentEquals(CatName)) {
                                statusOfCatalog = true;
                                indexOfCatelog = i;
                                ActualLable(CatName + " Catalog is available", "Pass");
                                break;
                            }
                        }
                        if (statusOfCatalog == false) {  ActualLable(CatName + " Catalog is not available under Our Cost Scheme", "Fail");   }
                        if(statusOfCatalog == true){
                            String[] CostFactors ={"Cost Factor1","Cost Factor2","Cost Factor3","Cost Factor4","Cost Factor5","Surcharge"};
                            String[] CostFactorsInTestData ={"costFactorValue1","costFactorValue2","costFactorValue3","costFactorValue4","costFactorValue5","costFactorSurcharge"};
                            for(int i=3;i<=8;i++) {
                                By CatalogInCostFactors = By.xpath("//td["+i+"][@class='ListAltRow1']/input/parent::td/input");
                                String StringInExcel = SearchColumnText(CostFactorsInTestData[i-3]);
                                ExpectedLable("Set ' "+CostFactors[i-3]+" ' value as ' "+StringInExcel+" ' given in the test data ");
                                if(GetMultipleElementList(driver, CatalogInCostFactors).get(indexOfCatelog).isEnabled()){
                                    GetMultipleElementList(driver, CatalogInCostFactors).get(indexOfCatelog).clear();
                                    GetMultipleElementList(driver, CatalogInCostFactors).get(indexOfCatelog).sendKeys(StringInExcel);
                                    ActualLable("' "+CostFactors[i-3]+" ' value is successfully entered", "Pass");
                                }else{ActualLable("' "+CostFactors[i-3]+" ' element is not enabled", "Fail");}
                            }
                            String[]  RulesTexts = {"Product Rule Under Cost Factors", "Family Rule Under Cost Factors","Discount Type Rule Under Cost Factors","Manufacturer Rule Under Cost Factors","Category Rule Under Cost Factors"};
                            By[] RulesXpaths = {ProductRuleUnderCostFactors, FamilyRuleUnderCostFactors,NCMRuleUnderCostFactors,ManufacturerRuleUnderCostFactors,CategoryRuleUnderCostFactors};
                            String[]  ourCostProductRule = {"CostFactorsProductRule","CostFactorsFamilyRule","CostFactorsDiscountCodeRule","CostFactorsManufactureRule","CostFactorsCategoryRule"};
                            for (int i = 0; i <= 4; i++) {
                                String ExpectedStatusOfRule =SearchColumnText(ourCostProductRule[i]);
                                ExpectedLable("Check that ' "+RulesTexts[i]+" ' is applied or not ?");
                                if (ExpectedStatusOfRule.contentEquals("Yes")) {
                                    if (SizeOfTheElement(driver, RulesXpaths[i]) > 0) {
                                        ActualLable("' "+RulesTexts[i]+" ' is applied", "Pass");
                                        clickOnElementFromMultipleElements(driver, RulesXpaths[i], indexOfCatelog);
                                    } else {   ActualLable(""+RulesTexts[i]+" link is not available ", "Fail");     }
                                } else {  ActualLable(" ' "+RulesTexts[i]+" ' is not applied", "Pass");   }
                            }
                            ExpectedLable("Now Click on Update ");
                            clickOnElement(driver,UpdateCostFactorsButton);
                            ActualLable("Successfully clicked on update button","Pass");
                        }
                    }
                }else{ActualLable("Catalogs not found in Cost Factors page", "Fail");}
            }else{ActualLable(" Assert verification failed for Cost Factors Page ","Fail");}
        }else{ActualLable(" Cost Factores link is not available on buyer details page","Fail");}
    }
}
