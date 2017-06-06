package LocalTestCases;

import GenericLib.Browser;
import GenericLib.DataDriven;
import GenericLib.ObjectRepository;
import PageObject.ActiveQuotePackage.ActiveQuoteActionButtons;
import PageObject.ActiveQuotePackage.CatalogPage;
import PageObject.BuyerDetailsPackage.BuyerUpdatePage;
import PageObject.BuyerDetailsPackage.CustomerCatalogAndPricingPage;
import PageObject.BuyerDetailsPackage.MaintenanceServicesSetUpPage;
import PageObject.ActiveQuotePackage.ActiveQuoteOrderDetails;
import PageObject.HomePagePackage.HomePage;
import PageObject.LogInPage;
import PageObject.QuotesPackage.CreateQuotePage;
import PageObject.RegionPackage.RegionApprovalWorkflowPage;
import PageObject.RegionPackage.RegionUpdatePage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static GenericLib.DataDriven.ReportEvent;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class SmokeSuiteTC extends Browser {

    ObjectRepository ob = new ObjectRepository();
    static Logger log = Logger.getLogger("Testing Cases");
    private WebDriver driver;
    //test

    @BeforeClass
    public void setUp() throws WriteException, IOException, BiffException {  driver = getDriver();  }


    @Test
    public void SC_001() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_001")==true) {
                LogInPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                HomePage.CheckAllTheLinks(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();ReportEvent("Fail","Exception Found",error); }
    }
    @Test
    public void SC_002() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_002")==true) {
                LogInPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                Thread.sleep(5000);
//                BuyerUpdatePage.BuyerSearchAndEdit(driver);
//                BuyerUpdatePage.ClickOnCustomerCatalogAndPricingLink(driver);
//                CustomerCatalogAndPricingPage.AssignCatalogsToBuyer(driver);
//                CustomerCatalogAndPricingPage.SetValuesToPriceScheme(driver);
//                CustomerCatalogAndPricingPage.SetZeroPriceAndExpediteBYCustomerOption(driver);
//                CustomerCatalogAndPricingPage.SetValuesToOurCost(driver);
//                CustomerCatalogAndPricingPage.UpdateCustomerCatalogsAndPricing(driver);
//                CustomerCatalogAndPricingPage.SetCostFactors(driver);
                CreateQuotePage.CreateQuote(driver);
                CreateQuotePage.SelectCountries(driver);
                ActiveQuoteOrderDetails.ClearItemsOnActiveQuote(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();ReportEvent("Fail","Exception Found",error); }
    }
    @Test
    public void SC_003() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_003")==true) {
                //---Login to application
                LogInPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                Thread.sleep(5000);
                //---Navigate to region page, and then to approval workflow page of testing region
                RegionUpdatePage.RegionSearchAndEdit(driver);
                RegionUpdatePage.ClickOnApprovalWorkflowLink(driver);
                //---Create routing role, workflow rule and quoting workflow
                RegionApprovalWorkflowPage.CreateAndUpdateRoutingRole(driver);
                RegionApprovalWorkflowPage.CreateWorkFlowRuleAndUpdate(driver);
                RegionApprovalWorkflowPage.CreateAndUpdateQuotingWorkflow(driver);
                //---Assign sales offices
                RegionApprovalWorkflowPage.AssignSalesOfcWF(driver);
                //---Select approval workflow
                RegionApprovalWorkflowPage.SelectApprovalWorkflow(driver);
                //--Create quote and submit for approval
                CreateQuotePage.CreateQuote(driver);
                CreateQuotePage.SelectCountries(driver);
                ActiveQuoteOrderDetails.ClearItemsOnActiveQuote(driver);
                CatalogPage.AddProductsToQuote(driver);
                ActiveQuoteActionButtons.SubmitQuoteForApproval(driver);
                //---Again navigate to region and delete created Quoting workflow, workflow rules and routing role
                RegionUpdatePage.RegionSearchAndEdit(driver);
                RegionUpdatePage.ClickOnApprovalWorkflowLink(driver);
                RegionApprovalWorkflowPage.DeleteQuotingWorkflow(driver);
                RegionApprovalWorkflowPage.DeleteWorkflowRule(driver);
                RegionApprovalWorkflowPage.DeleteRoutingRole(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();  ReportEvent("Fail","Exception Found",error); }
    }
    @Test
    public void SC_004() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_004")==true) {
                LogInPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                Thread.sleep(5000);
                BuyerUpdatePage.BuyerSearchAndEdit(driver);
                MaintenanceServicesSetUpPage.ClickOnUptimeContractLink(driver);


            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();  ReportEvent("Fail","Exception Found",error); }
    }

}
