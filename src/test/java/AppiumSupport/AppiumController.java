package AppiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppiumController {
	//Browserstack setup
    private static String BS_USERNAME = "<your_browserstack_username>";
    private static String BS_ACCESSKEY = "<your_browserstack_accesskey>";
    private static String IOS_HASHED_APP_ID = "<your_ios_hashed_appid>";
    private static String ANDROID_HASHED_APP_ID = "<your_android_hashed_appid>";
    

    public static OS executionOS = OS.ANDROID;
    public enum OS {
        ANDROID,
        IOS,
        ANDROID_BROWSERSTACK,
        IOS_BROWSERSTACK
    }
    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;
   
    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch(executionOS){
            case ANDROID:
               /* File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/App/Android");
                File app = new File (appDir, "apkfile"); 
                 capabilities.setCapability("app", app.getAbsolutePath());*/
            	//Above lines of code will be used when we have apk file.Right now I dont have apk file
            	//so I am calling mobile app with package and activity name
                capabilities.setCapability("platformName", "Android"); 
                capabilities.setCapability("deviceName","HUAWEI Mate 10 Lite");
                //replace device name in above line
                capabilities.setCapability("appPackage", "com.landmarkgroup.splashfashions");
                capabilities.setCapability("appActivity", "com.landmarkgroup.landmarkshops.module.splash.activity.SplashActivityV2");
                capabilities.setCapability("noReset","true");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                Reporter.log("Android driver initialized");
                break;  
            case IOS:
             /* classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/App/iOS/");
                app = new File(appDir, ".appfile");
                capabilities.setCapability("app", app.getAbsolutePath()); */
            	//Above lines of code will be used when we have app file.
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                Reporter.log("IOS driver initialized");
                break;
            case ANDROID_BROWSERSTACK:
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "NotUsed");
                capabilities.setCapability("device", "Samsung Galaxy S8");
                capabilities.setCapability("os_version", "7.0");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + ANDROID_HASHED_APP_ID);
                driver = new AndroidDriver(new URL("https://" + BS_USERNAME + ":" + BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                Reporter.log("Android driver initialized in BrowserStack");
                break;
            case IOS_BROWSERSTACK:
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + IOS_HASHED_APP_ID);
                driver = new IOSDriver(new URL("https://" + BS_USERNAME + ":" + BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                Reporter.log("IOS driver initialized in BrowserStack");
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
