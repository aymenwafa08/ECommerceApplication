package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectCategoryAndroid implements SelectCategory{

	public SelectCategoryAndroid(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
@AndroidFindBy(id="com.landmarkgroup.splashfashions:id/leftBanner")
private MobileElement selectoption;


public void selectmenu() {
	selectoption.tap(1, 2000);
	Reporter.log("user selects first option for searching products");
}
}