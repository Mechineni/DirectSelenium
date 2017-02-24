package PageObject.BuyerAdminPackage;

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
                String ExpectedCatName=GetMultipleElementList(driver, CatalogUnderPriceScheme).get(i).getText();
                if (ExpectedCatName.contentEquals(CatName)) {
                    statusOfCatalog = true;
                    indexOfCatelog = i;
                    ActualLable(CatName+" Catalog is available under Price Scheme", "Pass");
                    break;
                }
            }if(statusOfCatalog == false){ActualLable(CatName+" Catalog is not available under Price Scheme", "Fail");}
            if(statusOfCatalog == true){
                //setting price type and price value
                ExpectedLable("Select Price type as ' "+SearchColumnText("priceType")+" ' given in the test data ");
                if(SizeOfTheElement(driver, PriceTypeUnderPriceScheme) > 0){
                    selectDropDownFromMultipleElements(driver,PriceTypeUnderPriceScheme,indexOfCatelog).selectByVisibleText(SearchColumnText("priceType"));
                    ActualLable("Price type is provided as given test data", "Pass");}
                ExpectedLable("Set Price discount value as ' "+SearchColumnText("priceSchemaValue")+" ' given in the test data ");
                if(SizeOfTheElement(driver, PriceValueUnderPriceScheme) > 0){
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).clear();
                    GetMultipleElementList(driver, PriceValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("priceSchemaValue"));
                    ActualLable("Price discount value is provided as given test data", "Pass");}
                //Checking ' Expedite value ' is provided or not if yes provide % of expedite value
                ExpectedLable("Check that ' Expedite value ' is provided or not if yes provide % of expedite value");
                if(SizeOfTheElement(driver, ExpediteOptionUnderPriceScheme) > 0){
                    if(SearchColumnText("expediteValue").contentEquals("Yes")){
                        clickOnElement(driver,ExpediteOptionUnderPriceScheme);
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).clear();
                        GetMultipleElementList(driver, ExpediteValueUnderPriceScheme).get(indexOfCatelog).sendKeys(SearchColumnText("expediteValue"));
                        ActualLable("Expedite value is given as ' "+SearchColumnText("expediteValue"), "Pass");
                    }else{ActualLable("Expedite value is not selected ", "Pass");}  }

                ExpectedLable("Select Round price type as ' "+SearchColumnText("Round Price")+" ' given in the test data ");
                if(SizeOfTheElement(driver, RoundPriceUnderPriceScheme) > 0){
                    selectDropDownFromMultipleElements(driver,RoundPriceUnderPriceScheme,indexOfCatelog).selectByVisibleText(SearchColumnText("Round Price"));
                    ActualLable("Round price type is provided as given test data", "Pass");}
                ExpectedLable("Check that ' Product Rule ' is applied or not ?");
                if(SearchColumnText("Product Rule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, ProductRuleUnderPriceScheme) > 0){
                        ActualLable("' Product Rule ' is applied", "Pass");
                        clickOnElementFromMultipleElements(driver,ProductRuleUnderPriceScheme,indexOfCatelog);}
                    else{ActualLable("Product rule link is not available ","Fail");}}
                else{ActualLable("' Product Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Family Rule ' is applied or not ?");
                if(SearchColumnText("Family Rule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, FamilyRuleUnderPriceScheme) > 0){
                        clickOnElementFromMultipleElements(driver,FamilyRuleUnderPriceScheme,indexOfCatelog);}
                    else{ActualLable("Family rule link is not available ","Pass");}}
                else{ActualLable("' Family Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Discount Code Rule ' is applied or not ?");
                if(SearchColumnText("Discount Code Rule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, DiscountCodeRuleUnderPriceScheme) > 0){
                        clickOnElementFromMultipleElements(driver,DiscountCodeRuleUnderPriceScheme,indexOfCatelog);}
                    else{ActualLable("Discount code rule link is not available ","Fail");}}
                else{ActualLable("' Discount Code Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Manufacture Rule ' is applied or not ?");
                if(SearchColumnText("Manufacture Rule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, ManufacturerRuleUnderPriceScheme) > 0){
                        clickOnElementFromMultipleElements(driver,ManufacturerRuleUnderPriceScheme,indexOfCatelog);}
                    else{ActualLable("Manufacture rule link is not available ","Fail");}}
                else{ActualLable("' Manufacture Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Category Rule ' is applied or not ?");
                if(SearchColumnText("Category Rule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, CategoryRuleUnderPriceScheme) > 0){
                        clickOnElementFromMultipleElements(driver,ProductRuleUnderPriceScheme,indexOfCatelog);}
                    else{ActualLable("Category rule link is not available ","Fail");}}
                else{ActualLable("' Category Rule ' is not applied", "Pass");}
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

                ExpectedLable("Check that ' Product Rule ' is applied or not ?");
                if(SearchColumnText("ourCostProductRule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, ProductRuleUnderOurCost) > 0){
                        ActualLable("' Product Rule ' is applied", "Pass");
                        clickOnElementFromMultipleElements(driver,ProductRuleUnderOurCost,indexOfCatelog);}
                    else{ActualLable("Our Cost Product rule link is not available ","Fail");}}
                else{ActualLable(" Our Cost ' Product Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Family Rule ' is applied or not ?");
                if(SearchColumnText("ourCostFamilyRule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, FamilyRuleUnderOurCost) > 0){
                        clickOnElementFromMultipleElements(driver,FamilyRuleUnderOurCost,indexOfCatelog);}
                    else{ActualLable("Our Cost Family rule link is not available ","Pass");}}
                else{ActualLable("Our Cost ' Family Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Discount Code Rule ' is applied or not ?");
                if(SearchColumnText("ourCostDiscountCodeRule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, DiscountTypeRuleUnderOurCost) > 0){
                        clickOnElementFromMultipleElements(driver,DiscountTypeRuleUnderOurCost,indexOfCatelog);}
                    else{ActualLable("Our Cost Discount code rule link is not available ","Fail");}}
                else{ActualLable("Our Cost ' Discount Code Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Manufacture Rule ' is applied or not ?");
                if(SearchColumnText("ourCostManufactureRule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, ManufacturerRuleUnderOurCost) > 0){
                        clickOnElementFromMultipleElements(driver,ManufacturerRuleUnderOurCost,indexOfCatelog);}
                    else{ActualLable("Our Cost Manufacture rule link is not available ","Fail");}}
                else{ActualLable("Our Cost ' Manufacture Rule ' is not applied", "Pass");}

                ExpectedLable("Check that ' Category Rule ' is applied or not ?");
                if(SearchColumnText("ourCostCategoryRule").contentEquals("Yes")){
                    if(SizeOfTheElement(driver, CategoryRuleUnderOurCost) > 0){
                        clickOnElementFromMultipleElements(driver,CategoryRuleUnderOurCost,indexOfCatelog);}
                    else{ActualLable("Our Cost Category rule link is not available ","Fail");}}
                else{ActualLable("Our Cost ' Category Rule ' is not applied", "Pass");}
            }

        }
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
        }else {  ActualLable(" Update button is not available on Customer catalog and pricing page", "Fail");    }
        return updateDetails;
    }

}
