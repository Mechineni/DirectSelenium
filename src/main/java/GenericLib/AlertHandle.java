package GenericLib;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHandle {


	Browser brow = new Browser();
	static Logger log = Logger.getLogger("Alert Handle page");

	public static boolean acceptAlert(WebDriver driver){
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
			return true;
		}catch (NoAlertPresentException Ex)
		{ return false;	}
	}

	//dismiss alert
	public static boolean dismissAlert(WebDriver driver){

		try {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
			return true;
		}catch (NoAlertPresentException Ex)
		{ return false; }
	}

	//Get Text from the perticuler Page
	public static boolean getText(WebDriver driver){
		try {
		Alert alt=driver.switchTo().alert();
		alt.getText();
			return true;
		}catch (NoAlertPresentException Ex)
		{ return false; }
	}

}
