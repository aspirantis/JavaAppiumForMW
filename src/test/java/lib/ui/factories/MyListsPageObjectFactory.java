package lib.ui.factories;

import io.appium.java_client.android.AndroidDriver;
import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidMyListsPageObject;
import lib.ui.android.iOSMyListsPageObject;
import lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MyListsPageObjectFactory
{
    public static MyListsPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidMyListsPageObject(driver);
        } else
        {
            return new MWMyListsPageObject(driver);
        }
    }
}
