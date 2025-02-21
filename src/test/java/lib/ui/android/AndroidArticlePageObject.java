package lib.ui.android;

import io.appium.java_client.android.AndroidDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        // TITLE1 = "//android.widget.TextView[@text='Java (programming language)']",
        TITLE1 = "xpath://android.widget.TextView[normalize-space(@text)='Java (programming language)']";
        TITLE2 = "xpath:(//android.widget.TextView[@text='Appium'])[1]";
        TITLE3 = "xpath://android.widget.TextView[@text='Appium']";
        FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']";
        SAVE_BUTTON ="id:org.wikipedia:id/page_save";
        ADD_TO_LIST_BUTTON ="id:org.wikipedia:id/snackbar_action";
        INPUT_READING_LIST_NAME = "id:org.wikipedia:id/text_input";
        INPUT_READING_LIST_DESCRIPTION = "id:org.wikipedia:id/secondary_text_input";
        OK_BUTTON = "id:android:id/button1";
        VIEW_LIST = "id:org.wikipedia:id/snackbar_action";
        SEARCH_FROM_ARTICLE = "id:org.wikipedia:id/page_toolbar_button_search";
}

public AndroidArticlePageObject(RemoteWebDriver driver)
{
    super((AndroidDriver) driver);
}
}