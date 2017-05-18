package PageObject.SalesPeoplePackage;

import GenericLib.ObjectRepository;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.ActionKeywords.GetElementText;
import static GenericLib.ActionKeywords.GetPageTitle;
import static GenericLib.DataDriven.ActualLable;
import static GenericLib.DataDriven.ExpectedLable;

/**
 * Created by t.mirasipally on 15-Feb-17.
 */
public class SalesPeoplePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By SalesPeoplesAssert= By.xpath("//tbody/tr/td[@class='ListHeader']/b");


    public static boolean VerifySalesPeoplePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Sales People page is opened or not ?");
        if (GetElementText(driver,SalesPeoplesAssert).contentEquals("SALES PEOPLE")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Sales People")) {
                Status = true;
                ActualLable("successfully verified Assert for Sales People Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Sales People Page ", "Fail");
            }
        } else {
            ActualLable("Sales People page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
