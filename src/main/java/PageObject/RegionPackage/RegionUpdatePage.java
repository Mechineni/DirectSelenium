package PageObject.RegionPackage;

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
public class RegionUpdatePage {

    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;
    //PageElements
    static private By RegionsAssert= By.xpath("//tr/td[@class='ListHeader']/b");


    public static boolean VerifyRegionsPageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        boolean Status = false;
        ExpectedLable("Verify that Regions page is opened or not ?");
        if (GetElementText(driver,RegionsAssert).contentEquals("REGIONS")) {
            String PageTitle = GetPageTitle(driver);
            if (PageTitle.contentEquals("Regions")) {
                Status = true;
                ActualLable("successfully verified Assert for Regions Page ", "Pass");
            } else {
                ActualLable(" Assert verification failed for Regions Page ", "Fail");
            }
        } else {
            ActualLable("Regions page is not loaded Properly", "Fail");
        }
        return Status;
    }

}
