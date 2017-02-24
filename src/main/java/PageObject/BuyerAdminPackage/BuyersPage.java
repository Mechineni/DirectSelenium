package PageObject.BuyerAdminPackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;
import static GenericLib.DataDriven.SearchColumnText;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class BuyersPage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By BuyersAssert= By.xpath("//tr/td[@class='ListHeader']/b");
    static private By BuyerNameAssert=By.id("qbn");
    static private By BuyerNameSearchAssert=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[2]/a");
    static private By EditBuyerDetails=By.xpath("//td[@class='ListBorder']/table/tbody/tr/td[1]/a[1]");
    static private By BuyerAdminLink=By.xpath("//ul[@id='cssmenu1']/li[3]/a[contains(text(),'Buyer Admin')]");
    static private By BuyerLink=By.xpath("//ul[@id='cssmenu1']/li[3]/ul/li[1]/a[contains(text(),'Buyers')]");



    public static boolean VerifyBuyersPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Buyers page is opened or not ?");
        if (GetElementText(driver,BuyersAssert).contentEquals("BUYERS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Buyers")) {
                Status = true;
                ActualLable("successfully verified Assert for Buyers Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Buyers Page ", "Fail");
            }
        } else {
            ActualLable("Buyers page is not loaded Properly", "Fail");
        }
        return Status;
    }

    public static void ClickOnBuyerDetails(WebDriver driver)throws InterruptedException, IOException, WriteException, BiffException {
        waitForTwoSec();
        clickOnElement(driver,BuyerAdminLink);
        waitForTwoSec();
        clickOnElement(driver,BuyerLink);
        if(VerifyBuyersPageAssert(driver)==true) {
            ExpectedLable("Provide Buyer name in Buyer's Name field");
            sendInputData(driver, BuyerNameAssert).sendKeys(SearchColumnText("buyerName"));
            ActualLable("Buyer name entered successfully, Buyer name is" + SearchColumnText("buyerName"), "Pass");
            driver.findElement(By.id("SUBMIT1")).click();
            ExpectedLable("Verify that Buyers search success or not?");
            if (SizeOfTheElement(driver, BuyerNameSearchAssert) > 0) {
                boolean status = false;
                int NoOfResult = SizeOfTheElement(driver, BuyerNameSearchAssert);
                for (int i = 0; i <= NoOfResult-1; i++) {
                    int index=i+1;
                    if (GetMultipleElementList(driver, BuyerNameSearchAssert).get(i).getText().contentEquals(SearchColumnText("buyerName"))) {
                        ActualLable("successfully searched provided buyer ", "Pass");
                        status = true;
                        GetMultipleElementList(driver, EditBuyerDetails).get(i).click();
                        waitForTwoSec();
                        ExpectedLable("Verify that Buyer details update page opened successfully or not?");
                        String PageTitle = GetPageTitle(driver);
                        if (PageTitle.contentEquals("Update")){ ActualLable("Buyer details update page opened successfully ","Pass");
                        }else { ActualLable(" Assert verification failed for Buyers details update Page ", "Fail");
                        }
                        break;
                    }
                }
                if (status == false) {  ActualLable(" Buyer search not returned required results ", "Fail");  }
            } else {   ActualLable(" Buyer search not returned required results ", "Fail");  }
        }
    }



}
