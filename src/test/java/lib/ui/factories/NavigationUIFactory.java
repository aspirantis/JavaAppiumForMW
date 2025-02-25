package lib.ui.factories;

import io.appium.java_client.android.AndroidDriver;
import lib.Platform;
import lib.ui.NavigationUI;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.android.iOSNavigationUI;
import lib.ui.ios.iOSSearchPageObject;
import lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidNavigationUI(driver);
        } else
        {
            return new MWNavigationUI(driver);
        }
    }
}
