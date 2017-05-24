package PageObject.RegionPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetElementText;
import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.DataDriven.ReportEvent;
import static PageObject.RegionPackage.RegionUpdatePage.RegionsAssert;
import static PageObject.RegionPackage.RegionUpdatePage.SearchAndClickOnRegion;

/**
 * Created by Mamata.Mechineni on 18-May-17.
 */
public class RegionApprovalWorkflowPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By ApprovalWorkflowLink= By.xpath("//tr/td[@class='ListHeader']/b[3]/a");
    static private By SalesOfficesLink= By.xpath("//tr/td[@class='ListHeader']/b[1]/a");
    static private By RoutingRolesLink=By.xpath("//tr/td[@class='ListHeader']/b[2]/a");
    static private By WorkflowRulesLink=By.xpath("//ul[@id='cssmenu1']/li[5]/ul/li[5]/a[contains(text(),'Regions')]");
    static private By QuotingWorkflowLink=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]");
    static private By SubmitQuoteWFDrpd=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]");

    static private By EditRegionDetails=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    //WorkflowRules Section

    //QuotingWorkflow Section


    public static boolean NavigateToApprovalWorkflowLink(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        boolean Status = false;
        if(SearchAndClickOnRegion(driver)==true) {


        }
        if (GetElementText(driver,ApprovalWorkflowLink).contentEquals("REGIONS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Regions")) {
                Status = true;
                ReportEvent("Pass","Verify that Regions page is opened or not ?","Assert- Regions Page is opened successfully");
            } else {
                ReportEvent("Fail","Verify that Regions page is opened or not ?","Assert- Regions Page is not opened ");
            }
        } else {
            ReportEvent("Fail","Verify that Regions page is opened or not ?","Assert- Regions page is not loaded Properly");
        }
        return Status;
    }

}
