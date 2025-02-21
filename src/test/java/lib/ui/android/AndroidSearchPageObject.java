package lib.ui.android;

import io.appium.java_client.android.AndroidDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_SKIP_ELEMENT = "id:org.wikipedia:id/fragment_onboarding_skip_button";
        SEARCH_INPUT = "id:org.wikipedia:id/search_container";
        SEARCH_TEXT = "id:org.wikipedia:id/search_src_text";
        SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
        //SEARCH_RESULT_BY_SUBSTRING_TPL = "//android.widget.TextView[contains(@text, '{SUBSTRING}')]",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']" +
        "[.//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{TITLE}']]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']" +
        "/*[.//*[@resource-id='org.wikipedia:id/page_list_item_title' and normalize-space(@text)='{TITLE}'] " +
        "and .//*[@resource-id='org.wikipedia:id/page_list_item_description' and normalize-space(@text)='{DESCRIPTION}']]";
        SEARCH_RESULT_ELEMENT = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[contains(@resource-id, 'org.wikipedia:id/results_text') and contains(@text, 'No results')]";
    }


    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
