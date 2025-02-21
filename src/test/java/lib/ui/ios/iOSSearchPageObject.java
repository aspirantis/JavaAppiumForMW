package lib.ui.ios;

import io.appium.java_client.android.AndroidDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject
{
    static
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:deviceName", "iOSTestDevice");
        capabilities.setCapability("appium:platformVersion", "18.0");
        capabilities.setCapability("appium:app", "D:\\aspirantis\\JavaAppiumAutomation\\apks\\Wikipedia.app");
        capabilities.setCapability("appium:fullReset", true);
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
    }
    public iOSSearchPageObject(RemoteWebDriver driver) // тут надо заменить в будущем на AppiumDriver, конечно же
    {
        super(driver);
    }
}
