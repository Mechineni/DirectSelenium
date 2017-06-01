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
    static private By CostAndPriceTab  =By.xpath("//a[contains(text(),'Cost and Price')]");
    static private By ExpirationEmailTab  =By.xpath("//a[contains(text(),'Expiration Email')]");
    static private By AsnCountries  =By.xpath("//*[@id='AsnCountries']/option");
    static private By AvCountries  =By.xpath("//*[@id='AvCountries']/option");
    static private By UnAssignSymbol  =By.id("UNASSIGN");
    static private By AssignSymbol  =By.id("ASSIGN");
    static private By UpdateInstallCountryTab  =By.id("UPDATEBAND");





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
            clickOnElement(driver, UptimeContractMultiVendor);
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
            clickOnElement(driver, AddNewUMVContract);
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
            clickOnElement(driver,YesForPACEContract);
        }else if(SearchColumnText("PACEContract?").contentEquals("No")){
            clickOnElement(driver,NoForPACEContract);
        }
        //Uptime Contract Number
        if(SizeOfTheElement(driver,UMVContractNumber)>0) {
            ReportEvent("Pass", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is available ");
            sendInputData(driver,UMVContractNumber).sendKeys(UMVContractNumberSt);
            ReportEvent("Pass", " Provide UMV Contract number. ", " Successfully provided UMV Contract number, i.e "+UMVContractNumberSt);
            Thread.sleep(1000);
            selectDropDown(driver,UMVManufacturer).selectByVisibleText(SearchColumnText("UMVManufacturer"));
            Thread.sleep(1000);
            ReportEvent("Pass", " Select UMV Manufacturer ", " Successfully selected UMV Manufacturer, i.e "+SearchColumnText("UMVManufacturer"));
            clickOnElement(driver,CreateButtonUMVContract);
            ReportEvent("Pass", " Click on submit button to create UMV Contract ", " Successfully Clicked on Create button to complete UMV Contract");
            //MainTabUnderUMVContract(driver);
            //OrderingCountriesTabUnderUMVContract(driver);
            InstallCountriesTabUnderUMVContract(driver);
        } else{ReportEvent("Fail", "Verify existence of ' Uptime Contract Number ' blank", "' Uptime Contract Number ' blank is not available ");}

        return UMVContractNumberSt;
    }
    public static void MainTabUnderUMVContract(WebDriver driver) throws IOException, WriteException, BiffException {
        StepLable("Fill/Edit details unde main section");

        //UMV Name
        sendInputData(driver,UMVContractName).sendKeys(SearchColumnText("UMVContractName"));
        ReportEvent("Pass", "Provide ' UMV Contract Name'  ", " UMV Contract name provided, and the name is : "+SearchColumnText("UMVContractName"));
        //Is this contract available in Self-Service
        if(SearchColumnText("SelfServiceAvailable").contentEquals("Yes")){
            clickOnElement(driver,YesForSelfServiceAvailable);
            ReportEvent("Pass", " Is the ' UMV contract available in Self-Service ' ? ", " 'Yes' the UMV contract available in Self-Service.");
        }else if(SearchColumnText("SelfServiceAvailable").contentEquals("No")){
            clickOnElement(driver,NoForSelfServiceAvailable);
            ReportEvent("Pass", " Is the ' UMV contract available in Self-Service ' ? ", " 'No' the UMV contract will not be available in Self-Service.");
        }
        //How would you like to price Uptime:
        clickOnElement(driver,By.xpath("//td[contains(text(),'"+SearchColumnText("PriceUptime")+"')]/input[@id='PriceType']"));
        ReportEvent("Pass", "Select option for ' How would you like to price Uptime ?' ", "' "+SearchColumnText("PriceUptime")+" ' is selected for price Uptime. ");
        //UMV Expiration Date
        if(!(SearchColumnText("PriceUptime").contentEquals("Annual"))){
            sendInputData(driver,UMVExpireDate).sendKeys(SearchColumnText("UMVExpireDate"));
            ReportEvent("Pass", "provide' Uptime Contract Expiration Date ' ", "' "+SearchColumnText("UMVExpireDate")+" ' is the ' Uptime Contract Expiration Date ' ");
        }
        //How would you like to cost Backout:
        clickOnElement(driver,By.xpath("//td[contains(text(),'"+SearchColumnText("CostBackout")+"')]/input[@name='BackoutCostType']"));
        ReportEvent("Pass", "Select option for ' How would you like to cost Backout ?' ", "' "+SearchColumnText("CostBackout")+" ' is selected for cost Backout. ");
        //Is Backout Pro-Rated in Self-Service:
        if(SearchColumnText("ProRateBackoutForSelfSrv").contentEquals("Yes")){
            clickOnElement(driver,YesForProRateBackoutForSelfSrv);
            ReportEvent("Pass", " Is ' Backout Pro-Rated' in Self-Service ? ", " 'Yes' the ' Backout Pro-Rated ' in Self-Service.");
        }else if(SearchColumnText("ProRateBackoutForSelfSrv").contentEquals("No")){
            clickOnElement(driver,NoForProRateBackoutForSelfSrv);
            ReportEvent("Pass", " Is ' Backout Pro-Rated' in Self-Service ?", " 'No' the ' Backout Pro-Rated ' will not be available in Self-Service.");
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
            sendInputData(driver,AdditionalDays).sendKeys(SearchColumnText("AdditionalYearDays"));
            ReportEvent("Pass", "Provide no of days for field ' An additional year will be added if the number of days to the end date is less than '  ","No of days are : "+SearchColumnText("AdditionalYearDays"));
        }
        //Solution Types:
        if(SearchColumnText("SolutionTypes").contentEquals("All")){
            clickOnElement(driver,AllSolutionTypes);
            ReportEvent("Pass", " Select Solution Types  ", " ' All ' Solution types selected.");
        }else if(SearchColumnText("SolutionTypes").contentEquals("Specific")){
            clickOnElement(driver,SpecificSolutionTypes);
            ReportEvent("Pass", " Select Solution Types ", " ' Specific ' Solution types selected.");
        }
        int NoOfSLAs = Integer.parseInt(SearchColumnText("NoOfSLA"));
        //Assign SLAs
        for(int i=0;i<=NoOfSLAs-1;i++) {
            String idTxt = "Option"+(i+1);
            clickOnElement(driver, By.id(idTxt));
        }
        ReportEvent("Pass", " Select some SLAs for UMV ", " No of SLAs selected is : "+NoOfSLAs);
        //Update UMV Page
        clickOnElement(driver,UpdateMainUMVPage);
        ReportEvent("Pass", " complete all the details and Submit UMV Setup page ", " Successfully completed all the details and submitted form.");
    }

    public static void ExcludedFamiliesTabUnderUMVContract(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        clickOnElement(driver,ExcludedFamiliesTab);
    }
    public static void OrderingCountriesTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        Thread.sleep(3000);
        clickOnElement(driver,OrderingCountriesTab);
        ReportEvent("Pass", " Select ' Ordering country ' tab ", " Successfully selected ' Ordering country ' tab");
        Thread.sleep(3000);
        //Check if any assign countries are available.
        if(SizeOfTheElement(driver,AsnCountries)>1){
            int NoFAssigned = SizeOfTheElement(driver,AsnCountries);
            for(int i=1; i<=NoFAssigned;i++) {
                GetMultipleElementList(driver, AsnCountries).get(i).click();
                Thread.sleep(1000);
                clickOnElement(driver,UnAssignSymbol);
                Thread.sleep(2000);
            }
            ReportEvent("Pass", " Check any 'Ordering country' are assigned ?", " Verified, and Un-Assigned all Ordering countries. ");
        }else{ ReportEvent("Pass", " Check any 'Ordering country' are assigned ?", " Verified, no 'Ordering country' are assigned. "); }
        //Assign
        if(SizeOfTheElement(driver,AvCountries)>1){
            String st = SearchColumnText("OrderingCountries");
            String[] OrderingCountries = st.split(",");
            for(int i=0;i<OrderingCountries.length;i++) {
                clickOnElement(driver, By.xpath("//*[@id='AvCountries']/option[contains(text(),'" + OrderingCountries[i] + "')]"));
                Thread.sleep(1000);
                clickOnElement(driver, AssignSymbol);
                Thread.sleep(3000);
            }
            ReportEvent("Pass", " Assign Ordering countries ", " Successfully assigned, Assigned Ordering countries are : "+SearchColumnText("OrderingCountries"));
        }else{ ReportEvent("Fail", " Check any 'Ordering country' are Available or not", " Verified, Ordering countries are available for assign."); }
    }

    public static void InstallCountriesTabUnderUMVContract(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        Thread.sleep(3000);
        clickOnElement(driver,InstallCountriesTab);
        Thread.sleep(2000);
        ReportEvent("Pass", " Select ' Install country tab ' ", " Successfully selected  ' Install country tab '");
        String st = SearchColumnText("InstallCountry");
        String[] OrderingCountries = st.split(",");
        selectDropDown(driver,By.xpath("//b[contains(text(),'"+OrderingCountries[0]+"')]/parent::td/following-sibling::td/select[@id='Band_au']")).selectByVisibleText(""+OrderingCountries[1]+"");
        ReportEvent("Pass", " Select ' Install country, and select band value ' ", " Successfully selected  ' Install country ' as :' "+OrderingCountries[0]+"' and Band As : '"+OrderingCountries[1]+"'");
        clickOnElement(driver,UpdateInstallCountryTab);
        ReportEvent("Pass", " Now click on ' update button' to update Install country detail ", " Successfully clicked on ' update button' ");
    }

    public static void CostAndPriceTabUnderUMVContract(WebDriver driver){

    }
}
