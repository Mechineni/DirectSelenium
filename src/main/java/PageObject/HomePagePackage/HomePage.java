package PageObject.HomePagePackage;

import GenericLib.ObjectRepository;
import PageObject.OrdersPackage.BT_ServiceRequestsPage;
import PageObject.OrdersPackage.OrdersDocumentSearchPage;
import PageObject.OrdersPackage.UploadPurchaseOrderPage;
import PageObject.OrdersPackage.ViewShipmentStatusDetailsPage;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

import static GenericLib.ActionKeywords.*;
import static GenericLib.DataDriven.*;

/**
 * Created by t.mirasipally on 14-Feb-17.
 */
public class HomePage {
    static private ObjectRepository obje = new ObjectRepository();
    static private WebDriver driver;

    //PageElements
    static private By WelcomeField = By.id("Welcome");
    static private By MenusOnHomePagesss = By.xpath("//td[@id='DirectMenus']/ul/li/a");




    public static void VerifyHomePageAssert(WebDriver driver) throws InterruptedException, IOException, WriteException {
        ExpectedLable("Verify that Home opened or not ?");
        if(SizeOfTheElement(driver,WelcomeField) > 0) {
            System.out.print("entered");
            String PageTitle = GetPageTitle(driver);
            if(PageTitle.contentEquals("Home")){
                ActualLable("successfully verified Assert for Home Page ","Pass");
            }else{ActualLable(" Assert verification failed for Home Page ","Fail");}
        }else{ActualLable("Home page is not Loaded Properly","Fail");}
    }
    public static void SelectOptionsUnderQuotes(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Verifying links");
        Thread.sleep(20000);
        for(int i=1;i<=5;i++) {
            for (int j = 1; j <= 5; j++) {
                By QuotesMenu = By.xpath("//td[@id='DirectMenus']/ul/li["+i+"]/a");
                By OptionsQuotesMenu = By.xpath("//td[@id='DirectMenus']/ul/li["+i+"]/ul/li[" + j + "]");

                Thread.sleep(1000);
                clickElement(driver, QuotesMenu);
                //waitForOneSec();
                String Opti = GetElementText(driver, OptionsQuotesMenu);
                Thread.sleep(1000);
                clickOnElement(driver, OptionsQuotesMenu,"on ' " + Opti + " ' under Quote menu");
                //MouseHoverActionPerform(driver,QuotesMenu,OptionsQuotesMenu);
                /*if (j == 1) {
                    CreateQuotePage.VerifyCreateQuotePageAssert(driver);
                }
                if (j == 2) {
                    CreateQuoteGAP_IAP.VerifyCreateQuoteGAPPageAssert(driver);
                }
                if (j == 3) {
                    RevisionRequestedPage.VerifyRevisionrequestedPageAssert(driver);
                }
                if (j == 4) {
                    QuotesDocumentSearchPage.VerifyQuotesDocSearchPageAssert(driver);
                }
                if (j == 5) {
                    OpportunityRefManagementPage.VerifyOppRefPageAssert(driver);
                }*/
            }
        }
    }
    public static void SelectOptionsUnderOrders(WebDriver driver) throws InterruptedException, IOException, WriteException {
        StepLable("Verifying links");
        Thread.sleep(10000);
        for(int j=1;j<=4;j++) {
            By OrdersMenu =  By.xpath("//td[@id='DirectMenus']/ul/li[2]/a");
            By OptionsOrdersMenu = By.xpath("//td[@id='DirectMenus']/ul/li[2]/ul/li["+j+"]");
            clickElement(driver,OrdersMenu);
            Thread.sleep(1000);
            String Opti = GetElementText(driver,OptionsOrdersMenu);
            Thread.sleep(1000);
            clickOnElement(driver,OptionsOrdersMenu,"on ' "+Opti+" ' under Quote menu");

            //MouseHoverActionPerform(driver,OrdersMenu,OptionsOrdersMenu);
            if(j==1){   OrdersDocumentSearchPage.VerifyOrdersDocumentSearchPageAssert(driver); }
            if(j==2){   ViewShipmentStatusDetailsPage.VerifyViewShipmentPageAssert(driver);    }
            if(j==3){   UploadPurchaseOrderPage.VerifyUploadPurchaseOrderPageAssert(driver);   }
            if(j==4){   BT_ServiceRequestsPage.VerifyBTSearviceRequestPageAssert(driver);      }
        }
    }
    public static void CheckAllTheLinks(WebDriver driver) throws InterruptedException, IOException, WriteException {
        String[] Menu01 ={"Create Quote","Create Quote - GAP & IAP","Revision Requested","Document Search","Opportunity Ref.Management"};
        String[] Menu02 ={"Document Search","View Shipment Status Details","Upload Purchase Order","BT Service Requests"};
        String[] Menu03 ={"Buyers>Create","Sales Team Admin>Upload Set Sales Team=Upload History>Find Sales Team Member>AUDIT","News>Create","DD Active>Create","Client Associations>Create"};
        String[] Menu04 ={"Staging Facilities>CREATE","Categories","Price Rules>Create"};
        String[] Menu05 ={"ERP Posting>Post Purchase Orders to ERP=History","Catalogs>Cross-Sell/Up-Sell Table>Copy To=Create=History>Manual Files>Create","Seller Roles>Create","Sales People>Create","Regions","Uptime Contract>Legacy Uptime Contract SLA>Uptime Contract (Multi-Vendor) Mappings","CMI Parent Child Relationship","Solution Type Assignments>Admin Audit>Create"};
        String[] Menu06 ={"Exchange Rate Calculator","Co-Brand/SIS98 Rules","Attach Rate Base SLAs>Add>Exceptions","Cisco UCSS Eligible Products>Create"};
        String[] Menu07 ={"All Reports","My Data"};
        ArrayList<java.lang.String[]> Menus=new ArrayList<java.lang.String[]>();
        Menus.add(Menu01);
        Menus.add(Menu02);
        Menus.add(Menu03);
        Menus.add(Menu04);
        Menus.add(Menu05);
        Menus.add(Menu06);
        Menus.add(Menu07);
        ArrayList<String> MenuMenuListArray = new ArrayList<String>();
        MenuMenuListArray.add("Quotes");
        MenuMenuListArray.add("Orders");
        MenuMenuListArray.add("Buyer Admin");
        MenuMenuListArray.add("S&I Admin");
        MenuMenuListArray.add("Site Admin");
        MenuMenuListArray.add("Global Admin");
        MenuMenuListArray.add("Reports");
        Thread.sleep(15000);
        for(int NoOfMenu=0;NoOfMenu<=6;NoOfMenu++ ) {
            StepLable("Verifying links on '"+MenuMenuListArray.get(NoOfMenu)+" ' Menu");
            ArrayList<String> ElementsName = new ArrayList<String>();
            int NoOfStrings = Menus.get(NoOfMenu).length;
            String[] menuTry=Menus.get(NoOfMenu);
            int ElementIndex =NoOfMenu+1;
            By MenuOptionXpath = By.xpath("//td[@id='DirectMenus']/ul/li["+ElementIndex+"]");
            for (int k = 0; k <= NoOfStrings - 1; k++) {
                ElementsName.add(menuTry[k]);
            }
            int lengthSubmenu = ElementsName.size();
            for(int NoOfSubMenu=0;NoOfSubMenu<=lengthSubmenu-1;NoOfSubMenu++) {
                int SubMenuElementIndex =NoOfSubMenu+1;
                By MainMenuOptionXpath = By.xpath("//td[@id='DirectMenus']/ul/li["+ElementIndex+"]/ul/li["+SubMenuElementIndex+"]");
                String MenuName = ElementsName.get(NoOfSubMenu);
                String MainMenuOptions = null;
                String SubLinks;
                String SubSubLinks;
                if (MenuName.contains(">")) {
                    String[] parts = MenuName.split(">");
                    ArrayList<String> BeforeSplitname = new ArrayList<String>();
                    int LengthBeforeSplitname = parts.length;
                    for (int i = 0; i < LengthBeforeSplitname; i++) {
                        BeforeSplitname.add(parts[i]);
                        System.out.println(parts[i]);
                    }
                    MainMenuOptions=BeforeSplitname.get(0);
                    for(int i=0;i<=LengthBeforeSplitname-1;i++){
                        String BeforeSplitnameStr = BeforeSplitname.get(i);
                        if(i==0){
                            Thread.sleep(1000);
                            clickOnElement(driver,MenuOptionXpath,MenuMenuListArray.get(NoOfMenu));
                            ExpectedLable("Click On ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page");
                            if(SizeOfTheElement(driver,MainMenuOptionXpath)>0){
                                Thread.sleep(1000);
                                clickElement(driver,MainMenuOptionXpath);
                                ActualLable("successfully Clicked on ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page","Pass");
                            }else{ActualLable("Element not found for ' "+MainMenuOptions+" '","Fail");}
                        }else {
                            if (BeforeSplitnameStr.contains("=")) {
                                String[] sndparts = BeforeSplitnameStr.split("=");
                                ArrayList<String> AfterSplitEquelSym = new ArrayList<String>();
                                int LengthAfterSplitEquelSym = sndparts.length;
                                for (int t = 0; t <=LengthAfterSplitEquelSym-1; t++) {
                                    AfterSplitEquelSym.add(sndparts[t]);
                                    System.out.println(sndparts[t]);
                                }
                                for(int k=0;k<=LengthAfterSplitEquelSym-1;k++) {
                                    SubLinks = AfterSplitEquelSym.get(0);
                                    SubSubLinks = AfterSplitEquelSym.get(k);
                                    if (k == 0) {
                                        Thread.sleep(1000);
                                        clickOnElement(driver, MenuOptionXpath,MenuMenuListArray.get(NoOfMenu));
                                        ExpectedLable("Click On ' " + MainMenuOptions + " ' under ' " + MenuMenuListArray.get(NoOfMenu) + " ' on Home Page");
                                        if (SizeOfTheElement(driver, MainMenuOptionXpath) > 0) {
                                            Thread.sleep(1000);
                                            clickElement(driver, MainMenuOptionXpath);
                                            ActualLable("successfully Clicked on ' " + MainMenuOptions + " ' under ' " + MenuMenuListArray.get(NoOfMenu) + " ' on Home Page", "Pass");
                                            By SubMenuXpath = By.xpath("//tbody/tr/td/a[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/a/b[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/b/a[contains(text(),'"+ SubLinks +"')]");
                                            ExpectedLable("Click On ' " + SubLinks + " ' under ' " + MainMenuOptions + " ' on Page");
                                            if (SizeOfTheElement(driver, SubMenuXpath) > 0) {
                                                Thread.sleep(1000);
                                                clickElement(driver, SubMenuXpath);
                                                ActualLable("successfully Clicked on ' " + SubLinks + " ' under ' " + MainMenuOptions + " 'on Page", "Pass");
                                            } else {   ActualLable("Element not found for ' " + SubLinks + " '", "Fail");    }
                                        } else {     ActualLable("Element not found for ' " + MainMenuOptions + " '", "Fail"); }
                                    } else {
                                        Thread.sleep(1000);
                                        clickOnElement(driver, MenuOptionXpath, MenuMenuListArray.get(NoOfMenu));
                                        ExpectedLable("Click On ' " + MainMenuOptions + " ' under ' " + MenuMenuListArray.get(NoOfMenu) + " ' on Home Page");
                                        if (SizeOfTheElement(driver, MainMenuOptionXpath) > 0) {
                                            Thread.sleep(1000);
                                            clickElement(driver, MainMenuOptionXpath);
                                            ActualLable("successfully Clicked on ' " + MainMenuOptions + " ' under ' " + MenuMenuListArray.get(NoOfMenu) + " ' on Home Page", "Pass");
                                            By SubMenuXpath = By.xpath("//tbody/tr/td/a[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/a/b[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/b/a[contains(text(),'"+ SubLinks +"')]");
                                            ExpectedLable("Click On ' " + SubLinks + " ' under ' " + MainMenuOptions + " ' Page");
                                            if (SizeOfTheElement(driver, SubMenuXpath) > 0) {
                                                Thread.sleep(1000);
                                                clickElement(driver, SubMenuXpath);
                                                ActualLable("successfully Clicked on ' " + SubLinks + " ' under ' " + MainMenuOptions + " ' Page", "Pass");
                                                By SubSubMenuXpath = By.xpath("//tbody/tr/td/a[contains(text(),'"+ SubSubLinks +"')]|//tbody/tr/td/a/b[contains(text(),'"+ SubSubLinks +"')]|//tbody/tr/td/b/a[contains(text(),'"+ SubSubLinks +"')]");
                                                ExpectedLable("Click On ' " + SubSubLinks + " ' under ' " + SubLinks + " ' Page");
                                                if (SizeOfTheElement(driver, SubSubMenuXpath) > 0) {
                                                    clickElement(driver, SubSubMenuXpath);
                                                    ActualLable("successfully Clicked on ' " + SubSubLinks + " ' under ' " + SubLinks + " 'on Page", "Pass");
                                                } else {    ActualLable("Element not found for ' " + SubSubLinks + " '", "Fail");    }
                                            } else { ActualLable("Element not found for ' " + SubLinks + " '", "Fail");                                          }
                                        } else {  ActualLable("Element not found for ' " + MainMenuOptions + " '", "Fail");  }
                                    }
                                }
                            } else {
                                SubLinks=BeforeSplitnameStr;
                                Thread.sleep(1000);
                                clickOnElement(driver,MenuOptionXpath,"' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page");
                                ExpectedLable("Click On ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page");
                                if(SizeOfTheElement(driver,MainMenuOptionXpath)>0){
                                    Thread.sleep(1000);
                                    clickElement(driver,MainMenuOptionXpath);
                                    ActualLable("successfully Clicked on ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page","Pass");
                                    By SubMenuXpath = By.xpath("//tbody/tr/td/a[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/a/b[contains(text(),'"+ SubLinks +"')]|//tbody/tr/td/b/a[contains(text(),'"+ SubLinks +"')]");
                                    ExpectedLable("Click On ' "+SubLinks+" ' under ' "+MainMenuOptions+" ' on Page");
                                    if(SizeOfTheElement(driver,SubMenuXpath)>0) {
                                        clickElement(driver, SubMenuXpath);
                                        ActualLable("successfully Clicked on ' " + NoOfMenu + " ' under ' " + MainMenuOptions + " 'on Page","Pass");
                                        if(i==1&&NoOfMenu==5&&SubLinks.contentEquals("Add")){
                                            Thread.sleep(2000);
                                            By PopUpXp = By.xpath("//table[@id='dialog']/tbody/tr/td/input[@id='1']");
                                            if(SizeOfTheElement(driver,PopUpXp)>0) {
                                                clickElement(driver, PopUpXp);}
                                        }
                                    }else{ActualLable("Element not found for ' "+SubLinks+" '","Fail");}
                                }else{ActualLable("Element not found for ' "+MainMenuOptions+" '","Fail");}
                            }
                        }
                    }
                }else{MainMenuOptions=MenuName;
                    Thread.sleep(1000);
                    clickOnElement(driver,MenuOptionXpath,"' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page");
                    ExpectedLable("Click On ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page");
                    if(SizeOfTheElement(driver,MainMenuOptionXpath)>0){
                        Thread.sleep(1000);
                        clickElement(driver,MainMenuOptionXpath);
                        ActualLable("successfully Clicked on ' "+MainMenuOptions+" ' under ' "+MenuMenuListArray.get(NoOfMenu)+" ' on Home Page","Pass");
                    }else{ActualLable("Element not found for ' "+MainMenuOptions+" '","Fail");}
                }
            }
        }
    }

}
