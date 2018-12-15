package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProductsIOS implements Products{

	public ProductsIOS(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
	 @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	    private MobileElement dress;
	 
	 public void selectdress() {
			dress.tap(1, 2000);
			Reporter.log("user selects one dress");
		}
}
