package lib.ui.android;

import io.appium.java_client.android.AndroidDriver;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static
    {
        READING_LIST_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{READING_LIST_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://android.view.ViewGroup[@resource-id='org.wikipedia:id/page_list_item_container' and .//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, '{TITLE}')]]";
    }

    public iOSMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
