package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_SKIP_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:button#searchIcon";
        SEARCH_TEXT = "css:form>input[type='search]";
        SEARCH_CLOSE_BUTTON = "css:button.cancel";
        //SEARCH_RESULT_BY_SUBSTRING_TPL = "//android.widget.TextView[contains(@text, '{SUBSTRING}')]",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']" +
                "[.//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{TITLE}']]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']" +
                "/*[.//*[@resource-id='org.wikipedia:id/page_list_item_title' and normalize-space(@text)='{TITLE}'] " +
                "and .//*[@resource-id='org.wikipedia:id/page_list_item_description' and normalize-space(@text)='{DESCRIPTION}']]";
        SEARCH_RESULT_ELEMENT = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[contains(@resource-id, 'org.wikipedia:id/results_text') and contains(@text, 'No results')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
