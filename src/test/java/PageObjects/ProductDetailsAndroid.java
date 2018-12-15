package PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsAndroid implements ProductDetails{
	public ProductDetailsAndroid(AppiumDriver driver) {
	    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
@AndroidFindBy(xpath="//*[@text='14']")
private MobileElement dresssize;

@AndroidFindBy(id="com.landmarkgroup.splashfashions:id/addToBasket")
private MobileElement addtobasket;

@AndroidFindBy(xpath="//*[@text='ADD TO BASKET']")
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
