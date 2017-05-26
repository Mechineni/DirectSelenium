package PageObject.RegionPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class RegionUpdatePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By RegionsAssert= By.xpath("//tr/td[@class='ListHeader']/b");
    static private By SiteAdminLink=By.xpath("//ul[@id='cssmenu1']/li[5]/a[contains(text(),'Site Admin')]");
    static private By RegionLink=By.xpath("//ul[@id='cssmenu1']/li[5]/ul/li[5]/a[contains(text(),'Regions')]");
    static private By RegionsListPage=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]");
    static private By EditRegionDetails=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By ApprovalWorkflowLink=By.xpath("//a[contains(text(),'Approval Workflow')]");




    public static boolean VerifyRegionsPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        if (GetElementText(driver,RegionsAssert).contentEquals("REGIONS")) {
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

    public static boolean SearchAndClickOnRegion(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        boolean Status = false;
        //---Click on SiteAdmin > Region Link on menu option
        clickOnElement(driver,SiteAdminLink);
        clickOnElement(driver,RegionLink);
        Thread.sleep(1000);
        //---Search required region on Region list page
        if(VerifyRegionsPageAssert(driver)==true) {
            int NoOfResult = SizeOfTheElement(driver, RegionsListPage);
            for (int i = 0; i <= NoOfResult-1; i++) {

                if (GetMultipleElementList(driver,RegionsListPage).get(i).getText().contentEquals(SearchColumnText("RegionName"))) {
                    //---Required region name found, click on edit button
                    GetMultipleElementList(driver,EditRegionDetails).get(i-1).click();
                    Thread.sleep(2000);
                    String PageTitle = GetPageTitle(driver);
                    if (PageTitle.contentEquals("Update")){
                        Status = true;
                        ReportEvent("Pass","Verify Region update page","Region details update page opened successfully ");
                    }else {
                        ReportEvent("Fail","Verify Region update page"," Assert verification failed for Region details update Page ");
                    }
                    break;
                }
            }
        }
        return Status;
    }


    public static boolean NavigateToApprovalWorkflowPage(WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        boolean Status = false;
        if (SizeOfTheElement(driver,ApprovalWorkflowLink) > 0) {
            //Click on Approval workflow link
            clickOnElement(driver, ApprovalWorkflowLink);
            Thread.sleep(2000);
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Approval Workflow")){
                Status = true;
                ReportEvent("Pass","Verify Approval Workflow page","Approval Workflow setup page opened successfully ");
            }else {
                ReportEvent("Fail","Verify Approval Workflowpage"," Assert verification failed for Approval Workflow Page ");
            }
        }
        return Status;
    }

}
