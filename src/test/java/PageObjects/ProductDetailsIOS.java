package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProductDetailsIOS implements ProductDetails{
	public ProductDetailsIOS(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	 @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	    private MobileElement addtobasket;
	 
	 @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	    private MobileElement dresssize;
	 
	 @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	    private MobileElement basketbutton;
	 
	public void selectdresssize() {
		addtobasket.tap(1, 2000);
		dresssize.tap(1, 2000);
		Reporter.log("User selects the dress size");
	}

	public void Addproducttobasket() {
		basketbutton.tap(1, 2000);	
		Reporter.log("User tries to add product in basket");
	}
}
