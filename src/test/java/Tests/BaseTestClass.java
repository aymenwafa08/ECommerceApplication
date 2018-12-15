package Tests;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import PageObjects.ProductAddedtoBasket;
import PageObjects.ProductAddedtoBasketAndroid;
import PageObjects.ProductDetails;
import PageObjects.ProductDetailsAndroid;
import PageObjects.Products;
import PageObjects.ProductsAndroid;
import PageObjects.SelectCategory;
import PageObjects.SelectCategoryAndroid;



public class BaseTestClass extends AppiumBaseClass{
	SelectCategory selectcategory;
	Products products;
	ProductDetails productdetails;
	ProductAddedtoBasket productinbasket;
	
@BeforeTest
public void setUp() throws Exception {
	 Reporter.log("AppiumDriver initialization");
	 AppiumController.instance.start();
	 switch (AppiumController.executionOS) {
	 case ANDROID:
     case ANDROID_BROWSERSTACK:
     Reporter.log("Android implementation invoked");
      selectcategory = new SelectCategoryAndroid(driver());
      products = new ProductsAndroid(driver());
      productdetails = new ProductDetailsAndroid(driver());
      productinbasket = new ProductAddedtoBasketAndroid(driver());
         break;
     case IOS:
     case IOS_BROWSERSTACK:
    	 Reporter.log("IOS implementation Invoked");
         break;
	 }
}

@AfterSuite
public void close() throws Exception {
	Reporter.log("AppiumDriver closed");
	//AppiumController.instance.stop();
}
}