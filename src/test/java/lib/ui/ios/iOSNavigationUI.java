package lib.ui.android;

import io.appium.java_client.android.AndroidDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI
{
    static
    {
        NAVIGATE_UP = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }
    public iOSNavigationUI(RemoteWebDriver driver)
    {
        super((AndroidDriver) driver);
    }

}
