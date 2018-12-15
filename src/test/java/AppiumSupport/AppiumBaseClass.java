package AppiumSupport;

import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;

public abstract class AppiumBaseClass {
	
	protected AppiumDriver driver() {
		Reporter.log("Getting driver instance from Appium Controller class");
        return AppiumController.instance.driver;
        
    }
}
