package PageObject.RegionPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.ActionKeywords.clickOnElement;
import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.SearchColumnText;
import static GenericLib.DataDriven.StepLable;

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
    static private By BreadCrumbApprovalWFLink = By.xpath("//a[contains(text(),'Approval Workflow')]");

    //Routing Roles section
    static private By RoutingRoleCreateLink= By.xpath("//tr/td[2]/a/b[contains (text(), 'Create')]");
    static private By RoutingRoleUpdateBtn= By.xpath("//td/input[@name='ACTION']");
    static private By RoutingRoleNameTxt= By.xpath("//input[@name='LevelName']");
    static private By RoutingRoleCreateBtn= By.xpath("//input[@name='ACTION']");
    static private By RoutingRolesList= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[3]");
    static private By RoutingRoleDeleteBtn= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[2]");
    static private By RoutingRoleDeleteConfirmBtn= By.xpath("//input[@value='Confirm']");


    //Workflow Rules section
    static private By WorkflowRulesCreateLink= By.xpath("//tr/td[2]/a/b[contains (text(), 'Create')]");

    //Workflow Rules Create section
    static private By WorkflowRuleCreateTxt= By.xpath("//input[@name='nm']");
    static private By CurrencyDrpd= By.xpath("//select[@name='lstCurrency']");
    static private By WorkFlowRuleCreateBtn= By.xpath("//input[@value='Create']");

    //Workflow update and add rules section
    static private By WorkflowList= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]");
    static private By WorkflowEditBtn= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By RulesLink= By.xpath("//b[1]/a[contains(text(),'Rules')]");
    static private By RulesCreateLink= By.xpath("//b/a[contains(text(),'CREATE')]");
    static private By CCRecipientsList= By.xpath("//td[2]/table/tbody/tr/td[@class='ListAltRow1']");
    static private By CCRecipientsChkbx= By.xpath("//td[@class='ListBorder']/table/tbody/tr[4]/td[2]/table/tbody/tr/td/input[3]");
    static private By CCRecipientsPriorityTxt= By.xpath("//td[@class='ListBorder']/table/tbody/tr[4]/td[2]/table/tbody/tr/td/input[4]");
    static private By RuleCreateBtn= By.xpath("//input[@value='Create']");
    static private By RuleExpressionsSection= By.xpath("//b[contains(text(),'Rule Expressions:')]");
    static private By AddNewLink= By.xpath("//a[contains(text(),'Add New')]");
    static private By RulesSaveBtn= By.xpath("//td/input[@name='Save']");
    static private By WorkflowDeleteBtn= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[2]");
    static private By WorkflowDeleteConfirmBtn= By.xpath("//input[@value='Confirm']");


    //Quoting Workflow section
    static private By QuotingWorkflowCreateLink= By.xpath("//a/b[contains(text(),'Create')]");
    static private By QuotingWorkflowNameTxt= By.xpath("//input[@name='nm']");
    static private By QuotingWorkflowCreateBtn= By.xpath("//input[@name='ACTION']");
    static private By WorkflowSelectingDrpd= By.xpath("//select[@id='select1']");
    static private By QuotingWorkflowList= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]");
    static private By QuotingWorkflowDeleteBtn= By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[2]");
    static private By QuotingWorkflowDeleteConfirmBtn= By.xpath("//input[@value='Confirm']");


     public static void AssignSalesOfcWF(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
         StepLable("Assiging sales offices workflow under sale offices section");
         String SalesOfficeAdd = SearchColumnText("SalesOfcAddress");
        String SalesOfficeWF = SearchColumnText("SalesOfcWF");
        //---Click on Sales Offices link
        clickOnElement(driver, SalesOfficesLink,"Sales Offices Link");
        Thread.sleep(50000);
        String PageTitle = GetPageTitle(driver);
        //---Verify sales offices page opened or not
        if (PageTitle.contentEquals("Sales Offices")) {
            ReportEvent("Pass", "Verify that Sales Offices page is opened or not ?", "Assert- Sales Offices Page is opened successfully");
            //---Identifying required sales office in sales office page
            By SalesOfcsWF = By.xpath("//label[contains(text(),'" + SalesOfficeAdd + "')]/following-sibling::div/div/div/label[contains(text(),'" + SalesOfficeWF + "')]/following-sibling::div/is-xeditable/a");
            clickOnElement(driver, SalesOfcsWF,"Sales Office Workflow");
            Thread.sleep(5000);
            //---Selecting workflow rule for provided workflow path (submit/re submit/convert to po/post to erp)
            By SalesOfcWFDrpd = By.xpath("//span[@class='select2-selection select2-selection--single']");
            if (SizeOfTheElement(driver, SalesOfcWFDrpd) > 0) {
                ReportEvent("Pass", "Verify that provided sales office name is available in the dropdown or not ?", "Required workflow '" + SearchColumnText("QuotingWFCreateName") + "' set from available options for the respective dropdown");
                clickOnElement(driver, SalesOfcWFDrpd, "Sales office drop down");
                Thread.sleep(5000);
                By SelectSalesOfficeName = By.xpath("//li[@class='select2-results__option'][contains(text(),'" + SearchColumnText("QuotingWFCreateName") + "')]");
                clickOnElement(driver, SelectSalesOfficeName,"on Sales office i.e : "+SearchColumnText("QuotingWFCreateName")+"");
            } else {
                ReportEvent("Fail", "Verify that provided sales office name is available in the dropdown or not ?", "required work flow rule '" + SearchColumnText("QuotingWFCreateName") + "' not available from respective dropdown for selection on sales offices page ");
            }
            clickOnElement(driver, SalesOfcsWorkflowUpdateBtn,"Sales Office Workflow Update Button");
            Thread.sleep(5000);
            //---Verify that workflow selected for required sales office or not
            By SalesOfficeWorkFlow = By.xpath("//label[contains(text(),'"+ SalesOfficeAdd +"')]/following-sibling::div/div/div/label[contains(text(),'"+ SalesOfficeWF +"')]/following-sibling::div/is-xeditable/a[contains(text(),'" + SearchColumnText("QuotingWFCreateName") + "')]");
            if (SizeOfTheElement(driver, SalesOfficeWorkFlow) > 0) {
                ReportEvent("Pass", "Verify that sales office Workflow updated or not ?", "Required workflow '" + SearchColumnText("QuotingWFCreateName") + "' set successfully");
            } else {
                ReportEvent("Fail", "Verify that sales office Workflow updated or not ?", "Required workflow '" + SearchColumnText("QuotingWFCreateName") + "' not set");
            }

            clickOnElement(driver,BreadCrumbApprovalWFLink,"BreadCrumb Approval WorkFlow Link");
            Thread.sleep(5000);
            String ApprovalWorkflowPageTitle = GetPageTitle(driver);
            if (ApprovalWorkflowPageTitle.contentEquals("Approval Workflow")){
                ReportEvent("Pass","Verify Approval Workflow page","Navigated back to Approval Workflow page from sales offices page");
            }else {
                ReportEvent("Fail","Verify Approval Workflow page"," Error in navigating back to Approval workflow page from sales offices page");
            }

        } else {
            ReportEvent("Fail", "Verify that Sales Office page is opened or not ?", "Assert- Sales Offices Page is not opened ");
        }
    }

    public static void CreateAndUpdateRoutingRole(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Create and update Routing roles under Routing Roles section");
        //---Click on Routing roles link
        clickOnElement(driver,RoutingRolesLink,"Routing Roles Link");
        Thread.sleep(1000);
        String PageTitle = GetPageTitle(driver);
        //---Verify routing roles page opened or not
        if (PageTitle.contentEquals("Routing Roles")) {
            ReportEvent("Pass","Verify that Routing Roles page is opened or not ?","Assert- Routing Roles Page is opened successfully");
            clickOnElement(driver,RoutingRoleCreateLink,"Create Routing Role Link");
            Thread.sleep(1000);
            String CreatePageTitle = GetPageTitle(driver);
            //---Verify routing roles create page opened or not
            if (CreatePageTitle.contentEquals("Create")) {
                ReportEvent("Pass","Verify that Routing Roles create page is opened or not ?","Assert- Routing Roles create Page is opened successfully");
                sendInputData(driver, RoutingRoleNameTxt,SearchColumnText("RoutingRoleName"),"Routing Role Name");
                clickOnElement(driver,RoutingRoleCreateBtn,"Create Routing Role Button");
            } else {
                ReportEvent("Fail","Verify that Routing Roles create page is opened or not ?","Assert- Routing Roles create Page is not opened ");
            }
            clickOnElement(driver,RoutingRoleUpdateBtn,"Routing Role Update Btn");
            //Routing role created successfully or not
            By RoutingRole=By.xpath("//td[contains(text(),'"+SearchColumnText("RoutingRoleName")+"')]");
            if (SizeOfTheElement(driver, RoutingRole)> 0){
                ReportEvent("Pass","Verify that Routing Role created successfully or not","Routing Role '"+SearchColumnText("RoutingRoleName")+"' created successfully");
            }else {
                ReportEvent("Fail","Verify that Routing Role created successfully or not","Routing Role '"+SearchColumnText("RoutingRoleName")+"' not created");
            }

            //---Navigate back to Approval workflow page
            GetBreadcrumbLink(driver,"Approval Workflow").click();
            Thread.sleep(5000);
            String ApprovalWorkflowPageTitle = GetPageTitle(driver);
            if (ApprovalWorkflowPageTitle.contentEquals("Approval Workflow")){
                ReportEvent("Pass","Verify Approval Workflow page","Navigated back to Approval Workflow page from Routing roles page");
            }else {
                ReportEvent("Fail","Verify Approval Workflow page"," Error in navigating back to Approval workflow page from Routing roles page");
            }

        } else {
            ReportEvent("Fail","Verify that Routing Roles page is opened or not ?","Assert- Routing Roles Page is not opened ");
        }
    }

    public static void CreateWorkFlowRuleAndUpdate(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Create and update Workflow rules under workflow rules section");
        //---Click on Workflow rules link
        clickOnElement(driver,WorkflowRulesLink,"Workflow Rules Link");
        Thread.sleep(1000);
        String PageTitle = GetPageTitle(driver);
        //---Verify workflow rules page opened or not
        if (PageTitle.contentEquals("Workflow Rules")) {
            ReportEvent("Pass","Verify that Workflow rules page is opened or not ?","Assert- Workflow rules Page is opened successfully");
            clickOnElement(driver,WorkflowRulesCreateLink,"Create Workflow Rules Link");
            Thread.sleep(1000);
            String CreatePageTitle = GetPageTitle(driver);
            //---Verify workflow create page opened or not
            if (CreatePageTitle.contentEquals("Create")) {
                ReportEvent("Pass","Verify that Workflow rule create page is opened or not ?","Assert- Workflow rule create Page is opened successfully");
                sendInputData(driver, WorkflowRuleCreateTxt,SearchColumnText("WFCreateName"),"Workflow Name");
                selectDropDownByVisibletxt(driver, CurrencyDrpd,SearchColumnText("Currency"),"Currency");
                clickOnElement(driver,WorkFlowRuleCreateBtn,"Create WorkFlow Rule Button");
            } else {
                ReportEvent("Fail","Verify that Workflow rule create page is opened or not ?","Assert- Workflow rule create Page is not opened ");
            }
            //---Verify Workflow rules created or not
            By WorkflowRuleVerify=By.xpath("//td[contains(text(),'"+SearchColumnText("WFCreateName")+"')]");
            if (SizeOfTheElement(driver, WorkflowRuleVerify)> 0){
                ReportEvent("Pass","Verify that Workflow rule created successfully or not","Workflow rule '"+SearchColumnText("WFCreateName")+"' created successfully");
            }else {
                ReportEvent("Fail","Verify that Workflow rule created successfully or not","Workflow rule '"+SearchColumnText("WFCreateName")+"' not created");
            }
            //---Edit created workflow
             int NoOfResultWorkflowlist = SizeOfTheElement(driver, WorkflowList);
            for (int i = 0; i <= NoOfResultWorkflowlist-1; i++) {
                if (GetMultipleElementList(driver,WorkflowList).get(i).getText().contentEquals(SearchColumnText("WFCreateName"))) {
                    //---Required workflow name found, click on edit button
                    GetMultipleElementList(driver,WorkflowEditBtn).get(i-1).click();
                    Thread.sleep(2000);
                    String WorkflowUpdatePageTitle = GetPageTitle(driver);
                    if (WorkflowUpdatePageTitle.contentEquals("Update")){
                        ReportEvent("Pass","Verify Workflow update page","Workflow '"+SearchColumnText("WFCreateName")+"' update page opened successfully ");
                    }else {
                        ReportEvent("Fail","Verify Workflow update page"," Assert verification failed for Workflow '"+SearchColumnText("WFCreateName")+"' update Page ");
                    }
                    break;
                }
            }
            //---Click on Rules link
            clickOnElement(driver,RulesLink,"'Rules Link' On Work flow page");
            String RulesPageTitle=GetPageTitle(driver);
            //---Verify rules page
            if(RulesPageTitle.contentEquals("Rules")){
                ReportEvent("Pass","Verify that Rules page opened or not","Rules page opened successfully");
            }else{
                ReportEvent("Fail","Verify that Rules page opened or not","Rules page not opened");
            }
            //---Click on rules create link
            clickOnElement(driver,RulesCreateLink,"Create Rules Link");
            Thread.sleep(2000);
            String RulesCreatePageTitle=GetPageTitle(driver);
            //---Verify rules page
            if(RulesCreatePageTitle.contentEquals("Rule")){
                ReportEvent("Pass","Verify that Rules create page opened or not","Rules create page opened successfully");
            }else{
                ReportEvent("Fail","Verify that Rules create page opened or not","Rules create page not opened");
            }

            //--- Selecting CC Receipents list
            int NoOfResultCCReceipentsList = SizeOfTheElement(driver, CCRecipientsList);
            for (int i = 0; i <= NoOfResultCCReceipentsList-1; i++) {
                String CCReceipentsTestDataName = SearchColumnText("RoutingRoleName");
                String CCReceipentsExpName = GetMultipleElementList(driver,CCRecipientsList).get(i).getText();
                //---Performed trim to compare
                String afterTrim = CCReceipentsExpName.replaceAll("^\\s+|\\s+$","");
                 //---Select CC receipents on Rules create page
                if (afterTrim.contentEquals(CCReceipentsTestDataName)) {
                    //---Required region name found, click on edit button
                    GetMultipleElementList(driver,CCRecipientsChkbx).get(i-1).click();
                    GetMultipleElementList(driver,CCRecipientsPriorityTxt).get(i-1).sendKeys("1");

                    Thread.sleep(2000);
                    clickOnElement(driver,RuleCreateBtn,"Create Rule button");
                    //---Verify Rule addition section displayed or not
                     if (SizeOfTheElement(driver, RuleExpressionsSection) > 0){
                         ReportEvent("Pass","Verify Rules addition section","Rules addition section opened successfully ");
                         clickOnElement(driver,AddNewLink, "'Add New Rule' Link");
                    }else {
                        ReportEvent("Fail","Verify Rules addition section"," Assert verification failed for Rules addition section ");
                    }
                    break;
                }
            }

            String AddNewPageTitle=GetPageTitle(driver);
            //---Open rules page and add new rules to workflow
            if(AddNewPageTitle.contentEquals("Rule")){
                ReportEvent("Pass","Verify that Add new Rules page opened or not","Add new Rules page opened successfully");
                By SelectRule = By.xpath("//b[contains(text(),'"+SearchColumnText("Rule")+"')]/preceding-sibling::input[@name='RuleType']");
                clickOnElement(driver, SelectRule,"SelectRule");
                clickOnElement(driver, RulesSaveBtn,"'Save Rule' Button");
            }else{
                ReportEvent("Fail","Verify that Add new Rules page opened or not","Add new Rules page not opened");
            }
            //---Verify rule created or not
            By VerifyRule=By.xpath("//b[contains(text(),'"+SearchColumnText("Rule")+"')]");
            if (SizeOfTheElement(driver, VerifyRule) > 0) {
                ReportEvent("Pass", "Verify that selected rule added to workflow or not ?", "Selected rule '" + SearchColumnText("Rule") + "' added to the workflow");
            } else {
                ReportEvent("Fail", "Verify that selected rule added to workflow or not ?", "Selected rule '" + SearchColumnText("Rule") + "' not added to the workflow");
            }
            //---Navigate back to Approval workflow page
            Thread.sleep(5000);
            GetBreadcrumbLink(driver,"Approval Workflow").click();
            Thread.sleep(5000);
            String ApprovalWorkflowPageTitle = GetPageTitle(driver);
            if (ApprovalWorkflowPageTitle.contentEquals("Approval Workflow")){
                ReportEvent("Pass","Verify Approval Workflow page","Navigated back to Approval Workflow page from Workflow rules page");
            }else {
                ReportEvent("Fail","Verify Approval Workflow page"," Error in navigating back to Approval workflow page from Workflow rules page");
            }
        } else {
            ReportEvent("Fail","Verify that Workflow rules page is opened or not ?","Assert- Workflow rules Page is not opened ");
        }
    }


    public static void CreateAndUpdateQuotingWorkflow(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Create and update Quoting workflow under quoting workflow section");
        //---Click on QuotingWorkflow link
        clickOnElement(driver,QuotingWorkflowLink,"'Quoting Workflow' Link");
        Thread.sleep(1000);
        String PageTitle = GetPageTitle(driver);
        //---Verify workflow rules page opened or not
        if (PageTitle.contentEquals("Quoting Workflow")) {
            ReportEvent("Pass","Verify that Quoting Workflow page is opened or not ?","Assert- Quoting Workflow Page is opened successfully");
            clickOnElement(driver,QuotingWorkflowCreateLink,"'Create Quoting Workflow' Link");
            Thread.sleep(50000);
            String CreatePageTitle = GetPageTitle(driver);
            //---Verify workflow create page opened or not
            if (CreatePageTitle.contentEquals("Create")) {
                ReportEvent("Pass","Verify that Quoting Workflow create page is opened or not ?","Assert- Quoting Workflow create Page is opened successfully");

                sendInputData(driver, QuotingWorkflowNameTxt,SearchColumnText("QuotingWFCreateName"),"'New Quoting WorkFlow' Name");
                By ApproverDrpd= By.xpath("//td/b[contains(text(),'"+SearchColumnText("RoutingRoleName")+"')]/parent::td/following-sibling::td/select");
                selectDropDownByVisibletxt(driver,WorkflowSelectingDrpd,SearchColumnText("WFCreateName"),"Work Flow Name");
                selectDropDownByVisibletxt(driver,ApproverDrpd,SearchColumnText("Approver"),"Approver");
                clickOnElement(driver,QuotingWorkflowCreateBtn,"Create Quoting Workflow Button");
                Thread.sleep(2000);

            } else {
                ReportEvent("Fail","Verify that Quoting Workflow create page is opened or not ?","Assert-Quoting Workflow rule create Page is not opened ");
            }

            //---Verify Quoting Workflow created or not
            By QuotingWorkflowVerify=By.xpath("//td[contains(text(),'"+SearchColumnText("QuotingWFCreateName")+"')]");
            if (SizeOfTheElement(driver, QuotingWorkflowVerify)> 0){
                ReportEvent("Pass","Verify that Quoting Workflow created successfully or not","Quoting Workflow '"+SearchColumnText("QuotingWFCreateName")+"' created successfully");
            }else {
                ReportEvent("Fail","Verify that Quoting Workflow created successfully or not","Quoting Workflow '"+SearchColumnText("QuotingWFCreateName")+"' not created");
            }

            //---Navigate back to Approval workflow page
            GetBreadcrumbLink(driver,"Approval Workflow").click();
            Thread.sleep(5000);
            String ApprovalWorkflowPageTitle = GetPageTitle(driver);
            if (ApprovalWorkflowPageTitle.contentEquals("Approval Workflow")){
                ReportEvent("Pass","Verify Approval Workflow page","Navigated back to Approval Workflow page from Quoting workflow page");
            }else {
                ReportEvent("Fail","Verify Approval Workflow page"," Error in navigating back to Approval workflow page from Quoting workflow page");
            }

        } else {
            ReportEvent("Fail","Verify that Quoting Workflow page is opened or not ?","Assert- Quoting Workflow Page is not opened ");
        }

    }

    public static void DeleteQuotingWorkflow(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Deleting Quoting workflow setup");
        //---Click on Quoting workflow link
        clickOnElement(driver,QuotingWorkflowLink,"Quoting Workflow Link");
        Thread.sleep(1000);
        //---Delete Quoting Workflow setup
        int NoOfResultQuotingWorkflowlist = SizeOfTheElement(driver, QuotingWorkflowList);
        for (int i = 0; i <= NoOfResultQuotingWorkflowlist-1; i++) {
            if (GetMultipleElementList(driver, QuotingWorkflowList).get(i).getText().contentEquals(SearchColumnText("QuotingWFCreateName"))) {
                //---Required quoting workflow name found, click on edit button
                GetMultipleElementList(driver, QuotingWorkflowDeleteBtn).get(i - 1).click();
                Thread.sleep(2000);
                //---Verify quote workflow delete page and click on confirm
                String QuotingWorkflowPageTitle = GetPageTitle(driver);
                if (QuotingWorkflowPageTitle.contentEquals("Delete")){
                    ReportEvent("Pass","Verify Quoting Workflow delete page","Quoting workflow delete page opened successfully ");
                    clickOnElement(driver,QuotingWorkflowDeleteConfirmBtn,"Confirm Delete Quoting Workflow Button");
                }else {
                    ReportEvent("Fail","Verify Quoting Workflow delete page"," Assert verification failed for Quoting Workflow delete Page ");
                }
                break;
            }
        }
        //---Verify selected Quoting workflow deleted or not
        boolean result = false;
        int NoOfResultAfterDeleteQuotingWFlist = SizeOfTheElement(driver, QuotingWorkflowList);
        for (int i = 0; i <= NoOfResultAfterDeleteQuotingWFlist-1; i++) {
            if (GetMultipleElementList(driver, QuotingWorkflowList).get(i).getText().contentEquals(SearchColumnText("QuotingWFCreateName"))) {
                result=true;
                break;
            }
        }
        if(result==true) {
            ReportEvent("Fail", "Verify Quoting Workflow update page", "Quoting Workflow '" + SearchColumnText("QuotingWFCreateName") + "' not deleted ");
        }else {
            ReportEvent("Pass", "Verify Quoting Workflow update page", " Quoting Workflow '" + SearchColumnText("QuotingWFCreateName") + "' deleted successfully ");
        }
        GetBreadcrumbLink(driver,"Approval Workflow").click();
        Thread.sleep(2000);

    }

    public static void DeleteWorkflowRule(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Deleting workflow rule setup");
        //---Click on workflow rules link
        clickOnElement(driver,WorkflowRulesLink,"Workflow Rules Link");
        Thread.sleep(1000);
        //---Delete Quoting Workflow setup
        int NoOfResultWorkflowRuleslist = SizeOfTheElement(driver, WorkflowList);
        for (int i = 0; i <= NoOfResultWorkflowRuleslist-1; i++) {
            if (GetMultipleElementList(driver, WorkflowList).get(i).getText().contentEquals(SearchColumnText("WFCreateName"))) {
                //---Required workflow name found, click on edit button
                GetMultipleElementList(driver, WorkflowDeleteBtn).get(i - 1).click();
                Thread.sleep(2000);
                //---Verify workflow rules delete page and click on confirm
                String WorkflowRulesPageTitle = GetPageTitle(driver);
                if (WorkflowRulesPageTitle.contentEquals("Delete")){
                    ReportEvent("Pass","Verify Workflow rules delete page","Workflow rules delete page opened successfully ");
                    clickOnElement(driver,WorkflowDeleteConfirmBtn,"Confirm Delete Workflow Button");
                }else {
                    ReportEvent("Fail","Verify Workflow rules delete page"," Assert verification failed for Workflow rules delete Page ");
                }
                break;
            }
        }
        //---Verify selected workflow rules deleted or not
        boolean result = false;
        int NoOfResultAfterDeleteWorkflowRuleslist = SizeOfTheElement(driver, WorkflowList);
        for (int i = 0; i <= NoOfResultAfterDeleteWorkflowRuleslist-1; i++) {
            if (GetMultipleElementList(driver, WorkflowList).get(i).getText().contentEquals(SearchColumnText("WFCreateName"))) {
                result=true;
                break;
            }
        }
        if(result==true) {
            ReportEvent("Fail", "Verify Workflow update page", "Workflow '" + SearchColumnText("WFCreateName") + "' not deleted ");
        }else {
            ReportEvent("Pass", "Verify Workflow update page", " Workflow '" + SearchColumnText("WFCreateName") + "' deleted successfully ");
        }
        GetBreadcrumbLink(driver,"Approval Workflow").click();
        Thread.sleep(2000);
    }

    public static void DeleteRoutingRole(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Deleting Routing role setup");
        //---Click on Routing roles link
        clickOnElement(driver,RoutingRolesLink,"Routing Roles Link");
        Thread.sleep(1000);
        //---Delete Routing roles setup
        int NoOfResultRoutingRoleslist = SizeOfTheElement(driver, RoutingRolesList);
        for (int i = 0; i <= NoOfResultRoutingRoleslist-1; i++) {
            if (GetMultipleElementList(driver, RoutingRolesList).get(i).getText().contentEquals(SearchColumnText("RoutingRoleName"))) {
                //---Required routing role found, click on edit button
                GetMultipleElementList(driver, RoutingRoleDeleteBtn).get(i-1).click();
                Thread.sleep(2000);
                //---Verify delete routing roles page and confirm
                String RoutingRolesPageTitle = GetPageTitle(driver);
                if (RoutingRolesPageTitle.contentEquals("Delete")){
                    ReportEvent("Pass","Verify Routing role delete page","Routing role delete page opened successfully ");
                    clickOnElement(driver,RoutingRoleDeleteConfirmBtn,"Delete Routing Role Btn");
                    Thread.sleep(2000);
                }else {
                    ReportEvent("Fail","Verify Routing role delete  page"," Assert verification failed for Routing role delete Page ");
                }
                break;
            }
        }
        boolean result = false;
        //---Verify selected routing role deleted or not
        int NoOfResultAfterDeleteRoutingRoleslist = SizeOfTheElement(driver, RoutingRolesList);
        for (int i = 0; i <= NoOfResultAfterDeleteRoutingRoleslist-1; i++) {
            if (GetMultipleElementList(driver, RoutingRolesList).get(i).getText().contentEquals(SearchColumnText("RoutingRoleName"))) {
                result=true;
                break;
            }
        }
        if(result==true) {
            ReportEvent("Fail", "Verify Routing role page", " Routing role '" + SearchColumnText("RoutingRoleName") + "' deleted successfully ");
        }else {
            ReportEvent("Pass", "Verify Routing role page", " Routing role '" + SearchColumnText("RoutingRoleName") + "' deleted successfully ");
        }
        GetBreadcrumbLink(driver,"Approval Workflow").click();
        Thread.sleep(2000);
    }

    public static void SelectApprovalWorkflow(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Select Approval workflow");
        String ApprovalWorkflow=SearchColumnText("SalesOfcWF");
        if (ApprovalWorkflow.contentEquals("Submit Quote Workflow")){
            //---Select 'Submit Quote Workflow'
            selectDropDownByVisibletxt(driver,SubmitQuoteWFDrpd,SearchColumnText("QuotingWFCreateName"),"Quoting Working Flow Name");
            clickOnElement(driver,UpdateBtn,"Update Button");
            ReportEvent("Pass", "Verify that required workflow selected for 'Submit Quote Workflow' or not", " Workflow '" + SearchColumnText("QuotingWFCreateName") + "' set successfully ");
        }else if (ApprovalWorkflow.contentEquals("Re-Submit Quote Workflow")){
            //---Select 'Re-Submit Quote Workflow'
            selectDropDownByVisibletxt(driver,ReSubmitQuoteWFDrpd,SearchColumnText("QuotingWFCreateName"),"Quoting Working Flow Name");
            clickOnElement(driver,UpdateBtn,"Update Button");
            ReportEvent("Pass", "Verify that required workflow selected for 'Re-Submit Quote Workflow' or not", " Workflow '" + SearchColumnText("QuotingWFCreateName") + "' set successfully ");
        }else if (ApprovalWorkflow.contentEquals("Convert to PO Workflow")){
            //---Select 'Convert to PO Workflow'
            selectDropDownByVisibletxt(driver,ConvertToPoWFDrpd,SearchColumnText("QuotingWFCreateName"),"Quoting Working Flow Name");
            clickOnElement(driver,UpdateBtn,"Update Button");
            ReportEvent("Pass", "Verify that required workflow selected for 'Convert to PO Workflow' or not", " Workflow '" + SearchColumnText("QuotingWFCreateName") + "' set successfully ");
        }else if (ApprovalWorkflow.contentEquals("Post to ERP Workflow")){
            //---Select 'Post to ERP Workflow'
            selectDropDownByVisibletxt(driver,PostToErpWFDrpd,SearchColumnText("QuotingWFCreateName"),"Quoting Working Flow Name");
            clickOnElement(driver,UpdateBtn,"Update Button");
            ReportEvent("Pass", "Verify that required workflow selected for 'Post to ERP Workflow' or not", " Workflow '" + SearchColumnText("QuotingWFCreateName") + "' set successfully ");
        }else {
            ReportEvent("Fail", "Verify that required workflow selected successfully or not", " Workflow '" + SearchColumnText("QuotingWFCreateName") + "' not set");
        }
        Thread.sleep(2000);

    }

}
