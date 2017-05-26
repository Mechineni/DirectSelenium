package PageObject.RegionPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.clickOnElement;
import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.SearchColumnText;
import static PageObject.RegionPackage.RegionUpdatePage.SearchAndClickOnRegion;

/**
 * Created by Mamata.Mechineni on 18-May-17.
 */
public class RegionApprovalWorkflowPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    //Regions section
    static private By ApprovalWorkflowLink= By.xpath("//tr/td[@class='ListHeader']/b[3]/a");

    //Approval workflow main section
    static private By SalesOfficesLink= By.xpath("//tr/td[@class='ListHeader']/b[1]/a");
    static private By SalesOfcWF= By.xpath("//tr/td[@class='ListHeader']/b[1]/a");
    static private By RoutingRolesLink=By.xpath("//tr/td[@class='ListHeader']/b[2]/a");
    static private By WorkflowRulesLink=By.xpath("//tr/td[@class='ListHeader']/b[3]/a");
    static private By QuotingWorkflowLink=By.xpath("//tr/td[@class='ListHeader']/b[4]/a");
    static private By SubmitQuoteWFDrpd=By.xpath("//td/select[@name='swfid']");
    static private By ReSubmitQuoteWFDrpd=By.xpath("//td/select[@name='chgwfid']");
    static private By ConvertToPoWFDrpd=By.xpath("//td/select[@name='powfid']");
    static private By PostToErpWFDrpd=By.xpath("//td/select[@name='rawfid']");
    static private By UpdateBtn =By.xpath("//input[@name='UPDATE']");

    //Sales Offices Section
    static private By SalesOfcsWorkflowUpdateBtn = By.xpath("//button[1][@type='submit']");
    static private By SalesOfcsWorkflowCancelBtn = By.xpath("//button[2][@type='button']");

    //Routing Roles section
    static private By RoutingRoleCreateLink= By.xpath("//tr/td[2]/a/b[contains (text(), 'Create')]");
    static private By RoutingRoleUpdateBtn= By.xpath("//td/input[@name='ACTION']");

    //Routing Roles Create section
    static private By RoutingRoleNameTxt= By.xpath("//input[@name='LevelName']");
    static private By RoutingRoleCreateBtn= By.xpath("//input[@name='ACTION']");

    //Workflow Rules section
    static private By WorkflowRuleCreateLink= By.xpath("//tr/td[2]/a/b[contains (text(), 'Create')]");

    //Workflow Rules Create section


    //label[contains(text(),'HAR-HYD :')]/following-sibling::div/div/div/label[contains(text(),'Submit Quote Workflow')]/following-sibling::div/is-xeditable/a
    //label[contains(text(),'HAR-HYD :')]/following-sibling::div/div/div/label[contains(text(),'Submit Quote Workflow')]/following-sibling::div/is-xeditable/span/div[2]/div/div[1]/is-select/span/span/span

    //QuotingWorkflow Section

    public static void AssignSalesOfcWF(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        String SalesOfficeAdd = SearchColumnText("SalesOfcAddress");
        String SalesOfficeWF = SearchColumnText("SalesOfcWF");
        //Click on Sales Offices link
        clickOnElement(driver,SalesOfficesLink);
        Thread.sleep(50000);
        String PageTitle = GetPageTitle(driver);
        if (PageTitle.contentEquals("Sales Offices")) {
            ReportEvent("Pass","Verify that Sales Offices page is opened or not ?","Assert- Sales Offices Page is opened successfully");
            //Identifying required sales office in sales office page
            By SalesOfcsWF= By.xpath("//label[contains(text(),'"+SalesOfficeAdd+"')]/following-sibling::div/div/div/label[contains(text(),'"+SalesOfficeWF+"')]/following-sibling::div/is-xeditable/a");
            clickOnElement(driver,SalesOfcsWF);
            Thread.sleep(5000);
            //Selecting workflow rule for provided workflow path (submit/re submit/convert to po/post to erp)////li[@class='select2-results__option'][contains(text(),'Distribution quoting WF')]
            By SalesOfcWFDrpd = By.xpath("//span[@class='select2-selection select2-selection--single']");
            //li[@class='select2-results__option'][contains(text(),'Distribution quoting WF')]

            if(SizeOfTheElement(driver, SalesOfcWFDrpd)> 0 ){
                clickOnElement(driver,SalesOfcWFDrpd);
                Thread.sleep(5000);
                By DropDownValus = By.xpath("//li[@class='select2-results__option'][contains(text(),'"+SearchColumnText("SalesOfcWFName")+"')]");
                //selectDropDown(driver,SalesOfcWFDrpd).selectByVisibleText(SearchColumnText("SalesOfcWFName"));
                clickOnElement(driver,DropDownValus);
                ReportEvent("Pass","Verify that provided sales office name is available in the dropdown or not ?","Required workflow set from available options for the respective dropdown");
            }else {
                ReportEvent("Fail","Verify that provided sales office name is available in the dropdown or not ?","required work flow rule not available from respective dropdown for selection on sales offices page ");
            }
            clickOnElement(driver,SalesOfcsWorkflowUpdateBtn);
            Thread.sleep(5000);
            if(SizeOfTheElement(driver, SalesOfcWFDrpd)> 0 ){
                ReportEvent("Fail","Verify that sales office Workflow updated or not ?","Required workflow not set");
            }else {
                ReportEvent("Pass","Verify that sales office Workflow updated or not ?","Required workflow set successfully ");
            }

        } else {
            ReportEvent("Fail","Verify that Sales Office page is opened or not ?","Assert- Sales Offices Page is not opened ");
        }
        }

}
