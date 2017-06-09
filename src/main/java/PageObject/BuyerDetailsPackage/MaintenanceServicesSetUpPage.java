package PageObject.BuyerDetailsPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

import javax.xml.transform.sax.TemplatesHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.selectDropDown;
import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.SearchColumnText;
import static GenericLib.DataDriven.StepLable;

/**
 * Created by Mamata.Mechineni on 18-May-17.
 */
public class MaintenanceServicesSetUpPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By UptimeContractMultiVendor =By.xpath("(//a[contains(text(),'Uptime Contract')])[2]");
    static private By AddNewUMVContract =By.xpath("//a[contains(text(),'ADD CONTRACT')]");
    static private By YesForPACEContract =By.xpath("//input[@name='IsPace'][@value='1']");
    static private By NoForPACEContract =By.xpath("//input[@name='IsPace'][@value='0']");
    static private By UMVContractNumber =By.id("ContractNumber");
    static private By UMVManufacturer =By.id("Manufacturer");
    static private By CreateButtonUMVContract =By.id("ADD");
    static private By UMVContractName =By.id("ContractName");
    static private By YesForSelfServiceAvailable =By.xpath("//input[@id='SelfServiceAvailable'][@value='1']");
    static private By NoForSelfServiceAvailable =By.xpath("//input[@id='SelfServiceAvailable'][@value='0']");
    static private By UMVExpireDate =By.id("ExpDate");
    static private By YesForProRateBackoutForSelfSrv =By.id("ProRateBackoutForSelfSrv1");
    static private By NoForProRateBackoutForSelfSrv =By.id("ProRateBackoutForSelfSrv2");
    static private By YearWiseCheckBox =By.xpath("//td[3]/table/tbody/tr/td[1]/input[1]");
    static private By YearWiseDiscounts =By.xpath("//td[3]/table/tbody/tr/td[2]/input[1]");
    static private By AdditionalDays =By.id("NumDays");
    static private By AllSolutionTypes =By.xpath("//input[@name='SolType'][@value='1']");
    static private By SpecificSolutionTypes =By.xpath("//input[@name='SolType'][@value='0']");
    static private By UpdateMainUMVPage =By.id("UPDATE");
    static private By ExcludedFamiliesTab  =By.xpath("//a[contains(text(),'Exclude Families')]");
    static private By OrderingCountriesTab  =By.xpath("//a[contains(text(),'Ordering Countries')]");
    static private By InstallCountriesTab  =By.xpath("//a[contains(text(),'Install Countries')]");
    static private By CurrencyDropDown  =By.id("Currency");
    static private By CostAndPriceTab  =By.xpath("//a[contains(text(),'Cost and Price')]");
    static private By ExpirationEmailTab  =By.xpath("//a[contains(text(),'Expiration Email')]");
    static private By AsnCountries  =By.xpath("//*[@id='AsnCountries']/option");
    static private By AvCountries  =By.xpath("//*[@id='AvCountries']/option");
    static private By UnAssignSymbol  =By.id("UNASSIGN");
    static private By AssignSymbol  =By.id("ASSIGN");
    static private By UpdateInstallCountryTab  =By.id("UPDATEBAND");
    static private By CostMethodDropdown  =By.id("CostCalc");
    static private By DefaultPercent  =By.xpath("//*[@id='divdefcost']/parent::b/parent::td/following-sibling::td/input");
    static private By DefaultCostFactor  =By.id("CostFactor");
    static private By UpdateButtonCostAndPrice  =By.xpath("//input[@name='UPDATERULES']");
    static private By MinValueBlank  =By.id("MinValue_1_1");
    static private By SellDefaultPercent  =By.id("ChargeValue_1_1");







    public static void SetupUptimeContractMultiVendor(WebDriver driver){

        String text = GetElementText(driver,UptimeContractMultiVendor);
    }
    public static void ClickOnUptimeContractLink(WebDriver driver) throws IOException, WriteException, InterruptedException, BiffException {

        BuyerUpdatePage.ClickOnMaintenanceServicesSetUpLink(driver);
        boolean Status = false;
        Status = GetElement(driver,UptimeContractMultiVendor).isEnabled();
        if(Status == false){
            ReportEvent("Pass", "Verify Uptime Contract Multi Vendor Link is enabled ?", "Uptime Contract Multi Vendor Link is not enabled. Now set up Uptime Contract Multi Vendor settings.");
            SetupUptimeContractMultiVendor(driver);
        }else{
            ReportEvent("Pass", "Verify Uptime Contract Multi Vendor Link is enabled ?", "Uptime Contract Multi Vendor Link is enabled.");
            clickOnElement(driver, UptimeContractMultiVendor,"Uptime Contract MultiVendor Link");
            Thread.sleep(2000);
            String UMVPageTitle = GetPageTitle(driver);
            if (UMVPageTitle.contentEquals("Uptime (Multi-Vendor) Contracts")) {
                ReportEvent("Pass", "Verify that UMV Contracts page opened", "UMV Contracts page opened successfully ");
                ClickOnAddNewUMVContractLink(driver);
            }else {
                ReportEvent("Fail", "Verify that UMV Contracts page opened", "UMV Contracts page not opened");
            }
        }

    }

    public static boolean ClickOnAddNewUMVContractLink(WebDriver driver) throws IOException, WriteException, InterruptedException, BiffException {
        StepLable("Navigate to ' Add New UMV Contract ' page");
        boolean Status = false;
        if(SizeOfTheElement(driver,AddNewUMVContract)>0) {
            ReportEvent("Pass", "Verify existence of ' Add New UMV Contract ' Link", "' Add New UMV Contract ' Link is available ");
            //---Click on Add New UMV Contract Link
            clickOnElement(driver, AddNewUMVContract,"Add New UMV Contract Button");
            Thread.sleep(2000);
            String MaintenanceServicesSetUpPageTitle = GetPageTitle(driver);
            if (MaintenanceServicesSetUpPageTitle.contentEquals("Setup")) {
                ReportEvent("Pass", "Verify that ' Add New UMV Contract ' page opened", "' Add New UMV Contract ' page opened successfully ");
                CompleteUMVContractSetup(driver);
                Status = true;
            }else {
                ReportEvent("Fail", "Verify that ' Add New UMV Contract ' page opened", "' Add New UMV Contract ' page not opened");
            }
        }else {
            ReportEvent("Fail", "Verify existence of ' Add New UMV Contract ' Link", "' Add New UMV Contract ' link is not available on Buyer details page");
        }
        return Status;
    }

    public static String CompleteUMVContractSetup(WebDriver driver) throws WriteException, IOException, BiffException, InterruptedException {
        StepLable("Complete 'UMV Contract' setup.");
        Random rand = new Random();
        int  ReferenceNumbe = rand.nextInt(9999) + 1000;
        String ReferenceNumberString=Integer.toString(ReferenceNumbe);
        String UMVContractNumberSt = "UMV"+ReferenceNumberString;
        //Will this be a PACE contract?
        if(SearchColumnText("PACEContract?").contentEquals("Yes")){
            clickOnElement(driver,YesForPACEContract, "Yes option For PACEContract");
        }else if(SearchColumnText("PACEContract?").contentEquals("No")){
            clickOnElement(driver,NoForPACEContract,"No option For PACEContract");
        }
        //Uptime Contract Number
        if(SizeOfTheElement(driver,UMVContractNumber)>0) {
            ReportEvent("Pass", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is available ");
            sendInputData(driver,UMVContractNumber,UMVContractNumberSt,"UMV Contract Number");
            Thread.sleep(1000);
            selectDropDown(driver,UMVManufacturer).selectByVisibleText(SearchColumnText("UMVManufacturer"));
            Thread.sleep(1000);
            ReportEvent("Pass", " Select UMV Manufacturer ", " Successfully selected UMV Manufacturer, i.e "+SearchColumnText("UMVManufacturer"));
            clickOnElement(driver,CreateButtonUMVContract,"Create Button for UMVContract");
            MainTabUnderUMVContract(driver);
            OrderingCountriesTabUnderUMVContract(driver);
            InstallCountriesTabUnderUMVContract(driver);
            CostAndPriceTabUnderUMVContract(driver);
            Thread.sleep(5000);
        } else{ReportEvent("Fail", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is not available ");}

        return UMVContractNumberSt;
    }
    public static void MainTabUnderUMVContract(WebDriver driver) throws IOException, WriteException, BiffException {
        StepLable("Fill/Edit details unde main section");

        //UMV Name
        sendInputData(driver,UMVContractName,SearchColumnText("UMVContractName"),"UMV Contract Name");
        ReportEvent("Pass", "Provide ' UMV Contract Name'  ", " UMV Contract name provided, and the name is : "+SearchColumnText("UMVContractName"));
        //Is this contract available in Self-Service
        if(SearchColumnText("SelfServiceAvailable").contentEquals("Yes")){
            clickOnElement(driver,YesForSelfServiceAvailable,"Yes option For Self Service Available");
            ReportEvent("Pass", " Is the ' UMV contract available in Self-Service ' ? ", " 'Yes' the UMV contract available in Self-Service.");
        }else if(SearchColumnText("SelfServiceAvailable").contentEquals("No")){
            clickOnElement(driver,NoForSelfServiceAvailable,"No option For Self Service Available");
            ReportEvent("Pass", " Is the ' UMV contract available in Self-Service ' ? ", " 'No' the UMV contract will not be available in Self-Service.");
        }
        //How would you like to price Uptime:
        clickElement(driver,By.xpath("//td[contains(text(),'"+SearchColumnText("PriceUptime")+"')]/input[@id='PriceType']"));
        ReportEvent("Pass", "Select option for ' How would you like to price Uptime ?' ", "' "+SearchColumnText("PriceUptime")+" ' is selected for price Uptime. ");
        //UMV Expiration Date
        if(!(SearchColumnText("PriceUptime").contentEquals("Annual"))){
            sendInputData(driver,UMVExpireDate,SearchColumnText("UMVExpireDate"),"UMV Expire Date");
        }
        //How would you like to cost Backout:
        clickElement(driver,By.xpath("//td[contains(text(),'"+SearchColumnText("CostBackout")+"')]/input[@name='BackoutCostType']"));
        ReportEvent("Pass", "Select option for ' How would you like to cost Backout ?' ", "' "+SearchColumnText("CostBackout")+" ' is selected for cost Backout. ");
        //Is Backout Pro-Rated in Self-Service:
        if(SearchColumnText("ProRateBackoutForSelfSrv").contentEquals("Yes")){
            clickOnElement(driver,YesForProRateBackoutForSelfSrv,"Yes For ProRate Backout For Self Service");
        }else if(SearchColumnText("ProRateBackoutForSelfSrv").contentEquals("No")){
            clickOnElement(driver,NoForProRateBackoutForSelfSrv,"No For ProRate Backout For Self Service");
        }
        String[] Years ={"YearOne","YearTwo","YearThree","YearFour","YearFive","YearSix"};
        String[] YearsDiscounts ={"YearTwoDis","YearThreeDis","YearFourDis","YearFiveDis","YearSixDis"};
        //Year wise Discounts
        for(int i=0;i<=5;i++){
            if(SearchColumnText(Years[i]).contentEquals("Yes")){
                if(i==0){
                    //YearWiseCheckBox
                    if(GetMultipleElementList(driver,YearWiseCheckBox).get(i).isSelected()) {
                        ReportEvent("Pass", " Select ' Year one Discount ' check box. ", " Successfully selected ' Year one Discount ' check box.");
                    }else{GetMultipleElementList(driver, YearWiseCheckBox).get(i).click();
                        ReportEvent("Pass", " Select ' Year one Discount ' check box. ", " Successfully selected ' Year one Discount ' check box.");
                    }
                }else{
                    if(GetMultipleElementList(driver,YearWiseCheckBox).get(i).isSelected()) {
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).clear();
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).sendKeys(SearchColumnText(YearsDiscounts[i-1]));
                        ReportEvent("Pass", " Select ' "+Years[i-1]+" ' and Provide Discount percentage. ", " Successfully selected ' "+Years[i-1]+" ' and Discount % is :"+SearchColumnText(YearsDiscounts[i-1]));

                    }else{
                        GetMultipleElementList(driver, YearWiseCheckBox).get(i).click();
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).clear();
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).sendKeys(SearchColumnText(YearsDiscounts[i-1]));
                        ReportEvent("Pass", " Select ' "+Years[i-1]+" ' and Provide Discount percentage. ", " Successfully selected ' "+Years[i-1]+" ' and Discount % is :"+SearchColumnText(YearsDiscounts[i-1]));
                    }
                }
            }
            else if (SearchColumnText(Years[i]).contentEquals("No")){
                if(i==0){
                    //YearWiseCheckBox
                    if(GetMultipleElementList(driver,YearWiseCheckBox).get(i).isSelected()) {
                        GetMultipleElementList(driver, YearWiseCheckBox).get(i).click();
                        ReportEvent("Pass", "Do not provide discount for year one","Discount is not provided for Year one ");
                    }else{ReportEvent("Pass", "Do not provide discount for year one","Discount is not provided for Year one ");}
                }else{
                    if(GetMultipleElementList(driver,YearWiseCheckBox).get(i).isSelected()) {
                        GetMultipleElementList(driver, YearWiseCheckBox).get(i).click();
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).clear();
                        ReportEvent("Pass", "Do not provide discount for "+Years[i-1],"Discount is not provided for "+Years[i-1]);
                    }else{
                        GetMultipleElementList(driver,YearWiseDiscounts).get(i-1).clear();
                        ReportEvent("Pass", "Do not provide discount for "+Years[i-1],"Discount is not provided for "+Years[i-1]);
                    }
                }
            }
        }
        //An additional year will be added if the number of days to the end date is less than
        if(!(SearchColumnText("PriceUptime").contentEquals("Annual"))){
            ClearAField(driver,AdditionalDays);
            sendInputData(driver,AdditionalDays,SearchColumnText("AdditionalYearDays"),"Additional Year Days");
        }
        //Solution Types:
        if(SearchColumnText("SolutionTypes").contentEquals("All")){
            clickOnElement(driver,AllSolutionTypes,"All Solution Types Checkbox");
        }else if(SearchColumnText("SolutionTypes").contentEquals("Specific")){
            clickOnElement(driver,SpecificSolutionTypes,"Specific Solution Types");
        }
        //Assign SLAs
        GetMultipleElementList(driver, By.xpath("//td[contains(text(),'"+SearchColumnText("NameOfSLA")+"')]/preceding-sibling::td[2]/input[1]")).get(0).click();
        ReportEvent("Pass", " Select SLAs for UMV ", "successfully selected SLA with ERP Part# : "+SearchColumnText("NameOfSLA"));

        //Update UMV Page
        clickOnElement(driver,UpdateMainUMVPage,"Update Main UMVPage button");
    }

    public static void ExcludedFamiliesTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException {
        Thread.sleep(3000);
        clickOnElement(driver,ExcludedFamiliesTab,"Excluded Families Tab");
    }
    public static void OrderingCountriesTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Update Ordering Countries tab details");
        Thread.sleep(3000);
        clickOnElement(driver,OrderingCountriesTab,"Ordering Countries Tab");
        Thread.sleep(3000);
        //Check if any assign countries are available.
        if(SizeOfTheElement(driver,AsnCountries)>1){
            int NoFAssigned = SizeOfTheElement(driver,AsnCountries);
            for(int i=1; i<=NoFAssigned;i++) {
                GetMultipleElementList(driver, AsnCountries).get(i).click();
                Thread.sleep(1000);
                clickElement(driver,UnAssignSymbol);
                Thread.sleep(2000);
            }
            ReportEvent("Pass", " Check any 'Ordering country' are assigned ?", " Verified, and Un-Assigned all Ordering countries. ");
        }else{ ReportEvent("Pass", " Check any 'Ordering country' are assigned ?", " Verified, no 'Ordering country' are assigned. "); }
        //Assign
        if(SizeOfTheElement(driver,AvCountries)>1){
            String st = SearchColumnText("UMVOrderingCountries");
            String[] OrderingCountries = st.split(",");
            for(int i=0;i<OrderingCountries.length;i++) {
                clickElement(driver, By.xpath("//*[@id='AvCountries']/option[contains(text(),'" + OrderingCountries[i] + "')]"));
                Thread.sleep(1000);
                clickElement(driver, AssignSymbol);
                Thread.sleep(3000);
            }
            ReportEvent("Pass", " Assign Ordering countries ", " Successfully assigned, Assigned Ordering countries are : "+SearchColumnText("OrderingCountries"));
        }else{ ReportEvent("Fail", " Check any 'Ordering country' are Available or not", " Verified, Ordering countries are available for assign."); }
    }

    public static void InstallCountriesTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Update Install Countries tab details");
        Thread.sleep(3000);
        //click on install countries tab
        clickOnElement(driver,InstallCountriesTab,"Install Countries Tab");
        Thread.sleep(2000);
        ReportEvent("Pass", " Select ' Install country tab ' ", " Successfully selected  ' Install country tab '");
        String st = SearchColumnText("UMVInstallCountry");
        String[] OrderingCountries = st.split(",");
        selectDropDown(driver,By.xpath("//b[contains(text(),'"+OrderingCountries[0]+"')]/parent::td/following-sibling::td/select")).selectByVisibleText(""+OrderingCountries[1]+"");
        ReportEvent("Pass", " Select ' Install country, and select band value ' ", " Successfully selected  ' Install country ' as :' "+OrderingCountries[0]+"' and Band As : '"+OrderingCountries[1]+"'");
        clickOnElement(driver,UpdateInstallCountryTab,"Update button for Install Country Tab");

    }

    public static void CostAndPriceTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Update Cost and Price tab details");
        Thread.sleep(3000);
        //click on install countries tab
        clickOnElement(driver,CostAndPriceTab,"Cost And Price Tab");
        Thread.sleep(2000);
        selectDropDown(driver,CurrencyDropDown).selectByVisibleText(SearchColumnText("UMVCurrency"));
        ReportEvent("Pass", " Select 'Currency' for Umv Contract", " 'Currency' is selected Successfully, i.e "+SearchColumnText("Currency"));

        selectDropDown(driver,CostMethodDropdown).selectByVisibleText(SearchColumnText("CostMethod"));
        ReportEvent("Pass", " Select 'CostMethod ' for Umv Contract", " 'CostMethod ' is selected Successfully, i.e "+SearchColumnText("CostMethod"));

        //Select multiple options
        String[] MultipleOptions ={"MultiplePercent","MultipleCostFactor","RollupBackoutCost","DoNotAllow"};
        String[] Xpath ={"IsMultiCMPerent","IsMultiCostFacctor","AddBackoutCost","nochangebackout"};
        for(int i=0;i<=3;i++){
            if(SearchColumnText(MultipleOptions[i]).contentEquals("Yes")){
                clickElement(driver,By.id(Xpath[i]));
                ReportEvent("Pass", " is '"+MultipleOptions[i]+"' need to configure for Umv Contract", " '"+MultipleOptions[i]+"' is configured Successfully");
            }else if(SearchColumnText(MultipleOptions[i]).contentEquals("No")){
                ReportEvent("Pass", " is '"+MultipleOptions[i]+"' need to configure for Umv Contract", " '"+MultipleOptions[i]+"' is configured Successfully");
            }
        }
        //Provide default percentage
        if(GetElement(driver,DefaultPercent).isEnabled()) {
            ClearAField(driver, DefaultPercent);
            sendInputData(driver, DefaultPercent,SearchColumnText("DefaultPercent"),"Default Percent");
        }
        //Provide default percentage
        if(GetElement(driver,DefaultCostFactor).isEnabled()) {
            ClearAField(driver, DefaultCostFactor);
            sendInputData(driver, DefaultCostFactor,SearchColumnText("DefaultCostFactor"),"Default Cost Factor");
        }

        //Select multiple options
        String[] MultipleOptionsSellMethod ={"AllowMultipleBackouts","MultiplePercent","MultipleBackoutUplift","RollupBackoutPrice","OverrideBUMapping"};
        String[] XpathSellMethod ={"AllowMultiBackout_1","MultiBackOutDiscount_1","MultiBackOutUplift_1","AddBackoutPrice_1","OverrideBUSLA1"};

        //Select sell method
        selectDropDown(driver,By.id("PriceScheme_1")).selectByVisibleText(SearchColumnText("SellMethod"));
        ReportEvent("Pass","Select 'Sell Method' from drop down list","Successfully selected 'Sell Method': "+SearchColumnText("SellMethod"));

        for (int i = 0; i <= 4; i++) {
            if (SearchColumnText(MultipleOptionsSellMethod[i]).contentEquals("Yes")) {
                clickElement(driver, By.id(XpathSellMethod[i]));
                ReportEvent("Pass", " is '" + MultipleOptionsSellMethod[i] + "' need to configure for Umv Contract", " '" + MultipleOptionsSellMethod[i] + "' is configured Successfully");
            } else if (SearchColumnText(MultipleOptionsSellMethod[i]).contentEquals("No")) {
                ReportEvent("Pass", " is '" + MultipleOptionsSellMethod[i] + "' need to configure for Umv Contract", " '" + MultipleOptionsSellMethod[i] + "' is configured Successfully");
            }
        }
        String SellFactorType=SearchColumnText("SellFactor");
        if(SellFactorType.contentEquals("SellDefaultValue")){
            ClearAField(driver, SellDefaultPercent);
            sendInputData(driver,SellDefaultPercent,SearchColumnText("SellValue")," Default Sell Value");
        }else if(SellFactorType.contentEquals("MinValue")){
            ClearAField(driver, MinValueBlank);
            sendInputData(driver,MinValueBlank,SearchColumnText("SellValue"),"Minimum Value  Blank");
        }
        ReportEvent("Pass","Provide 'Sell factor' type and Percentage","Successfully entered data, selected Factor is : "+SellFactorType+" and Percentage is : "+SearchColumnText("SellValue"));

        //Update the details.
        clickOnElement(driver,UpdateButtonCostAndPrice,"Cost And Price Update Button");

    }

}
