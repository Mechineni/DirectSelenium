package LocalTestCases;

import GenericLib.Browser;
import GenericLib.DataDriven;
import GenericLib.ObjectRepository;
import PageObject.BuyerDetailsPackage.BuyerUpdatePage;
import PageObject.BuyerDetailsPackage.CustomerCatalogAndPricingPage;
import PageObject.HomePagePackage.HomePage;
import PageObject.LogInPage;
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
                BuyerUpdatePage.BuyerSearchAndEdit(driver);
                BuyerUpdatePage.ClickOnCustomerCatalogAndPricingLink(driver);
                CustomerCatalogAndPricingPage.AssignCatalogsToBuyer(driver);
                //CreateQuotePage.CreateQuote(driver);
                //CreateQuotePage.SubmitQuote(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();ReportEvent("Fail","Exception Found",error); }
    }
    @Test
    public void SC_003() throws IOException, InterruptedException, WriteException, BiffException {
        try {
            if (DataDriven.CheckingFlag("SC_003")==true) {
                LogInPage.LogInFunctionality(driver);
                HomePage.VerifyHomePageAssert(driver);
                Thread.sleep(5000);
                RegionUpdatePage.RegionSearchAndEdit(driver);
                RegionUpdatePage.ClickOnApprovalWorkflowLink(driver);
                RegionApprovalWorkflowPage.CreateAndUpdateRoutingRole(driver);
               // RegionApprovalWorkflowPage.CreateWorkFlowRuleAndUpdate(driver);
               // RegionApprovalWorkflowPage.CreateAndUpdateQuotingWorkflow(driver);
               // RegionApprovalWorkflowPage.AssignSalesOfcWF(driver);
                RegionApprovalWorkflowPage.DeleteRoutingRole(driver);
            }
        }catch (AssertionError e){ String error ="Exception : " +  e.getClass().getSimpleName();	ReportEvent("Fail","Exception Found",error);}
        catch (Exception e){ String error ="Exception : " +  e.getClass().getSimpleName();  ReportEvent("Fail","Exception Found",error); }
    }


}
