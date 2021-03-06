package PageObject.BuyerDetailsPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.selectDropDownByVisibletxt;
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
        UMVContractNumberString = "UMV"+ReferenceNumberString;
        //Will this be a PACE contract?
        if(SearchColumnText("PACEContract").contentEquals("Yes")){
            clickOnElement(driver,YesForPACEContract, "Yes option For PACEContract");
        }else if(SearchColumnText("PACEContract").contentEquals("No")){
            clickOnElement(driver,NoForPACEContract,"No option For PACEContract");
        }
        //Uptime Contract Number
        if(SizeOfTheElement(driver,UMVContractNumber)>0) {
            ReportEvent("Pass", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is available ");
            sendInputData(driver,UMVContractNumber, UMVContractNumberString,"UMV Contract Number");
            Thread.sleep(1000);
            selectDropDownByVisibletxt(driver,UMVManufacturer,SearchColumnText("UMVManufacturer"),"UMV Manufacturer");
            Thread.sleep(1000);
            clickOnElement(driver,CreateButtonUMVContract,"Create Button for UMVContract");
            Thread.sleep(1000);
            MainTabUnderUMVContract(driver);
            Thread.sleep(1000);
            OrderingCountriesTabUnderUMVContract(driver);
            Thread.sleep(1000);
            InstallCountriesTabUnderUMVContract(driver);
            Thread.sleep(1000);
            CostAndPriceTabUnderUMVContract(driver);
            Thread.sleep(5000);
        } else{ReportEvent("Fail", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is not available ");}

        return UMVContractNumberString;
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

        if(SearchColumnText("PACEContract").contentEquals("Yes")){
            //What delivery model will be used to service this contract?
            for(int i=0;i<=4;i++){
                String Value= GetMultipleElementList(driver,By.id("DeliveryModel")).get(i).getAttribute("Value");
                if(Value.contentEquals(SearchColumnText("DeliveryModel"))){
                    String text =GetMultipleElementList(driver,By.xpath("//*[@id='DeliveryModel']/parent::td")).get(i).getText();
                    GetMultipleElementList(driver,By.id("DeliveryModel")).get(i).click();
                    ReportEvent("Pass", " Select 'Delivery Model' for PACE Contract ", "successfully selected for 'Delivery Model' for PACE Contract, i.e : "+text);
                    break;
                }
            }
            for(int i=0;i<=1;i++){
                String Value= GetMultipleElementList(driver,By.xpath("//*[@id='DelOwner']/td[2]/input")).get(i).getAttribute("Value");
                if(Value.contentEquals(SearchColumnText("GDC"))){
                    GetMultipleElementList(driver,By.xpath("//*[@id='DelOwner']/td[2]/input")).get(i).click();
                    ReportEvent("Pass", " Select 'GDC' for PACE Contract ", "successfully selected for 'GDC' for PACE Contract, i.e "+SearchColumnText("GDC"));
                }
            }
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
        Thread.sleep(4000);
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
        if(SearchColumnText("PACEContract").contentEquals("No")) {
            selectDropDownByVisibletxt(driver, CurrencyDropDown, SearchColumnText("UMVCurrency"), "UMV Currency");
            selectDropDownByVisibletxt(driver, CostMethodDropdown, SearchColumnText("CostMethod"), "Cost Method");
            //Select multiple options
            String[] MultipleOptions = {"MultiplePercent", "MultipleCostFactor", "RollupBackoutCost", "DoNotAllow"};
            String[] Xpath = {"IsMultiCMPerent", "IsMultiCostFacctor", "AddBackoutCost", "nochangebackout"};
            for (int i = 0; i <= 3; i++) {
                if (SearchColumnText(MultipleOptions[i]).contentEquals("Yes")) {
                    clickElement(driver, By.id(Xpath[i]));
                    ReportEvent("Pass", " is '" + MultipleOptions[i] + "' need to configure for Umv Contract", " '" + MultipleOptions[i] + "' is configured Successfully");
                } else if (SearchColumnText(MultipleOptions[i]).contentEquals("No")) {
                    ReportEvent("Pass", " is '" + MultipleOptions[i] + "' need to configure for Umv Contract", " '" + MultipleOptions[i] + "' is configured Successfully");
                }
            }
            //Provide default percentage
            if (GetElement(driver, DefaultPercent).isEnabled()) {
                ClearAField(driver, DefaultPercent);
                sendInputData(driver, DefaultPercent, SearchColumnText("DefaultPercent"), "Default Percent");
            }
            //Provide default percentage
            if (GetElement(driver, DefaultCostFactor).isEnabled()) {
                ClearAField(driver, DefaultCostFactor);
                sendInputData(driver, DefaultCostFactor, SearchColumnText("DefaultCostFactor"), "Default Cost Factor");
            }

            //Select multiple options
            String[] MultipleOptionsSellMethod = {"AllowMultipleBackouts", "MultiplePercent", "MultipleBackoutUplift", "RollupBackoutPrice", "OverrideBUMapping"};
            String[] XpathSellMethod = {"AllowMultiBackout_1", "MultiBackOutDiscount_1", "MultiBackOutUplift_1", "AddBackoutPrice_1", "OverrideBUSLA1"};

            //Select sell method
            selectDropDownByVisibletxt(driver, By.id("PriceScheme_1"), SearchColumnText("SellMethod"), "Sell Method");

            for (int i = 0; i <= 4; i++) {
                if (SearchColumnText(MultipleOptionsSellMethod[i]).contentEquals("Yes")) {
                    clickElement(driver, By.id(XpathSellMethod[i]));
                    ReportEvent("Pass", " is '" + MultipleOptionsSellMethod[i] + "' need to configure for Umv Contract", " '" + MultipleOptionsSellMethod[i] + "' is configured Successfully");
                } else if (SearchColumnText(MultipleOptionsSellMethod[i]).contentEquals("No")) {
                    ReportEvent("Pass", " is '" + MultipleOptionsSellMethod[i] + "' need to configure for Umv Contract", " '" + MultipleOptionsSellMethod[i] + "' is not configured");
                }
            }
            String SellFactorType = SearchColumnText("SellFactor");
            if (SellFactorType.contentEquals("SellDefaultValue")) {
                ClearAField(driver, SellDefaultPercent);
                sendInputData(driver, SellDefaultPercent, SearchColumnText("SellValue"), " Default Sell Value");
            } else if (SellFactorType.contentEquals("MinValue")) {
                ClearAField(driver, MinValueBlank);
                sendInputData(driver, MinValueBlank, SearchColumnText("SellValue"), "Minimum Value  Blank");
            }
            ReportEvent("Pass", "Provide 'Sell factor' type and Percentage", "Successfully entered data, selected Factor is : " + SellFactorType + " and Percentage is : " + SearchColumnText("SellValue"));
        }else if(SearchColumnText("PACEContract").contentEquals("Yes")){

            if (SearchColumnText("DoNotAllow").contentEquals("Yes")) {
                clickElement(driver, By.id("nochangebackout"));
                ReportEvent("Pass", " is ' DoNotAllow ' need to configure for Umv Contract", " ' DoNotAllow ' is configured Successfully");
            } else if (SearchColumnText("DoNotAllow").contentEquals("No")) {
                ReportEvent("Pass", " is 'DoNotAllow' need to configure for Umv Contract", " 'DoNotAllow' is not configured");
            }
            if (SearchColumnText("AllowMultipleBackouts").contentEquals("Yes")) {
                clickElement(driver, By.id("AllowMultiBackout_1"));
                ReportEvent("Pass", " is 'Allow Multiple Backouts' need to configure for Umv Contract", " 'Allow Multiple Backouts' is configured Successfully");
            } else if (SearchColumnText("AllowMultipleBackouts").contentEquals("No")) {
                ReportEvent("Pass", " is 'Allow Multiple Backouts' need to configure for Umv Contract", " 'Allow Multiple Backouts' is not configured");
            }
            //Cost Default Backout
            ClearAField(driver, By.id("DefaultBackoutSLACost_1_1"));
            sendInputData(driver, By.id("DefaultBackoutSLACost_1_1"), SearchColumnText("CostDefaultBackout"), " Default Backout Value");
            //Sell Vendor SLA
            ClearAField(driver, By.id("VendSLA_1_1"));
            sendInputData(driver, By.id("VendSLA_1_1"), SearchColumnText("SellVendorSLA"), " Vendor SLA value");
            //Sell Backout Uplift
            ClearAField(driver, By.id("Uplift_1_1"));
            sendInputData(driver, By.id("Uplift_1_1"), SearchColumnText("SellBackoutUplift"), " Backout Uplift value");
            //Sell Backout Uplift
            ClearAField(driver, By.id("ChargeValue_1_1"));
            sendInputData(driver, By.id("ChargeValue_1_1"), SearchColumnText("DefaultDiscount"), " Default Discount value");
        }
        //Update the details.
        clickOnElement(driver,UpdateButtonCostAndPrice,"Cost And Price Update Button");
        Thread.sleep(2000);

    }

    public static Double[] GetQuoteValuesForUMVHardware(WebDriver driver) throws WriteException, IOException, BiffException {

        //Price values of product
        String HardwareListPriceTxt = GetValueAttribute(driver, By.xpath("//b[contains(text(),'Mfr Part #: " + SearchColumnText("MfrPart") + "')]/parent::td/following-sibling::td[3]/input[1]"));
        String HardwareUnitPriceTxt = GetValueAttribute(driver, By.xpath("//b[contains(text(),'Mfr Part #: " + SearchColumnText("MfrPart") + "')]/parent::td/following-sibling::td[4]/input[1]"));
        String HardwareCostPriceTxt = GetValueAttribute(driver, By.xpath("//b[contains(text(),'Mfr Part #: " + SearchColumnText("MfrPart") + "')]/parent::td/following-sibling::td[7]/input[1]"));

        Double[] HardWareValues = {Double.parseDouble(HardwareListPriceTxt), Double.parseDouble(HardwareUnitPriceTxt), Double.parseDouble(HardwareCostPriceTxt)};

        return HardWareValues;
    }
    public static Double[] GetQuoteValuesForUMVService(WebDriver driver) throws WriteException, IOException, BiffException {
        //price values of Service
        String ServiceListPriceTxt = GetValueAttribute(driver,By.xpath("//b[contains(text(),'Hardware Part #: "+SearchColumnText("MfrPart")+"')]/parent::td/following-sibling::td[3]/input[1]"));
        String ServiceUnitPriceTxt = GetValueAttribute(driver,By.xpath("//b[contains(text(),'Hardware Part #: "+SearchColumnText("MfrPart")+"')]/parent::td/following-sibling::td[4]/input[1]"));
        String ServiceCostPriceTxt = GetValueAttribute(driver,By.xpath("//b[contains(text(),'Hardware Part #: "+SearchColumnText("MfrPart")+"')]/parent::td/following-sibling::td[7]/input[1]"));
        Double[] ServiceValues = {Double.parseDouble(ServiceListPriceTxt),Double.parseDouble(ServiceUnitPriceTxt),Double.parseDouble(ServiceCostPriceTxt)};
        return ServiceValues;
    }

}
