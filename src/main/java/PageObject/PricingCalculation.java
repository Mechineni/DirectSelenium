package PageObject;

import PageObject.BuyerDetailsPackage.MaintenanceServicesSetUpPage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static GenericLib.DataDriven.ReportEvent;
import static GenericLib.DataDriven.SearchColumnText;

/**
 * Created by t.mirasipally on 27-Feb-17.
 */
public class PricingCalculation {


    public static double UnitPriceCalculation(WebDriver driver) {
        double ListPrice=  516.64;
        double DiscountListRate= 0;
        double Surcharge=1.5;
        double Discount = ListPrice*(1 - (DiscountListRate/100));
        double ListFactor = ListPrice*Surcharge/100;
        double DiscountedByPrice = Discount+ListFactor;
        double CostFactor1=1.5;
        double CostFactor2=1.5;
        double CostFactor3=1.5;
        double CostFactor4=1.5;
        double CostFactor5=1.5;
        double CostFactor1Value = DiscountedByPrice*CostFactor1/100;
        double CostFactor2Value = DiscountedByPrice*CostFactor2/100;
        double CostFactor3Value = DiscountedByPrice*CostFactor3/100;
        double CostFactor4Value = DiscountedByPrice*CostFactor4/100;
        double CostFactor5Value = DiscountedByPrice*CostFactor5/100;
        double CostOFItem = DiscountedByPrice+CostFactor1Value+CostFactor2Value+CostFactor3Value+CostFactor4Value+CostFactor5Value;
        double Margin = 25;
        double UnitPrice = CostOFItem/(1- (Margin/100));
        double FinalUnitPrice = Math.round(UnitPrice * 100.0) / 100.0;

        return FinalUnitPrice;
    }

    public static void UMVCalculationsVerification(WebDriver driver) throws WriteException, IOException, BiffException {

        Double[] HardWareValues = MaintenanceServicesSetUpPage.GetQuoteValuesForUMVHardware(driver);
        Double ListPriceOfHardWare = HardWareValues[0];
        Double UnitPriceOfHardWare = HardWareValues[1];
        Double CostPriceOfHardWare = HardWareValues[2];
        Double[] ActualServicesValues = MaintenanceServicesSetUpPage.GetQuoteValuesForUMVService(driver);
        String DefaultSellPercentage =SearchColumnText("SellValue");
        String DefaultCostPercentage =SearchColumnText("DefaultPercent");
        String DefaultCostFactor =SearchColumnText("DefaultCostFactor");
        String SecondYearDiscount =SearchColumnText("YearTwoDis");
        String YearThreeDiscount =SearchColumnText("YearThreeDis");

        Double ExpectedDiscountedListPriceForOneYears = null;
        Double ExpectedDiscountedListPriceForTwoYears = null;
        Double ExpectedDiscountedListPriceForThreeYears = null;
        Double ExpectedDiscountedListPriceForFourYears;
        Double ExpectedDiscountedListPriceForFiveYears;

        if(SearchColumnText("SellMethod").contentEquals("Percentage of Technology List Price")){
            if (SearchColumnText("UMVNumberOfMonths").contentEquals("12")) {
                //Discounted List Price for service
                ExpectedDiscountedListPriceForOneYears=ListPriceOfHardWare;
                if (ExpectedDiscountedListPriceForOneYears == Math.round(ActualServicesValues[0] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'Discounted List Price Of Uptime service' value", " Verified Successfully, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                } else {
                    ReportEvent("Fail", "Verify 'Discounted List Price Of Uptime service' value", " Verification failed, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                }
                //Unit Price of the Uptime Service
                Double UnitPriceOfUptimeservice = Math.round((ListPriceOfHardWare * Double.parseDouble(DefaultSellPercentage) / 100) * 100.0) / 100.0;
                if (UnitPriceOfUptimeservice == Math.round(ActualServicesValues[1] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'UnitPrice Of Uptime service' value", " Verified Successfully, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                } else {
                    ReportEvent("Fail", "Verify 'UnitPrice Of Uptime service' value", " Verification failed, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                }
            }else if (SearchColumnText("UMVNumberOfMonths").contentEquals("24")) {
                //Discounted List Price for service
                ExpectedDiscountedListPriceForTwoYears = Math.round(ListPriceOfHardWare * (1 - Double.parseDouble(SecondYearDiscount) / 100) * 100.0) / 100.0;
                if (ExpectedDiscountedListPriceForTwoYears == Math.round(ActualServicesValues[0] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'Discounted List Price Of Uptime service' value", " Verified Successfully, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                } else {
                    ReportEvent("Fail", "Verify 'Discounted List Price Of Uptime service' value", " Verification failed, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                }
                //Unit Price of the Uptime Service
                Double UnitPriceOfUptimeservice = Math.round((ExpectedDiscountedListPriceForTwoYears * Double.parseDouble(DefaultSellPercentage) / 100) * 100.0) / 100.0;
                if (UnitPriceOfUptimeservice == Math.round(ActualServicesValues[1] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'UnitPrice Of Uptime service' value", " Verified Successfully, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                } else {
                    ReportEvent("Fail", "Verify 'UnitPrice Of Uptime service' value", " Verification failed, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                }
            }else if (SearchColumnText("UMVNumberOfMonths").contentEquals("36")) {
                //Discounted List Price for service
                ExpectedDiscountedListPriceForThreeYears = Math.round(ListPriceOfHardWare * (1 - Double.parseDouble(YearThreeDiscount) / 100) * 100.0) / 100.0;
                if (ExpectedDiscountedListPriceForThreeYears == Math.round(ActualServicesValues[0] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'Discounted List Price Of Uptime service' value", " Verified Successfully, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                } else {
                    ReportEvent("Fail", "Verify 'Discounted List Price Of Uptime service' value", " Verification failed, Actual Discounted List Price Of Uptime service :" + ActualServicesValues[0] + " Expected UnitPrice Of Uptime service :" + ListPriceOfHardWare);
                }
                //Unit Price of the Uptime Service
                Double UnitPriceOfUptimeservice = Math.round((ExpectedDiscountedListPriceForThreeYears * Double.parseDouble(DefaultSellPercentage) / 100) * 100.0) / 100.0;
                if (UnitPriceOfUptimeservice == Math.round(ActualServicesValues[1] * 100.0) / 100.0) {
                    ReportEvent("Pass", "Verify 'UnitPrice Of Uptime service' value", " Verified Successfully, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                } else {
                    ReportEvent("Fail", "Verify 'UnitPrice Of Uptime service' value", " Verification failed, Actual UnitPrice Of Uptime service :" + ActualServicesValues[1] + " Expected UnitPrice Of Uptime service :" + UnitPriceOfUptimeservice);
                }
            }
            //For different Cost methods
            if(SearchColumnText("CostMethod").contentEquals("Percentage of Technology Sell Price")) {
                if (SearchColumnText("UMVNumberOfMonths").contentEquals("12")) {
                    Double ExpectedCostPriceOfUptimeservice = Math.round((UnitPriceOfHardWare) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("24")) {
                    Double DiscountedUnitPriceOfHardware = Math.round((UnitPriceOfHardWare)*(1-Double.parseDouble(SecondYearDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round(DiscountedUnitPriceOfHardware * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("36")) {
                    Double DiscountedUnitPriceOfHardware = Math.round((UnitPriceOfHardWare)*(1-Double.parseDouble(YearThreeDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round((DiscountedUnitPriceOfHardware) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                }
            }else if(SearchColumnText("CostMethod").contentEquals("Percentage of Technology List Price")){
                if (SearchColumnText("UMVNumberOfMonths").contentEquals("12")) {
                    Double ExpectedCostPriceOfUptimeservice = Math.round((ExpectedDiscountedListPriceForOneYears) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("24")) {
                    Double ExpectedCostPriceOfUptimeservice = Math.round((ExpectedDiscountedListPriceForTwoYears) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("36")) {
                    Double ExpectedCostPriceOfUptimeservice = Math.round((ExpectedDiscountedListPriceForThreeYears) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                }
            }else if(SearchColumnText("CostMethod").contentEquals("Percentage of Technology Landed Cost")){
                if (SearchColumnText("UMVNumberOfMonths").contentEquals("12")) {

                    Double ExpectedCostPriceOfUptimeservice = Math.round((CostPriceOfHardWare) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("24")) {
                    Double DiscountedCostPriceOfHardware = Math.round((CostPriceOfHardWare)*(1-Double.parseDouble(SecondYearDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round((DiscountedCostPriceOfHardware) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("36")) {
                    Double DiscountedCostPriceOfHardware = Math.round((CostPriceOfHardWare)*(1-Double.parseDouble(YearThreeDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round((DiscountedCostPriceOfHardware) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                }
            }else if(SearchColumnText("CostMethod").contentEquals("Contract Uptime Margin")){
                if (SearchColumnText("UMVNumberOfMonths").contentEquals("12")) {

                    Double ExpectedCostPriceOfUptimeservice = Math.round((CostPriceOfHardWare) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("24")) {
                    Double DiscountedCostPriceOfHardware = Math.round((CostPriceOfHardWare)*(1-Double.parseDouble(SecondYearDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round((DiscountedCostPriceOfHardware) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                } else if (SearchColumnText("UMVNumberOfMonths").contentEquals("36")) {
                    Double DiscountedCostPriceOfHardware = Math.round((CostPriceOfHardWare)*(1-Double.parseDouble(YearThreeDiscount)/100)* 100.0) / 100.0;
                    Double ExpectedCostPriceOfUptimeservice = Math.round((DiscountedCostPriceOfHardware) * (Double.parseDouble(DefaultCostPercentage) / 100) * (1 + Double.parseDouble(DefaultCostFactor) / 100) * 100.0) / 100.0;
                    if (ExpectedCostPriceOfUptimeservice == Math.round(ActualServicesValues[2] * 100.0) / 100.0) {
                        ReportEvent("Pass", "Verify 'Cost Price Of Uptime service' value", " Verified Successfully, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    } else {
                        ReportEvent("Fail", "Verify 'Cost Price Of Uptime service' value", " Verification failed, Actual Cost Price Of Uptime service :" + ActualServicesValues[2] + " Expected Cost Price Of Uptime service :" + ExpectedCostPriceOfUptimeservice);
                    }
                }
            }
        }else if(SearchColumnText("SellMethod").contentEquals("Percentage of Technology List Price")){

        }

    }

}
