package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductAddedtoBasketAndroid implements ProductAddedtoBasket{
	public ProductAddedtoBasketAndroid(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
	@AndroidFindBy(id="com.landmarkgroup.splashfashions:id/success_message")
	private MobileElement successmessage;
	
	public void productinCart(String expectedmessage) {
		String actualmessage= successmessage.getText();
		Assert.assertEquals(actualmessage, expectedmessage);
		Reporter.log("Product is successfully added to basket");
	}
}
