package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProductAddedtoBasketIOS implements ProductAddedtoBasket{
	public ProductAddedtoBasketIOS(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
	 @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
	    private MobileElement successmessage;
	 
	public void productinCart(String expectedmessage) {
		String actualmessage= successmessage.getText();
		Assert.assertEquals(actualmessage, expectedmessage);
		Reporter.log("Product is successfully added to basket");
	}
}
