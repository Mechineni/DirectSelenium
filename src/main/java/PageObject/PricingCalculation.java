package PageObject;

import org.openqa.selenium.WebDriver;

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
}
