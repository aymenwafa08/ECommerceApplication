package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsAndroid implements Products{
	
	public ProductsAndroid(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
@AndroidFindBy(id="com.landmarkgroup.splashfashions:id/image")
private MobileElement dress;

public void selectdress() {
	dress.tap(1, 2000);
	Reporter.log("user selects one dress");
}
}
