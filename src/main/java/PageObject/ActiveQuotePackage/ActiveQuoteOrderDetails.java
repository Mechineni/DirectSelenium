package PageObject.ActiveQuotePackage;

import GenericLib.ObjectRepository;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.SizeOfTheElement;
import static GenericLib.ActionKeywords.clickOnElement;
import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.StepLable;

/**
 * Created by Mamata.Mechineni on 01-Jun-17.
 */
public class ActiveQuoteOrderDetails {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //Page Elements
    //---Hyperlinks on Custom View section
    static private By DeleteItemsLink = By.xpath("//td[@id='BottomRow']/a[contains(text(),'Delete items')]");
    static private By DeleteItemsPopUpOKBtn = By.xpath("//td[@id='dialogBtns']/input[@value='OK']");

    //---Order Details page section
    static private By ItemsListActiveQuote = By.xpath("//td/input[@id='ln_sid']");
    static private By ActiveQuotePage = By.xpath("//td[@id='ItemHeaderNew']");
    static private By SelectAllCheckBox = By.xpath("//input[@name='chAll']");
    static private By MfrPartNumber= By.xpath("//td[@id='LineItem']/b[contains(text(),'Mfr Part #')]");

    public static void ClearItemsOnActiveQuote (WebDriver driver) throws InterruptedException, IOException, WriteException, BiffException {
        StepLable("Delete all items from the active quote");
        if (SizeOfTheElement(driver,MfrPartNumber)>0) {
            ReportEvent("Pass", "Items are available on active quote", "Active quote includes items which needs to be deleted");
            clickOnElement(driver, SelectAllCheckBox,"Select All Checkbox");
            clickOnElement(driver, DeleteItemsLink,"Delete Items Link on Quote page");
            Thread.sleep(2000);
            //--- Click on OK button on Delete items Pop up
            if (SizeOfTheElement(driver,DeleteItemsPopUpOKBtn)>0) {
                ReportEvent("Pass", "Delete items pop up dialog displayed", "Delete pop up displayed successfully");
                clickOnElement(driver, DeleteItemsPopUpOKBtn,"Ok Button on Delete Items PopUp");
                Thread.sleep(20000);
            }else {
                ReportEvent("Fail", "Delete items pop up dialog displayed", "Delete pop up not displayed");
            }
            //--- Verify that all items on quote page are deleted or not
            if (SizeOfTheElement(driver, MfrPartNumber) > 0) {
                ReportEvent("Fail", "Verify that all items on quote deleted", "All items from the quote are not deleted");
            } else {
                ReportEvent("Pass", "Verify that all items on quote deleted", "All items from the quote are deleted Successfully");
            }
        }else {
            ReportEvent("Pass", "Items are not available on active quote", "No items found on active quote");
        }
    }
}
